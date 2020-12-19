package ru.nsu.g.beryanov.book_library.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsu.g.beryanov.book_library.dto.AuthorDto;
import ru.nsu.g.beryanov.book_library.mapping.AuthorMapper;
import ru.nsu.g.beryanov.book_library.repository.AuthorRepository;
import ru.nsu.g.beryanov.book_library.service.AuthorService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    @Override
    @Transactional
    public List<AuthorDto> findAll() {
        return authorMapper.toDtoList(authorRepository.findAll());
    }

    @Override
    @Transactional
    public AuthorDto findById(Long id) {
        return authorMapper.toDto(authorRepository.findById(id).orElse(null));
    }

    @Override
    @Transactional
    public AuthorDto findByName(String name) {
        return authorMapper.toDto(authorRepository.findAuthorByName(name));
    }

    @Override
    @Transactional
    public AuthorDto save(AuthorDto authorDto) {
        return authorMapper.toDto(authorRepository.save(authorMapper.toEntity(authorDto)));
    }
}
