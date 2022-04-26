package com.abhi.curdmongo.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.abhi.curdmongo.api.model.Book;

public interface BookRepository extends MongoRepository<Book, Integer> {

}
