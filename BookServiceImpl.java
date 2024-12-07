package com.klef.jfsd.exam.service;

import com.klef.jfsd.exam.model.Book;
import com.klef.jfsd.exam.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book updateBook(Long id, Book bookDetails) {
        Optional<Book> optionalBook = bookRepository.findById(id);

        if (optionalBook.isPresent()) {
            Book existingBook = optionalBook.get();
            existingBook.setTitle(bookDetails.getTitle());
            existingBook.setAuthor(bookDetails.getAuthor());
            existingBook.setGenre(bookDetails.getGenre());
            existingBook.setPrice(bookDetails.getPrice());
            existingBook.setPublishedYear(bookDetails.getPublishedYear());
            return bookRepository.save(existingBook);
        } else {
            throw new RuntimeException("Book not found with id: " + id);
        }
    }
}
