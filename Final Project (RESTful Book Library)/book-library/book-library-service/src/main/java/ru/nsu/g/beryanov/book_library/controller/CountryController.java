package ru.nsu.g.beryanov.book_library.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.g.beryanov.book_library.dto.CountryDto;
import ru.nsu.g.beryanov.book_library.service.CountryService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/country")
public class CountryController {
    private final CountryService countryService;

    @GetMapping("/all")
    public List<CountryDto> findAll() {
        return countryService.findAll();
    }

    @PostMapping("/save")
    public CountryDto save(@RequestBody CountryDto countryDto) {
        return countryService.save(countryDto);
    }
}
