package ru.nsu.g.beryanov.book_library.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsu.g.beryanov.book_library.dto.QuoteDto;
import ru.nsu.g.beryanov.book_library.mapping.QuoteMapper;
import ru.nsu.g.beryanov.book_library.repository.QuoteRepository;
import ru.nsu.g.beryanov.book_library.service.QuoteService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuoteServiceImpl implements QuoteService {
    private final QuoteRepository quoteRepository;
    private final QuoteMapper quoteMapper;

    @Override
    @Transactional
    public List<QuoteDto> findAll() {
        return quoteMapper.toDtoList(quoteRepository.findAll());
    }

    @Override
    @Transactional
    public QuoteDto findById(Long id) {
        return quoteMapper.toDto(quoteRepository.findById(id).orElse(null));
    }

    @Override
    @Transactional
    public QuoteDto save(QuoteDto quoteDto) {
        return quoteMapper.toDto(quoteRepository.save(quoteMapper.toEntity(quoteDto)));
    }

    @Override
    @Transactional
    public QuoteDto findByContent(String content) {
        return quoteMapper.toDto(quoteRepository.findQuoteByContent(content));
    }

    @Override
    @Transactional
    public void deleteByContent(String content) {
        quoteRepository.deleteQuoteByContent(content);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        quoteRepository.deleteById(id);
    }
}
