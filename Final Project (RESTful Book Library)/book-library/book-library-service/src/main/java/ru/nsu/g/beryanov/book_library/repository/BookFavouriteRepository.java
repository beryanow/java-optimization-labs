package ru.nsu.g.beryanov.book_library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nsu.g.beryanov.book_library.model.BookFavourite;

@Repository
public interface BookFavouriteRepository extends JpaRepository<BookFavourite, Long> {
    BookFavourite findBookFavouriteByBookId(Long bookId);
}
