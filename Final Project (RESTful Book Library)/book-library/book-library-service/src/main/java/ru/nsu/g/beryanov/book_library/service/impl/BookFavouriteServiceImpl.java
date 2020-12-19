package ru.nsu.g.beryanov.book_library.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsu.g.beryanov.book_library.dto.BookFavouriteDto;
import ru.nsu.g.beryanov.book_library.mapping.BookFavouriteMapper;
import ru.nsu.g.beryanov.book_library.repository.BookFavouriteRepository;
import ru.nsu.g.beryanov.book_library.service.BookFavouriteService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookFavouriteServiceImpl implements BookFavouriteService {
    private final BookFavouriteRepository bookFavouriteRepository;
    private final BookFavouriteMapper bookFavouriteMapper;

    @Override
    @Transactional
    public List<BookFavouriteDto> findAll() {
        return bookFavouriteMapper.toDtoList(bookFavouriteRepository.findAll());
    }

    @Override
    @Transactional
    public BookFavouriteDto save(BookFavouriteDto bookFavouriteDto) {
        return bookFavouriteMapper.toDto(bookFavouriteRepository.save(bookFavouriteMapper.toEntity(bookFavouriteDto)));
    }

    @Override
    @Transactional
    public BookFavouriteDto findByBookId(Long bookId) {
        return bookFavouriteMapper.toDto(bookFavouriteRepository.findBookFavouriteByBookId(bookId));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        bookFavouriteRepository.deleteById(id);
    }
}
