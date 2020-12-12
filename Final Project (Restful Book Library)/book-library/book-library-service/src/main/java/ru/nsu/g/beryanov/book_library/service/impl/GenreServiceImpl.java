package ru.nsu.g.beryanov.book_library.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsu.g.beryanov.book_library.dto.GenreDto;
import ru.nsu.g.beryanov.book_library.mapping.GenreMapper;
import ru.nsu.g.beryanov.book_library.repository.GenreRepository;
import ru.nsu.g.beryanov.book_library.service.GenreService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {
    private final GenreRepository genreRepository;
    private final GenreMapper genreMapper;

    @Override
    @Transactional
    public List<GenreDto> findAll() {
        return genreMapper.toDtoList(genreRepository.findAll());
    }

    @Override
    @Transactional
    public GenreDto findByName(String name) {
        return genreMapper.toDto(genreRepository.findByName(name));
    }

    @Override
    @Transactional
    public GenreDto save(GenreDto genreDto) {
        return genreMapper.toDto(genreRepository.save(genreMapper.toEntity(genreDto)));
    }
}
