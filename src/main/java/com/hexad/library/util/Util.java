package com.hexad.library.util;

import com.hexad.library.model.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Util {

    public static List<Book> bookList= new ArrayList<>(Arrays.asList(
            new Book(1,"The Lord of the Rings","J. R. R. Tolkien",2),
            new Book(2,"Harry Potter","J. K. Rowling",1),
            new Book(3,"The Tale of Peter Rabbit","Beatrix Potter",5)
    ));

}
