package com.nextbook.catalog.book.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Book {
  private final String id;
  private final String title;
  private final String author;
}
