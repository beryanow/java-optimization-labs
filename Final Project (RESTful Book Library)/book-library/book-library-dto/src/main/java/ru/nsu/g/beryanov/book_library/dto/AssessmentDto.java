package ru.nsu.g.beryanov.book_library.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssessmentDto {
    private Long id;
    private Byte grade;
    private List<BookReadDto> booksReadById;
}
