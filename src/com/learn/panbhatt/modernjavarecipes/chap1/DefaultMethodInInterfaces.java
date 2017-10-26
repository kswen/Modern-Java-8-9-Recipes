/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.panbhatt.modernjavarecipes.chap1;

/**
 *
 * @author BHATTP7
 */
public class DefaultMethodInInterfaces {

    public static void main(String args[]) {
        
        DefaultMethodInInterfaces example = new DefaultMethodInInterfaces(); 
        example.runTutorial();
        
    }
    
    public void runTutorial() {
          Go goObj = new GoImpl(); 
        goObj.run();
        goObj.runFast();
    }
    
     interface Go {
        
        default void run() {
            System.out.println("I am just running in default method. "); 
        }
        
        void runFast(); 
    }
    
    class GoImpl implements Go {

        @Override
        public void runFast() {
            System.out.println("I am running fast inside from GoImpl. ");
        }
        
    }

    
    


    

}
