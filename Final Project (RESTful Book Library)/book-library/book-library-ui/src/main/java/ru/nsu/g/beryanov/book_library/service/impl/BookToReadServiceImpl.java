package ru.nsu.g.beryanov.book_library.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsu.g.beryanov.book_library.dto.BookDto;
import ru.nsu.g.beryanov.book_library.dto.BookToReadDto;
import ru.nsu.g.beryanov.book_library.external.ExternalCall;
import ru.nsu.g.beryanov.book_library.service.BookToReadService;
import ru.nsu.g.beryanov.book_library.utility.BookLibraryServiceURL;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookToReadServiceImpl implements BookToReadService {
    @Autowired
    private ExternalCall externalCall;

    @Autowired
    private BookLibraryServiceURL bookLibraryServiceURL;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<BookToReadDto> findAll() {
        return (List<BookToReadDto>) externalCall.getCall(bookLibraryServiceURL.BOOK_TO_READ_FIND_ALL, List.class).stream().map(bookHashMap -> objectMapper.convertValue(bookHashMap, BookToReadDto.class)).collect(Collectors.toList());
    }

    @Override
    public BookToReadDto findByBookId(Long bookId) {
        return externalCall.getCall(String.format(bookLibraryServiceURL.BOOK_TO_READ_FIND_BY_BOOK_ID, bookId), BookToReadDto.class);
    }

    @SneakyThrows
    @Override
    public BookToReadDto save(BookToReadDto bookToReadDto) {
        return externalCall.postCall(objectMapper.writeValueAsString(bookToReadDto), bookLibraryServiceURL.BOOK_TO_READ_SAVE, BookToReadDto.class);
    }

    @Override
    public void deleteById(Long id) {
        externalCall.postCall("", String.format(bookLibraryServiceURL.BOOK_TO_READ_DELETE, id), BookToReadDto.class);
    }
}

