package ru.nsu.g.beryanov.book_library.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.g.beryanov.book_library.dto.AuthorDto;
import ru.nsu.g.beryanov.book_library.service.AuthorService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/author")
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping("/all")
    public List<AuthorDto> findAll() {
        return authorService.findAll();
    }

    @GetMapping("/{id}")
    public AuthorDto findById(@PathVariable Long id) {
        return authorService.findById(id);
    }

    @GetMapping("/name/{name}")
    public AuthorDto findByName(@PathVariable String name) {
        return authorService.findByName(name);
    }

    @PostMapping("/save")
    public AuthorDto save(@RequestBody AuthorDto authorDto) {
        return authorService.save(authorDto);
    }
}
