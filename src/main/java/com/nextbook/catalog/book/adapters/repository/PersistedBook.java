package com.nextbook.catalog.book.adapters.repository;

import com.nextbook.catalog.book.domain.model.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "books")
@SequenceGenerator(name = "books_id", sequenceName = "books_sequence", allocationSize = 1)
public class PersistedBook {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "books_id")
  private Long id;

  private String title;

  private String author;

  public static PersistedBook from(Book book) {
    return new PersistedBook(null, book.getTitle(), book.getAuthor());
  }

  public Book toBook() {
    return new Book(String.valueOf(this.id), this.title, this.author);
  }
}
