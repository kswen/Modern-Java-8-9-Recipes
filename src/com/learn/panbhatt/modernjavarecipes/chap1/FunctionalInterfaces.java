/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.panbhatt.modernjavarecipes.chap1;

import java.util.stream.Stream;

/**
 * See https://blog.idrsolutions.com/2015/03/java-8-consumer-supplier-explained-in-5-minutes/
 * Functional INterface and how to use it. 
 */
public class FunctionalInterfaces {

    public static void main(String args[]) {

        String name = "PANKAJ BHATT" ;
        CheckMe checkMeImpl = (str)-> str + str ;
        System.out.println(testCompleted(name, checkMeImpl));
    }
    
    public static String testCompleted(String str, CheckMe cme) {
        return cme.checkme(str);
    }

    @FunctionalInterface
    public interface CheckMe {

        String checkme(String str);
    }

}
