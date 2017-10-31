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
import java.util.function.Consumer;

/**
 *
 * @author BHATTP7
 */
public class CollectionsIteration {
    
    public static void main(String[] args) {
        
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.putIfAbsent("ram", 23) ;
        map.putIfAbsent("shyaam", 29) ;
        map.putIfAbsent("pankaj", 39) ;
        
        List<Integer> listOfInt = Arrays.asList(10,20,304,50,66) ; 
        
        listOfInt.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer t) {
                System.out.println(t);
            }
        });
        listOfInt.forEach(System.out::println);
        
        // Similary for Map. 
        map.forEach((name,age) -> System.out.println("Name = " + name + " Age = " + age ));

        // REmember. Deferred execution e.g. loggin level info with Supplier interface. 
        
        
    }
}
