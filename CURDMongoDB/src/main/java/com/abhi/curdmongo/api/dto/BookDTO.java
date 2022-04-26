package com.abhi.curdmongo.api.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@ToString
@Getter
@Setter
public class BookDTO {

    private int bookId;
    @NotNull(message="Please provide a valid book Name")
    private String bookName;
    private String authorName;
}
