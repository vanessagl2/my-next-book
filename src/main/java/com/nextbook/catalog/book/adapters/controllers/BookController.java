package com.nextbook.catalog.book.adapters.controllers;

import com.nextbook.catalog.book.adapters.controllers.dtos.BookDTO;
import com.nextbook.catalog.book.domain.model.Book;
import com.nextbook.catalog.book.domain.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/books")
public class BookController {

  private final BookService bookService;

  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  public BookDTO createBook(@Valid @RequestBody BookDTO newBook) {
    Book savedBook = bookService.save(newBook.toBook());

    return BookDTO.fromBook(savedBook);
  }


}

