package ru.nsu.g.beryanov.book_library.service;

import ru.nsu.g.beryanov.book_library.dto.BookDto;

import java.util.List;

public interface BookService {
    List<BookDto> findAll();
    BookDto save(BookDto bookDto);
    BookDto findById(Long id);
    List<BookDto> findAllByAuthorId(Long authorId);
    List<BookDto> findAllByGenreId(Long genreId);
}
