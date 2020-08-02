package com.nextbook.catalog.book.adapters.repository;

import com.nextbook.catalog.book.adapters.repository.jpa.BookJpaRepository;
import com.nextbook.catalog.book.domain.model.Book;
import com.nextbook.catalog.book.domain.ports.BookPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
public class BookRepository implements BookPort {

  private final BookJpaRepository jpaRepository;

  @Override
  public Book save(Book book) {
    PersistedBook bookToBePersisted = PersistedBook.from(book);

    PersistedBook persistedBook = jpaRepository.saveAndFlush(bookToBePersisted);

    return persistedBook.toBook();
  }
}
