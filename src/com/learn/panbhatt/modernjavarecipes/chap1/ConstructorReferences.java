/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.panbhatt.modernjavarecipes.chap1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * COnstructor References
 */
public class ConstructorReferences {
    
    
    public static void main(String args[]){
        
        List<String> list = Arrays.asList("RAM", "SHYAM", "PANKAJ", "BHATT");
        List<Person> personList = list.stream().map(name -> new Person(name)).collect(Collectors.toList()) ;
        personList.stream().forEach(System.out::println);
        System.out.println("");
        
        // Invoking New Manually. 
        personList = list.stream().map(Person::new).collect(Collectors.toList()) ;
        personList.stream().forEach(System.out::println);
        System.out.println("");
        
        // Copy Constructor
        Person me= new Person("Pankaj Bhatt");
        personList = Stream.of(me).map(Person::new).collect(Collectors.toList()); 
        personList.stream().forEach(System.out::println);
        System.out.println("");
        
    }
    
    private static class Person {
        private String name; 
        
        public Person(String name) {
            this.name = name ; 
        }
        public Person(){} 
        public Person(Person me) {
            this.name = me.name ;
        }

        @Override
        public String toString() {
            return "Person{" + "name=" + name + '}';
        }

        public String getName() {
            return name;
        }
        
        
        
    }
}


