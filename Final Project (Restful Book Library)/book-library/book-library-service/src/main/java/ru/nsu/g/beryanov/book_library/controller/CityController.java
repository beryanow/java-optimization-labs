package ru.nsu.g.beryanov.book_library.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.g.beryanov.book_library.dto.CityDto;
import ru.nsu.g.beryanov.book_library.service.CityService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/city")
public class CityController {
    private final CityService cityService;

    @GetMapping("/all")
    public List<CityDto> findAll() {
        return cityService.findAll();
    }

    @PostMapping("/save")
    public CityDto save(@RequestBody CityDto cityDto) {
        return cityService.save(cityDto);
    }
}
