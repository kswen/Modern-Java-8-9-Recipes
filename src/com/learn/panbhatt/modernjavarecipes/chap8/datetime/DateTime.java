/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.panbhatt.modernjavarecipes.chap8.datetime;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * Use Java 8 New date/Time library. 
 * @author BHATTP7
 */
public class DateTime {
 
    public static void main(String[] args) {
        
        // Get the Time. 
        System.out.println(Instant.now());
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());
        System.out.println(ZonedDateTime.now());
        
        System.out.println("Creation of dates , Man Landing on Moon ");
        System.out.println("Date = " + LocalDate.of(1969, Month.JULY, 20));
        System.out.println("Time =  " + LocalTime.of(20,18, 59));
        System.out.println("Local Date Time = "+ LocalDateTime.of(LocalDate.MIN, LocalTime.MIN));
        
        // Using Zones. 
        LocalDateTime localDateTimeLandingMoon = LocalDateTime.of(1979,Month.JULY,20, 3,18,59) ;
        System.out.println("Moon Landing in New York ");
        ZonedDateTime zonedDateTime = localDateTimeLandingMoon.atZone(ZoneId.of("Europe/Moscow")) ;
        System.out.println("Time of Europe Moscow " + zonedDateTime); 
        System.out.println("Time at London "+ zonedDateTime.withZoneSameLocal(ZoneId.of("Europe/London")));
        
        // Using Periods. 
        Period period = Period.of(2, 3, 4); // 2 year 3 months 4 days. 
        LocalDateTime after2Years = localDateTimeLandingMoon.plus(period);  
        System.out.println("Äfter 2 yearse " + after2Years);
        
        // Format Dates. 
        DateTimeFormatter dtFormatter = DateTimeFormatter.ISO_DATE_TIME ;
        System.out.println("Formatting date = " + after2Years.format(dtFormatter)); 
        
        DateTimeFormatter customeFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("DD/MM/YYYY format = " + after2Years.format(customeFormat));
        
        // Change only one FIELD at a time. by using with Function().
        System.out.println("Change day of month to 21 =  " + after2Years.withDayOfMonth(21) );
        
        // Using Temporal Adjusters. 
        System.out.println("Get last day of  month = " + after2Years.with(TemporalAdjusters.lastDayOfMonth()));
        System.out.println("Get Next week thursday date = " + after2Years.with(TemporalAdjusters.next(DayOfWeek.THURSDAY)));
        
        
    }
}
