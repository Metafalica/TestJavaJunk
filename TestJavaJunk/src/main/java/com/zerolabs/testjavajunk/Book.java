package com.zerolabs.testjavajunk;

import java.util.Objects;

public class Book implements Comparable<Book> {
    private String name;
    private int pagesCount;
    private int releaseYear;
    
    public String getName() {
        return this.name;
    }
    
    public int getPagesCount() {
        return this.pagesCount;
    }
    
    public int getReleaseYear() {
        return this.releaseYear;
    }
    
    public Book(String name, int pagesCount, int releaseYear) {
        this.name = name;
        this.pagesCount = pagesCount;
        this.releaseYear = releaseYear;
    }
    
    @Override
    public int compareTo(Book bk) {
        if (bk == null)
            return -1;
        
        return Integer.compare(this.getPagesCount(), bk.getPagesCount());
    }
    
    @Override
    public boolean equals (Object testBookOrNot) {
        if (this == testBookOrNot)
            return true;
        
        if (testBookOrNot == null || this.getClass() != testBookOrNot.getClass())
            return false;
        
        Book testBook = (Book)testBookOrNot;
        boolean booksAreSame = Objects.equals(this.getName(), testBook.getName()) && 
                this.getPagesCount() == testBook.getPagesCount() &&
                this.getReleaseYear() == testBook.getReleaseYear();
        
        return booksAreSame;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getName(), Integer.toString(this.getPagesCount()), Integer.toString(this.getReleaseYear()));
    }
}