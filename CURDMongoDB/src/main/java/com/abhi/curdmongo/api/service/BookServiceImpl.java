package com.abhi.curdmongo.api.service;

import com.abhi.curdmongo.api.dao.BookDao;
import com.abhi.curdmongo.api.dto.BookDTO;
import com.abhi.curdmongo.api.model.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;

	public ResponseEntity<Object> saveBook(BookDTO book) {
		log.info("We are in BookService.saveBook()");
		try{
			bookDao.saveBook(convertBookDto(book));
			return ResponseEntity.created(null).body("Book is added successfully with Id = " + book.getBookId());
		} catch (Exception exception){
			log.error("Exception is  {}", exception.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
		}

	}

	public ResponseEntity<Object> getAllBooks(){

		log.info("We are in BookService.getAllBooks()");
		try {
			List<Book> bookList = bookDao.getAllBooks();
			return ResponseEntity.ok().body(bookList.stream().map(this::convertToBookDto).collect(Collectors.toList()));
		}catch (Exception exception) {
			log.error("Exception is  {}", exception.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
		}
	}

	public ResponseEntity<Object> getBookById(int id){
		log.info("We are in BookService.getBookById()");
		try {
			Optional<Book> optionalBook = bookDao.getBookById(id);
			if(optionalBook.isPresent()){
				return ResponseEntity.ok().body(optionalBook.stream().map(this::convertToBookDto).collect(Collectors.toList()));
			}
			return ResponseEntity.ok().body(Collections.emptyList());
		} catch (Exception exception) {
			log.error("Exception is  {}", exception.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
		}
	}

	public ResponseEntity<Object> deleteBook(int id) {
		log.info("We are in BookService.deleteBook()");
		try {
			Optional<Book> optionalBook = bookDao.getBookById(id);
			if(optionalBook.isPresent()){
				bookDao.deleteBook(id);
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The book has been deleted successfully id: " + id +".");
			}
			return ResponseEntity.badRequest().body("The Book id: "+ id +" is absent.");

		} catch (Exception exception) {
			log.error("Exception is  {}", exception.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
		}
	}

	public ResponseEntity<Object> updateBook(int id, BookDTO book){
		log.info("We are in BookService.getAllupdateBookBooks()");
		if(bookDao.isBookExist(id)) {
			try {
				bookDao.saveBook(convertBookDto(book));
				return ResponseEntity.ok().body("Book is updated successfully with Id = " + book.getBookId());
			}catch (Exception exception) {
				log.error("Exception is  {}", exception.getMessage());
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
			}

		}
		return ResponseEntity.badRequest().body("The Book id: "+ id +" is absent.");

	}

	private Book convertBookDto(BookDTO bookDTO){
		Book book = new Book();
		book.setBookId(bookDTO.getBookId());
		book.setBookName(bookDTO.getBookName());
		book.setAuthorName(bookDTO.getAuthorName());
		return book;
	}

	private BookDTO convertToBookDto(Book book){
		BookDTO bookDTO = new BookDTO();
		bookDTO.setBookId(book.getBookId());
		bookDTO.setBookName(book.getBookName());
		bookDTO.setAuthorName(book.getAuthorName());
		return bookDTO;
	}

}
