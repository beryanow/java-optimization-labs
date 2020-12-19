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
public class BookToReadDto {
    private Long id;
    private Long bookId;
    private Date dateOfAddition;
    private BookDto bookByBookId;
}
