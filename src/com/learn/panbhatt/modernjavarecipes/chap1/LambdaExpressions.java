/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.panbhatt.modernjavarecipes.chap1;

import java.io.File;
import java.util.Arrays;

/**
 *
 * Lambda Expression Usage. 
 */
public class LambdaExpressions {
    
    
    public static void main(String args[]) throws Exception{
        
        new Thread( () -> System.out.println("HELLO, I M printing from a thread")).start() ;
        
        // Assigining a function interafce
        Runnable r = () -> System.out.println("From a run method");
        new Thread(r).start(); 

        // Returning Value from the Lamda. 
        File f = new File("c:/temp");
        String files[] = f.list((dir,name) -> {
            return name.endsWith(".java") ; // Can do any calcuation here , simpley returning Return. 
        }); 
        System.out.println("List of files = " + Arrays.asList(files));
        
        
    }
}
