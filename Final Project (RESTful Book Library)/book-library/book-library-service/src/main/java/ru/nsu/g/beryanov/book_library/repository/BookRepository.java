package ru.nsu.g.beryanov.book_library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nsu.g.beryanov.book_library.model.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByAuthorId(Long authorId);
    List<Book> findAllByGenreId(Long genreId);
}
