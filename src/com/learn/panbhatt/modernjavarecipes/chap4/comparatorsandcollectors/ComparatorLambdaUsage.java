/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.panbhatt.modernjavarecipes.chap4.comparatorsandcollectors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import static java.util.Comparator.naturalOrder;
import java.util.List;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author BHATTP7
 */
public class ComparatorLambdaUsage {
    
    
    public static void main(String[] args) {
        
        List<String> names = Arrays.asList("Ram", "Shyam", "Pankaj", "krishna","Rahul");
        
        // Sorting using diff stream. 
        System.out.println(names.stream().map(String::toUpperCase).sorted().collect(toList()));
        System.out.println("");
        // Soritn using length. 
        System.out.println(names.stream().sorted((s1,s2) -> s1.length() - s2.length()  ).collect(toList()));
        System.out.println("");
        // Using Comparator
        System.out.println(names.stream().sorted(Comparator.comparingInt(String::length)  ).collect(toList()));
        System.out.println("");
        // Comparator on multiple conditions. 
        System.out.println(names.stream().sorted(naturalOrder()).sorted(Comparator.comparingInt(String::length)).collect(toList()));
        System.out.println("");
        // Using Comparing again with mulitple conditions. 
        System.out.println(names.stream().sorted(Comparator.comparingInt(String::length).thenComparing(naturalOrder())).collect(toList()));
        System.out.println("");
        
        // Soring a list of employees. 
        List<Employee> employees = new ArrayList<Employee>(); 
        employees.add(new Employee(10,"Ram")) ;
        employees.add(new Employee(1,"Shyam")) ;
        employees.add(new Employee(15,"Pankaj")) ;
        employees.add(new Employee(9,"Krishna")) ;
        
        System.out.println(employees.stream().sorted(Comparator.comparingInt(Employee::getAge).thenComparing(Employee::getName)).collect(toList()));
        System.out.println("");
        
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
