package com.nextbook.catalog.book.adapters.repository.jpa;

import com.nextbook.catalog.book.adapters.repository.PersistedBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookJpaRepository extends JpaRepository<PersistedBook, Long> {
}
