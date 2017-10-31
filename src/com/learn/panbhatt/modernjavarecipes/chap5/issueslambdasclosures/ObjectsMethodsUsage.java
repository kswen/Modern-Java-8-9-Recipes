/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.panbhatt.modernjavarecipes.chap5.issueslambdasclosures;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

/**
 *
 * @author BHATTP7
 */
public class ObjectsMethodsUsage {
    
    public static void main(String[] args) {
        
        
        // Use Objects Method inside the filtrs. 
        List<String> list = Arrays.asList("ram", "shyam", "bbb", null, "ccc" , "33" ,null ) ;
        System.out.println(list.stream().filter(Objects::nonNull).collect(Collectors.toList()));
        
        // Lambda expressions accessing outside variable. 
        List<Integer> intsList = Arrays.asList(3,4,5,6,6); 
        Integer total = 0 ; 
         // Below line would give an error. 
         //intsList.forEach(n -> total += n); 
         System.out.println("Total Sum would be " + intsList.stream().mapToInt(Integer::new).sum());
         
         // Generating streams of ints, longs, doubles. 
         Random r = new Random(); 
         System.out.println("  Printing Ints ->  ");
         r.ints().limit(5).forEach(System.out::println);
         System.out.println("  Printing Ints within a range ->  ");
         r.ints(5,10,20).forEach(System.out::println);
         
         // Additional interface in Map. 
         Map<Integer,Integer> map = new HashMap<Integer,Integer>(); 
         intsList.stream().mapToInt(Integer::new).forEach(n -> map.computeIfAbsent(n, (num) -> num*2));
         System.out.println("Map = " + map );
         
         
         
         
         
    }
}
