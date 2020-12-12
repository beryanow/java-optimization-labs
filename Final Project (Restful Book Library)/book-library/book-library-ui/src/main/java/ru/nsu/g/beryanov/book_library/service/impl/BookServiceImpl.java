package ru.nsu.g.beryanov.book_library.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsu.g.beryanov.book_library.dto.BookDto;
import ru.nsu.g.beryanov.book_library.external.ExternalCall;
import ru.nsu.g.beryanov.book_library.service.BookService;
import ru.nsu.g.beryanov.book_library.utility.BookLibraryServiceURL;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    @Autowired
    private ExternalCall externalCall;

    @Autowired
    private BookLibraryServiceURL bookLibraryServiceURL;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<BookDto> findAll() {
        return (List<BookDto>) externalCall.getCall(bookLibraryServiceURL.BOOK_FIND_ALL, List.class).stream().map(bookHashMap -> objectMapper.convertValue(bookHashMap, BookDto.class)).collect(Collectors.toList());
    }

    @SneakyThrows
    @Override
    public BookDto save(BookDto bookDto) {
        return externalCall.postCall(objectMapper.writeValueAsString(bookDto), bookLibraryServiceURL.BOOK_SAVE, BookDto.class);
    }

    @Override
    public BookDto findById(Long id) {
        return externalCall.getCall(String.format(bookLibraryServiceURL.BOOK_FIND_BY_ID, id), BookDto.class);
    }

    @Override
    public List<BookDto> findAllByAuthorId(Long authorId) {
        return externalCall.getCall(String.format(bookLibraryServiceURL.BOOK_FIND_ALL_BY_AUTHOR_ID, authorId), List.class);
    }

    @Override
    public List<BookDto> findAllByGenreId(Long genreId) {
        return externalCall.getCall(String.format(bookLibraryServiceURL.BOOK_FIND_ALL_BY_GENRE_ID, genreId), List.class);
    }
}
