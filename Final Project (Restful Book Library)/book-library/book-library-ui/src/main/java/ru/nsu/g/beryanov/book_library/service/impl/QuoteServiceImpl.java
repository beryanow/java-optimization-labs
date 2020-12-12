package ru.nsu.g.beryanov.book_library.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsu.g.beryanov.book_library.dto.QuoteDto;
import ru.nsu.g.beryanov.book_library.external.ExternalCall;
import ru.nsu.g.beryanov.book_library.service.QuoteService;
import ru.nsu.g.beryanov.book_library.utility.BookLibraryServiceURL;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuoteServiceImpl implements QuoteService {
    @Autowired
    private ExternalCall externalCall;

    @Autowired
    private BookLibraryServiceURL bookLibraryServiceURL;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<QuoteDto> findAll() {
        return externalCall.getCall(bookLibraryServiceURL.QUOTE_FIND_ALL, List.class);
    }

    @Override
    public QuoteDto findById(Long id) {
        return externalCall.getCall(String.format(bookLibraryServiceURL.QUOTE_FIND_BY_ID, id), QuoteDto.class);
    }

    @SneakyThrows
    @Override
    public QuoteDto save(QuoteDto quoteDto) {
        return externalCall.postCall(objectMapper.writeValueAsString(quoteDto), bookLibraryServiceURL.QUOTE_SAVE, QuoteDto.class);
    }

    @Override
    public QuoteDto findByContent(String content) {
        return externalCall.getCall(String.format(bookLibraryServiceURL.QUOTE_FIND_BY_CONTENT, content), QuoteDto.class);
    }

    @Override
    public void deleteByContent(String content) {
        externalCall.postCall("", String.format(bookLibraryServiceURL.QUOTE_DELETE_BY_CONTENT, content), QuoteDto.class);
    }

    @Override
    public void deleteById(Long id) {
        externalCall.postCall("", String.format(bookLibraryServiceURL.QUOTE_DELETE, id), QuoteDto.class);
    }
}
