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
public class BookReadingDto {
    private Long id;
    private Long bookId;
    private Date startDate;
    private BookDto bookByBookId;
}
