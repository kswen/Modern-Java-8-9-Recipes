/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.panbhatt.modernjavarecipes.chap2.streams;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * This class will help us to know how to create Streams. 
 */
public class CreatingStreams {
    
    public static void main(String[] args) {
        
        String names[] = { "Ram", "Shyam"} ;
        // Stream.of 
        System.out.println(Stream.of("Ram", "shyam").collect(Collectors.joining("-")));
        System.out.println(Arrays.stream(names).collect(Collectors.joining("-")));
        // Stream.iterate
        System.out.println(Stream.iterate(BigInteger.TEN, n -> n.add(BigInteger.ONE)).limit(10).collect(Collectors.toList())) ;
        // Stream.generate
        System.out.println(Stream.generate(Math::random).limit(10).collect(Collectors.toList()));
        
        // Integer Stream / Long Stream. 
        System.out.println(IntStream.range(0, 15).boxed().collect(Collectors.toList())); 
        
        
    }
}
