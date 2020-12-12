package ru.nsu.g.beryanov.book_library.service;

import ru.nsu.g.beryanov.book_library.dto.BookReadingDto;

import java.util.List;

public interface BookReadingService {
    List<BookReadingDto> findAll();
    BookReadingDto findByBookId(Long bookId);
    BookReadingDto save(BookReadingDto bookReadingDto);
    void deleteById(Long id);
}
