package ru.nsu.g.beryanov.book_library.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsu.g.beryanov.book_library.dto.BookReadingDto;
import ru.nsu.g.beryanov.book_library.dto.BookToReadDto;
import ru.nsu.g.beryanov.book_library.external.ExternalCall;
import ru.nsu.g.beryanov.book_library.service.BookReadingService;
import ru.nsu.g.beryanov.book_library.utility.BookLibraryServiceURL;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookReadingServiceImpl implements BookReadingService {
    @Autowired
    private ExternalCall externalCall;

    @Autowired
    private BookLibraryServiceURL bookLibraryServiceURL;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<BookReadingDto> findAll() {
        return (List<BookReadingDto>) externalCall.getCall(bookLibraryServiceURL.BOOK_READING_FIND_ALL, List.class).stream().map(bookHashMap -> objectMapper.convertValue(bookHashMap, BookReadingDto.class)).collect(Collectors.toList());
    }

    @Override
    public BookReadingDto findByBookId(Long bookId) {
        return externalCall.getCall(String.format(bookLibraryServiceURL.BOOK_READING_FIND_BY_BOOK_ID, bookId), BookReadingDto.class);
    }

    @SneakyThrows
    @Override
    public BookReadingDto save(BookReadingDto bookReadingDto) {
        return externalCall.postCall(objectMapper.writeValueAsString(bookReadingDto), bookLibraryServiceURL.BOOK_READING_SAVE, BookReadingDto.class);
    }

    @Override
    public void deleteById(Long id) {
        externalCall.postCall("", String.format(bookLibraryServiceURL.BOOK_READING_DELETE, id), BookReadingDto.class);
    }
}
