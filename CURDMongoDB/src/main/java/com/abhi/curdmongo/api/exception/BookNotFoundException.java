package com.abhi.curdmongo.api.exception;

import lombok.Getter;

@Getter
public class BookNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

    public BookNotFoundException(String bookMessage) {
        super(bookMessage);
    }

    public BookNotFoundException(String bookMessage, Throwable cause) {
        super(bookMessage, cause);
    }

    public BookNotFoundException(Throwable cause) {
        super(cause);
    }
}
