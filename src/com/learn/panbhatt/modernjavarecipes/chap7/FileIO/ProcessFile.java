/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.panbhatt.modernjavarecipes.chap7.FileIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.stream.Stream;

/**
 *
 * @author BHATTP7
 */
public class ProcessFile {

    public static void main(String[] args) throws IOException {

        // This will print top 10 lines whose length is greater then 20 sorted by natural order. 
        Files.lines(Paths.get("c:/temp/file.txt"))
                .filter(line -> line.length() > 200)
                .sorted(Comparator.naturalOrder())
                .limit(10)
                .forEach(System.out::println);

        // Process all the direcotries in a directory. 
        System.out.println("Directories start here -> ");
        Files.list(Paths.get("c:/temp")).filter((n) -> Files.isDirectory(n.toAbsolutePath())).forEach(System.out::println);

        // Process all the files in a directory. 
        System.out.println("Files start here -> ");
        Files.list(Paths.get("c:/temp")).filter((n) -> Files.isDirectory(n.toAbsolutePath()) == false).forEach(System.out::println);

        // Walk the filesystem. using Depth First algorithm. 
        System.out.println("\n\n Depth First Search ");
        try (Stream<Path> files = Files.walk(Paths.get("c:/temp"))) {
            files.forEach(System.out::println);

        } catch (IOException ioEx) {
            ioEx.printStackTrace();
        }
        
        // Searching the file System for anything. Just apply the conditions in BiPredicate below. 
        System.out.println("\n\n Only Directories at all level ");
        Files.find(Paths.get("c:/temp"), Integer.MAX_VALUE, (path, attributes) -> attributes.isDirectory()).forEach(System.out::println);

    }
}
