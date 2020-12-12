package ru.nsu.g.beryanov.book_library.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsu.g.beryanov.book_library.dto.BookDto;
import ru.nsu.g.beryanov.book_library.mapping.BookMapper;
import ru.nsu.g.beryanov.book_library.repository.BookRepository;
import ru.nsu.g.beryanov.book_library.service.BookService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    @Transactional
    public List<BookDto> findAll() {
        return bookMapper.toDtoList(bookRepository.findAll());
    }

    @Override
    @Transactional
    public BookDto save(BookDto bookDto) {
        return bookMapper.toDto(bookRepository.save(bookMapper.toEntity(bookDto)));
    }

    @Override
    @Transactional
    public BookDto findById(Long id) {
        return bookMapper.toDto(bookRepository.findById(id).orElse(null));
    }

    @Override
    @Transactional
    public List<BookDto> findAllByAuthorId(Long authorId) {
        return bookMapper.toDtoList(bookRepository.findAllByAuthorId(authorId));
    }

    @Override
    @Transactional
    public List<BookDto> findAllByGenreId(Long genreId) {
        return bookMapper.toDtoList(bookRepository.findAllByGenreId(genreId));
    }
}
