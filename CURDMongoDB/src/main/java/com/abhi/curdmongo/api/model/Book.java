package com.abhi.curdmongo.api.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.ToString;

@ToString
@Getter
@Setter
@Document(collection = "book")
public class Book {
	
	@Id
	private int bookId;
	
	@Field("bookname")
	private String bookName;
	
	@Field("authorname")
	private String authorName;

}
