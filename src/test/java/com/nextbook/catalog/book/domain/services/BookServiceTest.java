package com.nextbook.catalog.book.domain.services;

import com.nextbook.catalog.book.domain.model.Book;
import com.nextbook.catalog.book.domain.ports.BookPort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

  @Mock
  private BookPort bookPort;

  @InjectMocks
  private BookService service;

  @Test
  @DisplayName("should save a book using BookPort")
  void save() {
    String bookTitle = "Women, Race, & Class";
    String bookAuthor = "Angela Yvonne Davis";

    Book bookToBeSaved = new Book(bookTitle, bookAuthor);
    service.save(bookToBeSaved);

    verify(bookPort).save(bookToBeSaved);
  }
}