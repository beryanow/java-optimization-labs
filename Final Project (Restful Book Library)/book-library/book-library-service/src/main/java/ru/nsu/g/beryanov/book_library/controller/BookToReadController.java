package ru.nsu.g.beryanov.book_library.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.g.beryanov.book_library.dto.BookToReadDto;
import ru.nsu.g.beryanov.book_library.service.BookToReadService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book/to-read")
public class BookToReadController {
    private final BookToReadService bookToReadService;

    @GetMapping("/all")
    public List<BookToReadDto> findAll() {
        return bookToReadService.findAll();
    }

    @GetMapping("/{bookId}")
    public BookToReadDto findByBookId(@PathVariable Long bookId) {
        return bookToReadService.findByBookId(bookId);
    }

    @PostMapping("/save")
    public BookToReadDto save(@RequestBody BookToReadDto bookToReadDto) {
        return bookToReadService.save(bookToReadDto);
    }

    @PostMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        bookToReadService.deleteById(id);
    }
}
