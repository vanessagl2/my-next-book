package com.nextbook.catalog.book.adapters;

import com.nextbook.catalog.book.domain.Book;
import org.springframework.stereotype.Service;

@Service
public class BookService {

  public Book save(Book book) {
    return new Book("id-1", book.getTitle(), book.getTitle());
  }
}
