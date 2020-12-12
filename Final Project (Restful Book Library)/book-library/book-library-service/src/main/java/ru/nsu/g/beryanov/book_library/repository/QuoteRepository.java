package ru.nsu.g.beryanov.book_library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nsu.g.beryanov.book_library.model.Quote;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Long> {
    Quote findQuoteByContent(String content);
    void deleteQuoteByContent(String content);
}
