package com.hexad.library.service;

import com.hexad.library.exception.BookNotFoundException;
import org.springframework.ui.Model;

public interface LibraryService {

    void getBookList(Model model) throws BookNotFoundException;
    void borrowBook(int bookId) throws BookNotFoundException;
    void getBorrowedBookList(Model model) throws BookNotFoundException;
    void returnBook(int bookId) throws BookNotFoundException;

}
