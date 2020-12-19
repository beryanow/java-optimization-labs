package ru.nsu.g.beryanov.book_library.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsu.g.beryanov.book_library.dto.CityDto;
import ru.nsu.g.beryanov.book_library.mapping.CityMapper;
import ru.nsu.g.beryanov.book_library.repository.CityRepository;
import ru.nsu.g.beryanov.book_library.service.CityService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;
    private final CityMapper cityMapper;

    @Override
    @Transactional
    public List<CityDto> findAll() {
        return cityMapper.toDtoList(cityRepository.findAll());
    }

    @Override
    @Transactional
    public CityDto save(CityDto cityDto) {
        return cityMapper.toDto(cityRepository.save(cityMapper.toEntity(cityDto)));
    }
}
