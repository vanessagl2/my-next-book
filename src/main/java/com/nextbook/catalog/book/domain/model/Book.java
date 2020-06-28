package com.nextbook.catalog.book.domain.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class Book {
  private String id;
  private final String title;
  private final String author;

  public Book(String title, String author) {
    this.title = title;
    this.author = author;
  }
}
