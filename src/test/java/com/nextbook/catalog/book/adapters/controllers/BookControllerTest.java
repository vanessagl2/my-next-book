package com.nextbook.catalog.book.adapters.controllers;

import com.nextbook.catalog.book.domain.model.Book;
import com.nextbook.catalog.book.domain.services.BookService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.stream.Stream;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookController.class)
class BookControllerTest {

  @MockBean
  private BookService service;

  @Autowired
  private MockMvc mockMvc;

  @Test
  @DisplayName("Should return CREATED http status when valid request is made")
  void createBook() throws Exception {
    final String expectedTitle = "\"New book\"";
    final String expectedAuthor = "\"An author\"";
    final String expectedId = "id-1";

    final String newBook = "{\n" +
        "\"title\": " + expectedTitle + ",\n" +
        "\"author\": " + expectedAuthor + "\n" +
        "}";

    when(service.save(any(Book.class))).thenReturn(new Book(expectedId, expectedTitle, expectedAuthor));

    mockMvc.perform(
        post("/books")
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .content(newBook))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.id", is(expectedId)))
        .andExpect(jsonPath("$.title", is(expectedTitle)))
        .andExpect(jsonPath("$.author", is(expectedAuthor)));
  }

  @ParameterizedTest
  @DisplayName("Should return BAD REQUEST mandatory fields are not provided")
  @MethodSource("createBookFailsParams")
  void createBookFails(String payload) throws Exception {
    mockMvc.perform(
        post("/books")
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .content(payload)
    ).andExpect(status().isBadRequest());
  }

  private static Stream<String> createBookFailsParams() {
    final String payloadWithoutTitle = "{\n" +
        "\"author\": " + "\"An Author\"" +
        "}";

    final String payloadWithoutAuthor = "{\n" +
        "\"title\": " + "\"A book\"" +
        "}";

    return Stream.of(
        payloadWithoutTitle,
        payloadWithoutAuthor
    );
  }
}