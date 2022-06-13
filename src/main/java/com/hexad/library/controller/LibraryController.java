package com.hexad.library.controller;

import com.hexad.library.exception.BookNotFoundException;
import com.hexad.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller("/")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;
    @GetMapping
    private String getBookList(Model model) throws BookNotFoundException{
        libraryService.getBookList(model);
        return "library-home";
    }

    @GetMapping("/books/borrow/{bookId}")
    private String borrowBook(@PathVariable(name="bookId") int bookId) throws BookNotFoundException{
        libraryService.borrowBook(bookId);
        return "redirect:/";
    }

    @GetMapping("/books/borrow/list")
    private String getBorrowedBookList(Model model) throws BookNotFoundException{
        libraryService.getBorrowedBookList(model);
        return "borrowed-book-list";
    }

    @GetMapping("/books/return/{bookId}")
    private String returnBorrowedBook(@PathVariable(name="bookId") int bookId) throws BookNotFoundException{
        libraryService.returnBook(bookId);
        return "redirect:/books/borrow/list";
    }
}
