package com.nextbook.catalog.book.adapters;

import com.nextbook.catalog.book.domain.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
  private String title;
  private String author;

  public Book toBook() {
    return new Book("id-1", this.title, this.author);
  }
}
