/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.panbhatt.modernjavarecipes.chap9.ConcurrencyParallelism;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Check Parallelims with stream. 
 * @author BHATTP7
 */
public class ParallelStream {
    
    public static void main(String[] args) {
        
        System.out.println("Stream is parallel = " + Stream.of(1,2,3,4,5).isParallel());
        List<Integer> list = Arrays.asList(1,2,3,4,5,6); 
        System.out.println("Integer list if parallel = " + list.stream().isParallel());
        // Create Parallel Stream. 
        System.out.println("Stream is parallel = " + Stream.of(1,2,3,4,5).parallel().isParallel());
        System.out.println("List Stream is parallel = " + list.parallelStream().isParallel());
        
        // Determine no of processors. 
        System.out.println("No of processors on my system = "+ Runtime.getRuntime().availableProcessors());
    }
}
