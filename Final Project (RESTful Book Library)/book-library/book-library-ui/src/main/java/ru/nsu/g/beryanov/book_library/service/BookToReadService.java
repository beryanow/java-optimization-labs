package ru.nsu.g.beryanov.book_library.service;

import ru.nsu.g.beryanov.book_library.dto.BookToReadDto;

import java.util.List;

public interface BookToReadService {
    List<BookToReadDto> findAll();
    BookToReadDto findByBookId(Long bookId);
    BookToReadDto save(BookToReadDto bookToReadDto);
    void deleteById(Long id);
}
