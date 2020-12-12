package ru.nsu.g.beryanov.book_library.service;

import ru.nsu.g.beryanov.book_library.dto.QuoteDto;

import java.util.List;

public interface QuoteService {
    List<QuoteDto> findAll();
    QuoteDto findById(Long id);
    QuoteDto save(QuoteDto quoteDto);
    QuoteDto findByContent(String content);
    void deleteByContent(String content);
    void deleteById(Long id);
}
