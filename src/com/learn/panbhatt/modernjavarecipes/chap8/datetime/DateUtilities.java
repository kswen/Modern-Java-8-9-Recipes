/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.panbhatt.modernjavarecipes.chap8.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 *
 * @author BHATTP7
 */
public class DateUtilities {
    
    public static void main(String[] args) {
        
        // Converting java.util.Date to new Java8 dates. 
        Date current = new Date(); 
        System.out.println(current.toInstant().atZone(ZoneId.systemDefault())); 
        LocalDate localdate = current.toInstant().atZone(ZoneId.systemDefault()).toLocalDate() ;
        LocalTime localTiem = current.toInstant().atZone(ZoneId.systemDefault()).toLocalTime(); 
        LocalDateTime localDateTime = current.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(); 
        
        // Getting Date java.util.date to java.sql.timestamp and then to from date-time
        System.out.println( (new java.sql.Date((new Date()).getTime())));
        java.sql.Timestamp timeStamp = new java.sql.Timestamp(current.getTime()); 
        System.out.println("Instant = " + timeStamp.toLocalDateTime() ) ;
        
        // Using java.util.Calendar
        Calendar cal = Calendar.getInstance(TimeZone.getDefault()) ;
        System.out.println("Calendar conversion to ZonedDateTime= " + cal.toInstant().atZone(ZoneId.systemDefault())); 
        
        
        
        
        
         
    }
}
