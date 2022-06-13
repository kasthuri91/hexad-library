package com.hexad.library.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Book {

    private int bookId;
    private String name;
    private String author;
    private int copies;
}
