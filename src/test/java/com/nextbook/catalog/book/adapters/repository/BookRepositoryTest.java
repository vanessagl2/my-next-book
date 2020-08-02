package com.nextbook.catalog.book.adapters.repository;

import com.nextbook.catalog.book.domain.model.Book;
import com.nextbook.catalog.util.RepositoryIntegrationTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BookRepositoryTest extends RepositoryIntegrationTest {

  @Autowired
  private EntityManager entityManager;

  @Autowired
  private BookRepository repository;

  @Test
  @DisplayName("should save new book and return it with an id")
  void save() {
    String bookTitle = "Women, Race, & Class";
    String bookAuthor = "Angela Yvonne Davis";

    Book newBook = repository.save(new Book(bookTitle, bookAuthor));

    assertThat(newBook).isNotNull();

    PersistedBook persistedBook = entityManager.find(PersistedBook.class, Long.valueOf(newBook.getId()));

    assertThat(persistedBook).extracting(
        PersistedBook::getTitle,
        PersistedBook::getAuthor
    ).containsExactly(
        bookTitle,
        bookAuthor
    );
  }
}