package com.abhi.curdmongo.api.dao;

import com.abhi.curdmongo.api.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookDao {

    void saveBook(Book book);
    List<Book> getAllBooks();
    Optional<Book> getBookById(int id);
    void deleteBook(int id);
    boolean isBookExist(int id);
}
