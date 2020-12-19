package ru.nsu.g.beryanov.book_library.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.g.beryanov.book_library.dto.BookFavouriteDto;
import ru.nsu.g.beryanov.book_library.service.BookFavouriteService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book/favourite")
public class BookFavouriteController {
    private final BookFavouriteService bookFavouriteService;

    @GetMapping("/all")
    public List<BookFavouriteDto> findAll() {
        return bookFavouriteService.findAll();
    }

    @GetMapping("/book/{bookId}")
    public BookFavouriteDto findByBookId(@PathVariable Long bookId) {
        return bookFavouriteService.findByBookId(bookId);
    }

    @PostMapping("/save")
    public BookFavouriteDto save(@RequestBody BookFavouriteDto bookFavouriteDto) {
        return bookFavouriteService.save(bookFavouriteDto);
    }

    @PostMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        bookFavouriteService.deleteById(id);
    }
}
