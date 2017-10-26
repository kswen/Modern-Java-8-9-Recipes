/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.panbhatt.modernjavarecipes.chap2.functions;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author BHATTP7
 */
public class Predicates {
    
    public static void main(String args[]){
        List<String> names = Arrays.asList("AAAAAAA", "BBBBBBB", "CCCC", "DDDDDD") ;
        
        Predicate testLength = new Predicate<String>() {
            @Override
            public boolean test(String t) {
                if(t.length() >= 5)
                    return true; 
                else
                    return false; 
            }
        };
        
        // Both Predicates are same. 
        System.out.println("");
        System.out.println(names.stream().filter(testLength).collect(Collectors.joining(",")));
        System.out.println("");
        System.out.println(names.stream().filter(s -> s.length() >= 5).collect(Collectors.joining(",")));
        
        // Declare Predicates as Constants. 
        final Predicate<String> testNameStartWithA = s -> s.startsWith("A");
        final Predicate<String> testNameStartWithD = s -> s.startsWith("D");
        System.out.println("");
        System.out.println(names.stream().filter(testNameStartWithA).collect(Collectors.joining(",")));
        System.out.println(names.stream().filter(testNameStartWithD).collect(Collectors.joining(",")));
        
        // Add Predicates. OR / Negate
        System.out.println("");
        System.out.println(names.stream().filter(testNameStartWithA.and(testLength)).collect(Collectors.joining(",")));
        System.out.println("");
        System.out.println(names.stream().filter(testNameStartWithA.or(testLength)).collect(Collectors.joining(",")));
        System.out.println("");
        System.out.println(names.stream().filter(testNameStartWithA.negate()).collect(Collectors.joining(",")));
        
        
        
    }
     
}
