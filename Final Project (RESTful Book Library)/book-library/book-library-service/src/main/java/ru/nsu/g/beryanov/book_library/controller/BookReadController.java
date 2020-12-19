package ru.nsu.g.beryanov.book_library.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.g.beryanov.book_library.dto.BookReadDto;
import ru.nsu.g.beryanov.book_library.service.BookReadService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book/read")
public class BookReadController {
    private final BookReadService bookReadService;

    @GetMapping("/all")
    public List<BookReadDto> findAll() {
        return bookReadService.findAll();
    }

    @GetMapping("/all/assessment/{assessmentId}")
    public List<BookReadDto> findAllByAssessmentId(@PathVariable Long assessmentId) {
        return bookReadService.findAllByAssessmentId(assessmentId);
    }

    @GetMapping("/all/date/{year}/{month}")
    public List<BookReadDto> findAllInCurrentMonth(@PathVariable Long year, @PathVariable Long month) {
        return bookReadService.findAllInCurrentMonth(year, month);
    }

    @GetMapping("/{bookId}")
    public BookReadDto findByBookId(@PathVariable Long bookId) {
        return bookReadService.findByBookId(bookId);
    }

    @PostMapping(path = "/save")
    public BookReadDto save(@RequestBody BookReadDto bookReadDto) {
        return bookReadService.save(bookReadDto);
    }

    @PostMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        bookReadService.deleteById(id);
    }
}
