package ru.nsu.g.beryanov.book_library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nsu.g.beryanov.book_library.model.BookReading;

@Repository
public interface BookReadingRepository extends JpaRepository<BookReading, Long> {
    BookReading findBookReadingByBookId(Long bookId);
}
