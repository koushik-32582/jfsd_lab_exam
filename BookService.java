package com.klef.jfsd.exam.service;

import com.klef.jfsd.exam.model.Book;

public interface BookService {
    Book updateBook(Long id, Book bookDetails);
}
