package ru.nsu.g.beryanov.book_library.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.g.beryanov.book_library.dto.BookReadingDto;
import ru.nsu.g.beryanov.book_library.service.BookReadingService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book/reading")
public class BookReadingController {
    private final BookReadingService bookReadingService;

    @GetMapping("/all")
    public List<BookReadingDto> findAll() {
        return bookReadingService.findAll();
    }

    @GetMapping("/{bookId}")
    public BookReadingDto findByBookId(@PathVariable Long bookId) {
        return bookReadingService.findByBookId(bookId);
    }

    @PostMapping("/save")
    public BookReadingDto save(@RequestBody BookReadingDto bookReadingDto) {
        return bookReadingService.save(bookReadingDto);
    }

    @PostMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        bookReadingService.deleteById(id);
    }
}
