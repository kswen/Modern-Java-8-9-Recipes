/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.panbhatt.modernjavarecipes.chap4.comparatorsandcollectors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 * @author BHATTP7
 */
public class ConvertingStreamsToCollection {
 
    public static void main(String[] args) {
        
        List<String> names = Arrays.asList("ABC", "DEF","RAM", "SHYAM","ABC") ;
        
        // Get Diff collection from Stream. 
        // TO List - ArrayList by default
        List<String> nameList = names.stream().collect(Collectors.toList()) ;
        System.out.println(nameList);
        System.out.println("");
        // To Set  - Default to Hashset. 
        Set<String> nameSet = names.stream().collect(Collectors.toSet()) ;
        System.out.println(nameSet);
        System.out.println("");
        
        // TO LInkedList. 
        List<String> namesLinkeList = names.stream().collect(Collectors.toCollection(LinkedList::new));
        
        // To Array.
        String [] namesArray = names.stream().toArray(String[] :: new);
        
        // Get a Map. 
         List<Employee> employees = new ArrayList<Employee>(); 
        employees.add(new Employee(10,"Ram")) ;
        employees.add(new Employee(1,"Shyam")) ;
        employees.add(new Employee(15,"Pankaj")) ;
        employees.add(new Employee(9,"Krishna")) ;
        
        // Separte in Key value , both below statements are same. 
        Map<String,Employee> employeeMap = employees.stream().collect(Collectors.toMap(Employee::getName , e -> e));
        employeeMap = employees.stream().collect(Collectors.toMap(Employee::getName, Function.identity())) ;
        // If key is not unique. 
        Map<String,List<Employee>> employeeListMap = employees.stream().collect(Collectors.groupingBy(Employee::getName));
        
        // Sort a Map easily. 
        employeeMap.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .forEach(e -> System.out.println(e.getKey() + " = "+ e.getValue()));
        
        
        // Partioning of List in two maps, Similarly Group By can be done as shown above. 
        employees.add(new Employee(9,"Radhe")) ;
        Map<Boolean, List<Employee>> mapSortedByAge = employees.stream().
                                                      collect(Collectors.partitioningBy( en -> en.getAge() < 10));
        
        mapSortedByAge.forEach((k,v) -> System.out.println("KEY = "+ k + " Value = "+ v));
        
        // Use PostProcessors. 
        Map<Boolean, Long> mapSortedByAgeWithCount = employees.stream().
                                                      collect(Collectors.partitioningBy( en -> en.getAge() < 10,Collectors.counting()));
        System.out.println(" PostProcessor with counting ->  ");
        mapSortedByAgeWithCount.forEach((k,v) -> System.out.println("KEY = "+ k + " Value = "+ v));
        
        // Find Min n Max . 
        System.out.println("Find Min n Max in an stream ");
        Optional<Employee> minEmp = employees.stream().min((e1,e2) -> e1.getAge() - e2.getAge());
        System.out.println("Min Emp 1 = " + minEmp);
        minEmp = employees.stream().min(Comparator.comparingInt(Employee::getAge));
        System.out.println("Min Emp 2 = " + minEmp);
        Optional<Employee> maxEmp = employees.stream().reduce(BinaryOperator.maxBy(Comparator.comparingInt(Employee::getAge))) ;
        System.out.println("Max Emp = " + maxEmp);
        
        
        // Creatign Immutable collections. Java 7
        List<String> immutableNames = Collections.unmodifiableList(names);
        // With Java 8 you can do this by. 
        employees.stream().collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList) );
        
        
        
        
        
    }
    
    static class Employee {

        private int age;
        private String name;

        public Employee(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Employee{" + "age=" + age + ", name=" + name + '}';
        }

    }
}
