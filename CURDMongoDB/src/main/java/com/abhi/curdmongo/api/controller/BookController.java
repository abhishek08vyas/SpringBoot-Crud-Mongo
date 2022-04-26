package com.abhi.curdmongo.api.controller;

import com.abhi.curdmongo.api.dto.BookDTO;
import com.abhi.curdmongo.api.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@Slf4j
@RestController
@RequestMapping("/bookstore")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@PostMapping("/addbook")
	public ResponseEntity<Object> saveBook(@Valid @RequestBody BookDTO book,
			BindingResult bindingResults) {

		if (bindingResults.hasErrors()) {
			log.error("Error with payload {} ", book);
			return ResponseEntity.badRequest().body("Invalid Payload.");
		}

		log.info("We are in BookController.saveBook() : request Body: {}",book);
		return bookService.saveBook(book);
		
	}
	
	@GetMapping("/findallbooks")
	public ResponseEntity<Object> getBooks(){
		log.info("We are in BookController.getBooks()");
		return bookService.getAllBooks();
	}
	
	@GetMapping("findallbooks/{id}")
	public ResponseEntity<Object> getBookById(@PathVariable int id){

		log.info("We are in BookController.getBookById()");
		return bookService.getBookById(id);
	}
	@DeleteMapping("deletebook/{id}")
	public ResponseEntity<Object> deleteBook(@PathVariable int id) {

		log.info("We are in BookController.deleteBook()");
		return bookService.deleteBook(id);
	}
	
	@PutMapping("updatebook/{id}")
	public ResponseEntity<Object> updateBook(@PathVariable("id") int id,
			@RequestBody BookDTO book)
	{
		log.info("We are in BookController.updateBook()");
		return bookService.updateBook(id, book);
	}

}
