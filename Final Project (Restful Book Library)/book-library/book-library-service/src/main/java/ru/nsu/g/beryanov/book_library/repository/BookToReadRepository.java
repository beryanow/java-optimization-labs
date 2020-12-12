package ru.nsu.g.beryanov.book_library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nsu.g.beryanov.book_library.model.BookToRead;

@Repository
public interface BookToReadRepository extends JpaRepository<BookToRead, Long> {
    BookToRead findBookToReadByBookId(Long bookId);
}
