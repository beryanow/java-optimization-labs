package ru.nsu.g.beryanov.book_library.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.g.beryanov.book_library.dto.BookDto;
import ru.nsu.g.beryanov.book_library.service.BookService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    @GetMapping("/all")
    public List<BookDto> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public BookDto findById(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @GetMapping("/all/author/{authorId}")
    public List<BookDto> findAllByAuthorId(@PathVariable Long authorId) {
        return bookService.findAllByAuthorId(authorId);
    }

    @GetMapping("/all/genre/{genreId}")
    public List<BookDto> findAllByGenreId(@PathVariable Long genreId) {
        return bookService.findAllByGenreId(genreId);
    }

    @PostMapping("/save")
    public BookDto save(@RequestBody BookDto bookDto) {
        return bookService.save(bookDto);
    }
}
