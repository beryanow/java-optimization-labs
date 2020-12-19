package ru.nsu.g.beryanov.book_library.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsu.g.beryanov.book_library.dto.BookReadingDto;
import ru.nsu.g.beryanov.book_library.mapping.BookReadingMapper;
import ru.nsu.g.beryanov.book_library.repository.BookReadingRepository;
import ru.nsu.g.beryanov.book_library.service.BookReadingService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookReadingServiceImpl implements BookReadingService {
    private final BookReadingRepository bookReadingRepository;
    private final BookReadingMapper bookReadingMapper;

    @Override
    @Transactional
    public List<BookReadingDto> findAll() {
        return bookReadingMapper.toDtoList(bookReadingRepository.findAll());
    }

    @Override
    @Transactional
    public BookReadingDto findByBookId(Long bookId) {
        return bookReadingMapper.toDto(bookReadingRepository.findBookReadingByBookId(bookId));
    }

    @Override
    @Transactional
    public BookReadingDto save(BookReadingDto bookReadingDto) {
        return bookReadingMapper.toDto(bookReadingRepository.save(bookReadingMapper.toEntity(bookReadingDto)));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        bookReadingRepository.deleteById(id);
    }
}
