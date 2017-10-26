/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.panbhatt.modernjavarecipes.chap2.streams;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * Applying MAP FILTER REDUCE To Streams. 
 */
public class StreamsReduce {
 

    public static void main(String[] args) {
        String words[] = "The lazy brown fox jumps over the lazy dog.".split(" ") ;
        
        System.out.println(Stream.of(words).count());
        // Calculating differnt number of characters in the words. 
        System.out.println(Stream.of(words).map( s -> s.length()).distinct().collect(Collectors.toList()));
        // Add number of all chars in the String. 
        System.out.println(Arrays.stream(words).mapToInt(String::length).sum());
        
        // Use REduce Method
        System.out.println(Arrays.stream(words).reduce((x,y) -> x + " " + y ).get());
        // For Initial value in REducd, so that instead of 1,2 element this element and 1 elements is being passed. 
        System.out.println(Arrays.stream(words).reduce("Printing -> ", (x,y) -> x + " " + y ));
        // Adding elements
        System.out.println(Arrays.stream(words).reduce("Adding -> ", String::concat));
        // Another way of adding elelments. 
        System.out.println(Arrays.stream(words).collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString());
    }
    
    
}
