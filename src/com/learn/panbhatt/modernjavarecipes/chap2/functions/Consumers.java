/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.panbhatt.modernjavarecipes.chap2.functions;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 *
 * @author BHATTP7
 */
public class Consumers {

    public static void main(String args[]) {
        List<String> strings = Arrays.asList("Ram", "shyam", "Pankaj", "Bhatt");

        // All  3 are equal are equal.
        strings.forEach(new Consumer<String>() {
            @Override
            public void accept(String t) {
                System.out.print("  " + t);
            }
        });

        System.out.println("");
        strings.forEach(s -> System.out.print(s));   // Lambda expressions
        System.out.println("");
        strings.forEach(System.out::print);  // Method Reference 

        // It also has other fucntions like andThen for composition and BiConsumers are also there. 
        
    }
}
