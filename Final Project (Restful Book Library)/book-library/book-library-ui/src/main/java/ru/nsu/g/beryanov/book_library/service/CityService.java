package ru.nsu.g.beryanov.book_library.service;

import ru.nsu.g.beryanov.book_library.dto.CityDto;

import java.util.List;

public interface CityService {
    List<CityDto> findAll();
    CityDto save(CityDto cityDto);
}
