/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.panbhatt.modernjavarecipes.chap8.datetime;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author BHATTP7
 */
public class DateParseAndFormat {
    
    public static void main(String[] args) {
        
        // Date Parseing and formatting. 
        LocalDateTime current = LocalDateTime.now(); 
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy @ HH:mm:SS") ;
        System.out.println("Date n Time in given format = " + current.format(dateTimeFormatter)); 
        
        String myFormatTime = current.format(dateTimeFormatter) ;
        System.out.println("Parsing this date " + myFormatTime);
        
        // Print Date in UTC. 
        ZonedDateTime zonedDateTime = ZonedDateTime.now() ;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyy/MMMM/dd hh:mm:ss a VV xxxxx") ;
        System.out.println("Print Date in UTC = " + zonedDateTime.format(dtf));  
        
        // Time Difference between dates. 
        LocalDateTime myBday = LocalDateTime.of(1985,Month.OCTOBER,8,6, 55,00);
        System.out.println("I am this much years old -> ");
        System.out.format(" Years = %d " , ChronoUnit.YEARS.between(myBday, current )); 
        System.out.format(" Months = %d " , ChronoUnit.MONTHS.between(myBday, current)); 
        
    }
}
