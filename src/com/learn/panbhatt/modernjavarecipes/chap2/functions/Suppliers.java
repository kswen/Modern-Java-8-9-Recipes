/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.panbhatt.modernjavarecipes.chap2.functions;

import java.util.function.DoubleSupplier;
import java.util.logging.Logger;

/**
 *
 * @author BHATTP7
 */
public class Suppliers {
 
    public static void main(String ...args) {
        
        Logger logger = Logger.getLogger("...");
        DoubleSupplier ds = new DoubleSupplier() {
            @Override
            public double getAsDouble() {
                return Math.random();
            } 
        };
        
        ds = () -> Math.random(); 
        ds = Math::random; 
        
        // Above all are equal. 
        logger.info(ds.getAsDouble()+"" ) ;
        logger.info(ds.toString()) ;
        
    }
}
