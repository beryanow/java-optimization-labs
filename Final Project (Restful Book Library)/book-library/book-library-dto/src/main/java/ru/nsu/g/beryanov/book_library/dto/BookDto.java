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
public class BookDto {
    private Long id;
    private String name;
    private Long authorId;
    private Long genreId;
    private Byte[] image;
    private AuthorDto authorByAuthorId;
    private GenreDto genreByGenreId;
    private List<BookReadDto> booksReadById;
    private List<BookReadingDto> booksReadingById;
    private List<BookToReadDto> booksToReadById;
    private List<BookFavouriteDto> booksFavouriteById;
}
