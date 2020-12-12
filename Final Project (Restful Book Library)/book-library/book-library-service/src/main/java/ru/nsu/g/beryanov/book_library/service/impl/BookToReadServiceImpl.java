package ru.nsu.g.beryanov.book_library.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsu.g.beryanov.book_library.dto.BookToReadDto;
import ru.nsu.g.beryanov.book_library.mapping.BookToReadMapper;
import ru.nsu.g.beryanov.book_library.repository.BookToReadRepository;
import ru.nsu.g.beryanov.book_library.service.BookToReadService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookToReadServiceImpl implements BookToReadService {
    private final BookToReadRepository bookToReadRepository;
    private final BookToReadMapper bookToReadMapper;

    @Override
    @Transactional
    public List<BookToReadDto> findAll() {
        return bookToReadMapper.toDtoList(bookToReadRepository.findAll());
    }

    @Override
    @Transactional
    public BookToReadDto findByBookId(Long bookId) {
        return bookToReadMapper.toDto(bookToReadRepository.findBookToReadByBookId(bookId));
    }

    @Override
    @Transactional
    public BookToReadDto save(BookToReadDto bookToReadDto) {
        return bookToReadMapper.toDto(bookToReadRepository.save(bookToReadMapper.toEntity(bookToReadDto)));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        bookToReadRepository.deleteById(id);
    }
}

