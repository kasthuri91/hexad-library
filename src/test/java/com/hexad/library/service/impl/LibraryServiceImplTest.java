package com.hexad.library.service.impl;

import com.hexad.library.exception.BookNotFoundException;
import com.hexad.library.model.Book;
import com.hexad.library.service.LibraryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LibraryServiceImplTest {

    LibraryService libraryService=new LibraryServiceImpl();

    @BeforeEach
    void resetBookLists(){
        LibraryServiceImpl.bookList.removeAll(LibraryServiceImpl.bookList);
        LibraryServiceImpl.borrowedBookList.removeAll(LibraryServiceImpl.borrowedBookList);
    }

    @Test
    void testBorrowBook() throws BookNotFoundException{

        LibraryServiceImpl.bookList=new ArrayList<>(Arrays.asList(
                new Book(1,"The Lord of the Rings","J. R. R. Tolkien",2),
                new Book(2,"Harry Potter","J. K. Rowling",1)
        ));

        libraryService.borrowBook(1);

        assertEquals(1,LibraryServiceImpl.borrowedBookList.size());
    }

    @Test
    void testBorrowMoreThanTwoBooks() throws BookNotFoundException{

        LibraryServiceImpl.bookList=new ArrayList<>(Arrays.asList(
                new Book(1,"The Lord of the Rings","J. R. R. Tolkien",2),
                new Book(2,"Harry Potter","J. K. Rowling",1),
                new Book(3,"The Tale of Peter Rabbit","Beatrix Potter",5)
        ));

        libraryService.borrowBook(1);
        libraryService.borrowBook(2);
        libraryService.borrowBook(3);

        assertEquals(2,LibraryServiceImpl.borrowedBookList.size());
    }

    @Test
    void testMoreThaOneCopyOfBook() throws BookNotFoundException{

        LibraryServiceImpl.bookList=new ArrayList<> (Arrays.asList(
                new Book(1,"Lord of the Rings","Kamala Pasan",2),
                new Book(2,"Lord of the Gate","Saman Pasan",1)
        ));
        libraryService.borrowBook(1);
        libraryService.borrowBook(1);

        assertEquals(1,LibraryServiceImpl.borrowedBookList.size());

        Book borrowedBook=LibraryServiceImpl.bookList.stream()
                .filter(book->1==book.getBookId())
                .findAny()
                .orElse(null);

        assertEquals(1,borrowedBook.getCopies());
    }

    @Test
    void testReturnBook() throws BookNotFoundException {

        LibraryServiceImpl.bookList=new ArrayList<> (Arrays.asList(
                new Book(1,"Lord of the Rings","Kamala Pasan",2),
                new Book(2,"Lord of the Gate","Saman Pasan",1)
        ));
        libraryService.borrowBook(1);

        assertEquals(1,LibraryServiceImpl.borrowedBookList.size());

        libraryService.returnBook(1);

        Book returnedBook=LibraryServiceImpl.bookList.stream()
                .filter(book->1==book.getBookId())
                .findAny()
                .orElse(null);

        assertEquals(2,returnedBook.getCopies());
    }
}