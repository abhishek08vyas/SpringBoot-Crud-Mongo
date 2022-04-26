package com.abhi.curdmongo.api.service;

import com.abhi.curdmongo.api.dto.BookDTO;
import org.springframework.http.ResponseEntity;

public interface BookService {
	public ResponseEntity<Object> saveBook(BookDTO book);
	public ResponseEntity<Object> getAllBooks();
	public ResponseEntity<Object> getBookById(int id);
	public ResponseEntity<Object> deleteBook(int id);
	public ResponseEntity<Object> updateBook(int id, BookDTO book);
}
