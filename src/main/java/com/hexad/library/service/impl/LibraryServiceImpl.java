package com.hexad.library.service.impl;

import com.hexad.library.exception.BookNotFoundException;
import com.hexad.library.model.Book;
import com.hexad.library.service.LibraryService;
import com.hexad.library.util.Util;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

public class LibraryServiceImpl implements LibraryService {


    public static List<Book> bookList= Util.bookList;
    public static List<Book> borrowedBookList=new ArrayList<>();

    @Override
    public void getBookList(Model model) throws BookNotFoundException {

    }

    @Override
    public void borrowBook(int bookId) throws BookNotFoundException {

    }

    @Override
    public void getBorrowedBookList(Model model) throws BookNotFoundException {

    }

    @Override
    public void returnBook(int bookId) throws BookNotFoundException {

    }
}
