package ru.nsu.g.beryanov.book_library.service;


import ru.nsu.g.beryanov.book_library.dto.BookReadDto;

import java.util.List;

public interface BookReadService {
    List<BookReadDto> findAll();
    List<BookReadDto> findAllByAssessmentId(Long assessmentId);
    List<BookReadDto> findAllInCurrentMonth(Long year, Long month);
    BookReadDto save(BookReadDto bookReadDto);
    BookReadDto findByBookId(Long bookId);
    void deleteById(Long id);
}
