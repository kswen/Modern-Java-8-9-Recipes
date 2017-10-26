/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.panbhatt.modernjavarecipes.chap2.streams;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * Create Streams to collections. 
 */
public class ConvertingStreamstoCollections {
    
    public static void main(String[] args) {
        
        System.out.println(Stream.of("Ram", "Shyam").collect(Collectors.toList()));
        // Below line will give error. 
        //System.out.println(IntStream.of(1,2,3,4,5).collect(Collectors.toList()));
        System.out.println(IntStream.of(1,2,3,4,5).boxed().collect(Collectors.toList()));
        System.out.println(IntStream.of(1,2,3,4,5).mapToObj(Integer::valueOf).collect(Collectors.toList()));
        
        IntStream.of(4,5,6,4,34).toArray(); 
    }
}
