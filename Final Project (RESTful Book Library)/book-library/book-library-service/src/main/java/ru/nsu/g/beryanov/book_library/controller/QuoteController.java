package ru.nsu.g.beryanov.book_library.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.g.beryanov.book_library.dto.QuoteDto;
import ru.nsu.g.beryanov.book_library.service.QuoteService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/quote")
public class QuoteController {
    private final QuoteService quoteService;

    @GetMapping("/all")
    public List<QuoteDto> findAll() {
        return quoteService.findAll();
    }

    @GetMapping("/{id}")
    public QuoteDto findById(@PathVariable Long id) {
        return quoteService.findById(id);
    }

    @GetMapping("/content/{content}")
    public QuoteDto findByContent(@PathVariable String content) {
        return quoteService.findByContent(content);
    }

    @PostMapping("/delete/content/{content}")
    public void deleteByContent(@PathVariable String content) {
        quoteService.deleteByContent(content);
    }

    @PostMapping("/save")
    public QuoteDto save(@RequestBody QuoteDto quoteDto) {
        return quoteService.save(quoteDto);
    }

    @PostMapping("/delete/{id}")
    public void deleteByContent(@PathVariable Long id) {
        quoteService.deleteById(id);
    }
}
