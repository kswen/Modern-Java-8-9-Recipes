/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.panbhatt.modernjavarecipes.chap5.issueslambdasclosures;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 *
 * @author BHATTP7
 */
public class ClosureComposition {

    public static void main(String[] args) {
        
        Function<Integer,Integer> sumFn = new Function<Integer,Integer>() { 
            @Override
            public Integer apply(Integer t) {
                return t + t; 
            }
            
        };
        
        Function<Integer,Integer> multFn = n -> n*10; 
        Function<Integer,Integer> multAndAdd = sumFn.compose(multFn) ;
        System.out.println(sumFn.compose(multFn).apply(5));  // call Multio and then call add
        System.out.println(multAndAdd.apply(10)); 
        
        System.out.println(sumFn.andThen(multFn).apply(4));  // call Sum first and then Multiply.
        
        // Predicate composition. 
        Predicate<Integer> checkDivisibleBy2  = n -> n%2 == 0 ;
        Predicate<Integer> checkDivisibleBy3  = n -> n%3 == 0 ;
        Predicate<Integer> divideBy2And3 = checkDivisibleBy2.and(checkDivisibleBy3) ;
        Predicate<Integer> divideBy2ButNot3 = checkDivisibleBy2.and(divideBy2And3.negate());
        
        System.out.println("6 divded by 2 n 3 " + divideBy2And3.test(6));  
        System.out.println("6 divded by 2 n not 3 " + divideBy2ButNot3.test(6));  
        
        
        
    }
    
}
