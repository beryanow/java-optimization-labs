package ru.nsu.g.beryanov.book_library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nsu.g.beryanov.book_library.model.BookRead;

import java.util.Date;
import java.util.List;

@Repository
public interface BookReadRepository extends JpaRepository<BookRead, Long> {
    List<BookRead> findAllByDateOfCompletionBetween(Date startDate, Date stopDate);
    BookRead findBookReadByBookId(Long bookId);
    List<BookRead> findAllByAssessmentId(Long assessmentId);
}
