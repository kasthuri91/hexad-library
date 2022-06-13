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

        List<Book> updatedBookList= new ArrayList<>();
        bookList.forEach(book -> {
            if(book.getCopies()>0){
                updatedBookList.add(book);
            }
        });

        model.addAttribute("name","Welcome to hexad Library");
        model.addAttribute("bookList",updatedBookList);
        model.addAttribute("borrowedBookCount",borrowedBookList.size());
    }
    @Override
    public void borrowBook(int bookId) throws BookNotFoundException {

        Book borrowedBook=bookList.stream()
                .filter(book->bookId==book.getBookId())
                .findAny()
                .orElse(null);

        if(borrowedBookList.size()<2 && !borrowedBookList.contains(borrowedBook)){
            borrowedBookList.add(borrowedBook);
            bookList.stream()
                    .filter(book->bookId==book.getBookId())
                    .findAny()
                    .ifPresent(book -> {
                        if(book.getCopies()>0)
                            book.setCopies(book.getCopies()-1);
                    });
        }
    }

    @Override
    public void getBorrowedBookList(Model model) throws BookNotFoundException {
        model.addAttribute("name","Welcome to hexad Library");
        model.addAttribute("bookList",borrowedBookList);
    }
    @Override
    public void returnBook(int bookId) throws BookNotFoundException {

        Book returnBook=borrowedBookList.stream()
                .filter(book->bookId==book.getBookId())
                .findAny()
                .orElse(null);

        borrowedBookList.remove(returnBook);

        bookList.stream()
                .filter(book->bookId==book.getBookId())
                .findAny()
                .ifPresent(book -> book.setCopies(book.getCopies()+1));
    }
}
