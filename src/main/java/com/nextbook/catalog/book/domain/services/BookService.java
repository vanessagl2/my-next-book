package com.nextbook.catalog.book.domain.services;

import com.nextbook.catalog.book.domain.model.Book;
import com.nextbook.catalog.book.domain.ports.BookPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BookService {

  private final BookPort bookPort;

  public Book save(Book book) {
    return bookPort.save(book);
  }
}
