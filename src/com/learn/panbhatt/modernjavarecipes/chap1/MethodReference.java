/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.panbhatt.modernjavarecipes.chap1;

import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 *
 * Method Reference Java
 * You want to use a method reference to access an existing method and treat it like a
lambda expression
 */
public class MethodReference {
    
    public static void main(String args[]) {
        // Printing a stream of char via method. 
        Stream.of(1,2,3,4,5).forEach((x) -> System.out.print(x + " ")); 
        System.out.println("");
        Stream.of(1,2,3,4,5).forEach(System.out::println); 
        System.out.println("");
        
        Consumer<Integer> consumer = System.out::print; //acting as a consumer. 
        Stream.of(1,2,3,4,5).forEach(consumer); 
        System.out.println("");
        
        // static method. 
        Stream.generate(Math::random).limit(5).forEach(System.out::println); 
        System.out.println("");
        
        // Class :: method
        Stream.of("Ram","Shyam","Pankaj","Rahul").map(String::length).forEach(System.out::println);
    }
}
