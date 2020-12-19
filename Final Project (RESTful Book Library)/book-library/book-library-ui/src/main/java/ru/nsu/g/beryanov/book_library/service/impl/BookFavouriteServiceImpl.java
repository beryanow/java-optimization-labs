package ru.nsu.g.beryanov.book_library.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsu.g.beryanov.book_library.dto.BookFavouriteDto;
import ru.nsu.g.beryanov.book_library.external.ExternalCall;
import ru.nsu.g.beryanov.book_library.service.BookFavouriteService;
import ru.nsu.g.beryanov.book_library.utility.BookLibraryServiceURL;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookFavouriteServiceImpl implements BookFavouriteService {
    @Autowired
    private ExternalCall externalCall;

    @Autowired
    private BookLibraryServiceURL bookLibraryServiceURL;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<BookFavouriteDto> findAll() {
        return (List<BookFavouriteDto>) externalCall.getCall(bookLibraryServiceURL.BOOK_FAVOURITE_FIND_ALL, List.class).stream().map(bookHashMap -> objectMapper.convertValue(bookHashMap, BookFavouriteDto.class)).collect(Collectors.toList());
    }

    @Override
    @SneakyThrows
    public BookFavouriteDto save(BookFavouriteDto bookFavouriteDto) {
        return externalCall.postCall(objectMapper.writeValueAsString(bookFavouriteDto), bookLibraryServiceURL.BOOK_FAVOURITE_SAVE, BookFavouriteDto.class);
    }

    @Override
    public BookFavouriteDto findByBookId(Long bookId) {
        return externalCall.getCall(String.format(bookLibraryServiceURL.BOOK_FAVOURITE_FIND_BY_BOOK_ID, bookId), BookFavouriteDto.class);
    }

    @Override
    public void deleteById(Long id) {
        externalCall.postCall("", String.format(bookLibraryServiceURL.BOOK_FAVOURITE_DELETE, id), BookFavouriteDto.class);
    }
}
