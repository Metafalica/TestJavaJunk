package com.zerolabs.testjavajunk;

import java.util.List;
import java.util.LinkedList;

public class Student {
    private String name;
    private List<Book> books;
    
    public String getName() {
        return this.name;
    }
    
    public List<Book> getBooks() {
        return this.books;
    }
    
    public Student()
    {
        this.books = new LinkedList();
    }
    
    public Student(String name) {
        this.name = name;
        this.books = new LinkedList();       
    }
    
    @Override
    public String toString() {
        return this.name;
    }
}