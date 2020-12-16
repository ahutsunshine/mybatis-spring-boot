package com.example.controller;

import com.example.dao.BookMapper;
import com.example.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookMapper bookMapper;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Book> home() {
        List<Book> books= bookMapper.findAll();
        return books;
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public List<Book> books() {
        return home();
    }

    @RequestMapping(value = "/books/{isbn}", method = RequestMethod.GET)
    public List<Book> bookByIsbn(@PathVariable("isbn") String isbn) {
        return bookMapper.findByIsbn(isbn);
    }

    @RequestMapping(value = "/books", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBook(@RequestBody Book book) {
        if (book.getIsbn() == null || book.getIsbn().length() == 0) {
            throw new RuntimeException("Isbn cannot empty");
        }
        if (bookMapper.findByIsbn(book.getIsbn()).size() > 0) {
            throw new RuntimeException("Isbn already exists");
        }
//        bookMapper.insertBook(book.getIsbn(), book.getTitle(), book.getDescription(), book.getAuthorFirstName(), book.getAuthorLastName(), book.getGenre(), book.getPrice());
        bookMapper.insertBook(book);
        return bookMapper.findByIsbn(book.getIsbn()).get(0);
    }

    @RequestMapping(value = "/books", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public Book updateBook(@RequestBody Book book) {
        Book b = bookMapper.findById(book.getId());
        if (b == null) {
            throw new RuntimeException("Id does not exist");
        }
        if (b.getIsbn() != null && !b.getIsbn().equals(book.getIsbn())) {
            throw new RuntimeException("Isbn cannot be updated");
        }
        bookMapper.updateBook(book.getDescription(), book.getId());
        return bookMapper.findById(book.getId());
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id) {
        if (bookMapper.findById(id) == null) {
            throw new RuntimeException("Id does not exist");
        }
        bookMapper.deleteBook(id);
    }

}
