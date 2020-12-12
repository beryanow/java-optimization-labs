package ru.nsu.g.beryanov.book_library.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookReadDto {
    private Long id;
    private Long bookId;
    private Long quoteId;
    private Long assessmentId;
    private Date dateOfCompletion;
    private BookDto bookByBookId;
    private QuoteDto quoteByQuoteId;
    private AssessmentDto assessmentByAssessmentId;
}
