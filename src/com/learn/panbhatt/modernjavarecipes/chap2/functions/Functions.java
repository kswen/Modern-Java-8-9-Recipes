/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.panbhatt.modernjavarecipes.chap2.functions;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 * @author BHATTP7
 */
public class Functions {

    public static void main(String args[]) {
        
        List<String> names = Arrays.asList("AAAAAA", "BBBBBBB", "CCCC", "DDDDDD") ;
        
        // Below All are same. 
         Function<String,Integer> transformation = new Function<String,Integer>() {
            @Override
            public Integer apply(String t) {
                return t.length(); 
            }
             
         };
         
         System.out.println("");
         System.out.println(names.stream().map(transformation).collect(Collectors.toList())); 
         System.out.println("");
         System.out.println(names.stream().map(String::length).collect(Collectors.toList())); 
         System.out.println("");
         System.out.println(names.stream().map(s -> s.length()).collect(Collectors.toList())); 
         
    }
}
