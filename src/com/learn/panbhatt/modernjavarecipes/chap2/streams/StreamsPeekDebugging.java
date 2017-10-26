/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.panbhatt.modernjavarecipes.chap2.streams;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 *
 * Peek Inside a stream. 
 */
public class StreamsPeekDebugging {
    public static void main(String[] args) {
        
        // Seeting inside the program before doing operations on them. 
        System.out.println("Total = "+ Stream.of(1,2,3,4,5,6).peek(System.out::println).map(n -> n*2).peek( n-> System.out.println("* 2 = "+ n)).count());
        
        // Getting streams out of Strings & p erofrm operations with them. 
        System.out.println("This 343 7667 sam67678ple string".codePoints().
                filter(Character::isAlphabetic).
                collect(StringBuilder::new, StringBuilder::appendCodePoint,StringBuilder::append).toString());
        
        
        String names[] = { "Ram", "Shyam","Pankaj", "Bhatt"} ; 
        System.out.println(Arrays.stream(names).findFirst().get());
        
    }
            
}
