package com.hexad.library.controller;

import com.hexad.library.exception.BookNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller("/")
public class LibraryController {

    @GetMapping
    private String getBookList(Model model) throws BookNotFoundException{
        return "library-home";
    }

    @GetMapping("/books/borrow/{bookId}")
    private String borrowBook(@PathVariable(name="bookId") int bookId) throws BookNotFoundException{

        return "redirect:/";
    }

    @GetMapping("/books/borrow/list")
    private String getBorrowedBookList(Model model) throws BookNotFoundException{
        return "borrowed-book-list";
    }

    @GetMapping("/books/return/{bookId}")
    private String returnBorrowedBook(@PathVariable(name="bookId") int bookId) throws BookNotFoundException{
        return "redirect:/borrowed-book-list";
    }
}
