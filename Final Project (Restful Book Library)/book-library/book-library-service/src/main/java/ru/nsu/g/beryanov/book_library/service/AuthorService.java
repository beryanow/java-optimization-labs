package ru.nsu.g.beryanov.book_library.service;

import ru.nsu.g.beryanov.book_library.dto.AuthorDto;

import java.util.List;

public interface AuthorService {
    List<AuthorDto> findAll();
    AuthorDto findById(Long id);
    AuthorDto findByName(String name);
    AuthorDto save(AuthorDto authorDto);
}
