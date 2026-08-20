package com.zerolabs.testjavajunk;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.nio.file.Files;
import java.util.LinkedList;
import java.util.List;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestJavaJunk {
    public static void main() {        
        String appPath = "";
        
        try { //Здесь я получаю путь к папке, из которой запущен jar.
            String jarPath = TestJavaJunk.class
            .getProtectionDomain()
            .getCodeSource()
            .getLocation()
            .toURI()
            .getPath();
    
            java.io.File jarFile = new java.io.File(jarPath);
            appPath = jarFile.getParent();
        } catch (java.net.URISyntaxException e) {
            System.out.println("Unable to determine JAR directory.");
            return;
        }
        
        Path jsonPath = Paths.get(appPath, "students_list.json");
        Reader jsonReader = null;
        
        try { 
            jsonReader = Files.newBufferedReader(jsonPath);
        }        
        catch(IOException ioe) {
            System.out.println("Unable to read students_list.json from " + appPath);
            return;
        }
        
        var studentsListType = new TypeToken<LinkedList<Student>>(){}.getType();
        Gson gson = new Gson();
        List<Student> students = gson.fromJson(jsonReader, studentsListType);
        
        students.stream()
            .peek(System.out::println)
            .map(Student::getBooks)
            .flatMap(bk -> bk.stream())
            .sorted()
            .distinct()
            .filter(bk -> bk.getReleaseYear() > 2000)
            .limit(3)
            .map(Book::getReleaseYear)
            .findAny().
            ifPresentOrElse(year -> System.out.println("Chosen book year is " + year), () -> System.out.println("Book not found"));
    }
}