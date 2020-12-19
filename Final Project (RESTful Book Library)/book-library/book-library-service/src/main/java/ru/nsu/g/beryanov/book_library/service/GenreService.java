package ru.nsu.g.beryanov.book_library.service;

import ru.nsu.g.beryanov.book_library.dto.GenreDto;

import java.util.List;

public interface GenreService {
    List<GenreDto> findAll();
    GenreDto findByName(String name);
    GenreDto save(GenreDto genreDto);
}
