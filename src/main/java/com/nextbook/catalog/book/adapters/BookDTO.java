package com.nextbook.catalog.book.adapters;

import com.nextbook.catalog.book.domain.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {

  private String id;

  @NotNull
  private String title;

  @NotNull
  private String author;

  public Book toBook() {
    return new Book(this.title, this.author);
  }

  public static BookDTO fromBook(Book book) {
    return new BookDTO(book.getId(), book.getTitle(), book.getAuthor());
  }
}
