package com.oliver.BookStore.service;

import com.oliver.BookStore.model.Book;
import com.oliver.BookStore.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book save(Book book) {
        Book savedBook = bookRepository.save(book);
        return savedBook;
    }

    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findById(Long id) {
        return bookRepository.findById(id).get();
    }

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}
