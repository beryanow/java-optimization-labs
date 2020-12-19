package ru.nsu.g.beryanov.book_library.service;

import ru.nsu.g.beryanov.book_library.dto.BookFavouriteDto;

import java.util.List;

public interface BookFavouriteService {
    List<BookFavouriteDto> findAll();
    BookFavouriteDto save(BookFavouriteDto bookFavouriteDto);
    BookFavouriteDto findByBookId(Long bookId);
    void deleteById(Long id);
}
