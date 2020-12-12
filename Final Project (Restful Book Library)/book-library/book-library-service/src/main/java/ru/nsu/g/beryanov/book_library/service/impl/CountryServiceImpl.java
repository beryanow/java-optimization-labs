package ru.nsu.g.beryanov.book_library.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsu.g.beryanov.book_library.dto.CountryDto;
import ru.nsu.g.beryanov.book_library.mapping.CountryMapper;
import ru.nsu.g.beryanov.book_library.repository.CountryRepository;
import ru.nsu.g.beryanov.book_library.service.CountryService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;

    @Override
    @Transactional
    public List<CountryDto> findAll() {
        return countryMapper.toDtoList(countryRepository.findAll());
    }

    @Override
    @Transactional
    public CountryDto save(CountryDto countryDto) {
        return countryMapper.toDto(countryRepository.save(countryMapper.toEntity(countryDto)));
    }
}
