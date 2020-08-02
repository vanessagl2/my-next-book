package com.nextbook.catalog.util;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EntityScan(basePackages = {"com.nextbook.catalog.book.adapters.repository"})
@ComponentScan(
    useDefaultFilters = false,
    basePackages = {"com.nextbook.catalog.book.adapters.repository"},
    includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Repository.class)
)
@EnableJpaRepositories(basePackages = {"com.nextbook.catalog.book.adapters.repository"})
public class RepositoryIntegrationTest {
}
