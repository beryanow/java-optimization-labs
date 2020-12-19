package ru.nsu.g.beryanov.book_library.service;

import ru.nsu.g.beryanov.book_library.dto.CountryDto;

import java.util.List;

public interface CountryService {
    List<CountryDto> findAll();
    CountryDto save(CountryDto countryDto);
}
