/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.panbhatt.modernjavarecipes.chap6.optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 *
 * @author BHATTP7
 */
public class OptionalUsage {
    
    
    public static void main(String[] args) {
        // Create the Optional thing. 
        Optional<Integer> intgrOptional = Optional.of(10);
        System.out.println(intgrOptional);
        
        intgrOptional = Optional.ofNullable(null) ;
        System.out.println(intgrOptional);
        
        // Getting Value
        AtomicInteger atomIntgr= new AtomicInteger(100); 
        Optional<AtomicInteger> optAtIngr = Optional.ofNullable(atomIntgr); 
        System.out.println(optAtIngr);
        
        System.out.println("Optional value is = " + optAtIngr.get());
        
        optAtIngr.ifPresent((val) -> System.out.println("If Present, value is = " + val));
        
        // Optional usage is best in getters of the beans, so that we do not return a null. 
        
        // use Map with Optionals. to transform thet value if present. 
        System.out.println(optAtIngr.map((i) -> { return i.get() ;} ));
        
        // use Map method of Optional to . 
        System.out.println("");
        List<Optional<Integer>> listInt = Arrays.asList(Optional.of(100),Optional.ofNullable(null),Optional.of(200),Optional.ofNullable(null)) ;

        
                
                
        
        
        
     
    }
    
    
}
