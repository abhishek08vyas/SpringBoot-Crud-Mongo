package com.abhi.curdmongo.api.dao.impl;

import com.abhi.curdmongo.api.dao.BookDao;
import com.abhi.curdmongo.api.exception.BookNotFoundException;
import com.abhi.curdmongo.api.model.Book;
import com.abhi.curdmongo.api.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class BookDaoImpl implements BookDao {

    @Autowired
    private BookRepository bookRepository;

    public void saveBook(Book book) {
        log.info("We are in BookDaoImpl.saveBook()");
        try{
            bookRepository.save(book);
        }catch (Exception exception){
            log.error("Exception is  {}", exception.getMessage());
            throw new BookNotFoundException("Unable to save book");
        }
    }


    public List<Book> getAllBooks(){
        log.info("We are in BookDaoImpl.getAllBooks()");
        try {
            return bookRepository.findAll();
        }catch (Exception exception) {
            log.error("Exception is  {}", exception.getMessage());
            throw new BookNotFoundException("Book Not Found");
        }
    }

    public Optional<Book> getBookById(int id){
        log.info("We are in BookDaoImpl.getBookById()");

        try {
            return bookRepository.findById(id);
        } catch (Exception exception) {
            log.error("Exception is  {}", exception.getMessage());
            throw new BookNotFoundException("Book Not Found of id:" + id);
        }
    }

    public void deleteBook(int id) {
        log.info("We are in BookDaoImpl.deleteBook()");
        try {
            bookRepository.deleteById(id);
        } catch (Exception exception) {
            log.error("Exception is  {}", exception.getMessage());
            throw new BookNotFoundException("Book Not Found of id:" + id);
        }
    }

    public boolean isBookExist(int id) {
        log.info("We are in BookDaoImpl.isBookExist()");
        return bookRepository.existsById(id);
    }
}
