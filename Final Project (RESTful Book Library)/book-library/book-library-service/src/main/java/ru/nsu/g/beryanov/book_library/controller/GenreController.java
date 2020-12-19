package ru.nsu.g.beryanov.book_library.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.g.beryanov.book_library.dto.GenreDto;
import ru.nsu.g.beryanov.book_library.service.GenreService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/genre")
public class GenreController {
    private final GenreService genreService;

    @GetMapping("/all")
    public List<GenreDto> findAll() {
        return genreService.findAll();
    }

    @PostMapping("/name/{name}")
    public GenreDto findByName(@PathVariable String name) {
        return genreService.findByName(name);
    }

    @PostMapping("/save")
    public GenreDto findByName(@RequestBody GenreDto genreDto) {
        return genreService.save(genreDto);
    }
}
