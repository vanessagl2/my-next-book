package com.nextbook.catalog.book.domain.ports;

import com.nextbook.catalog.book.domain.model.Book;

public interface BookPort {

  Book save(Book book);
}
