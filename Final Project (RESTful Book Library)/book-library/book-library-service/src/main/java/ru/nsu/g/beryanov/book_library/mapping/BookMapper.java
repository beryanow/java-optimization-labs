package ru.nsu.g.beryanov.book_library.mapping;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ru.nsu.g.beryanov.book_library.dto.BookDto;
import ru.nsu.g.beryanov.book_library.model.Book;

import java.util.List;

@Mapper(uses = {AuthorMapper.class, BookReadMapper.class, BookReadingMapper.class,
                BookToReadMapper.class, BookFavouriteMapper.class, GenreMapper.class},
                componentModel = "spring")
public interface BookMapper {
    Book toEntity(BookDto bookDto);
    @Mapping(target = "authorByAuthorId", qualifiedByName = "toIncompleteAuthorDto")
    @Mapping(target = "genreByGenreId", qualifiedByName = "toIncompleteGenreDto")
    @Mapping(target = "booksReadById", qualifiedByName = "toIncompleteBookReadDtoList")
    @Mapping(target = "booksReadingById", qualifiedByName = "toIncompleteBookReadingDtoList")
    @Mapping(target = "booksToReadById", qualifiedByName = "toIncompleteBookToReadDtoList")
    @Mapping(target = "booksFavouriteById", qualifiedByName = "toIncompleteBookFavouriteDtoList")
    BookDto toDto(Book book);

    @Named("toIncompleteBookDto")
    @Mapping(target = "image", ignore = true)
    @Mapping(target = "authorByAuthorId", ignore = true)
    @Mapping(target = "genreByGenreId", ignore = true)
    @Mapping(target = "booksReadById", ignore = true)
    @Mapping(target = "booksReadingById", ignore = true)
    @Mapping(target = "booksToReadById", ignore = true)
    @Mapping(target = "booksFavouriteById", ignore = true)
    BookDto toIncompleteDto(Book book);

    @Named("toIncompleteBookDtoList")
    @IterableMapping(qualifiedByName = "toIncompleteBookDto")
    List<BookDto> toIncompleteDtoList(List<Book> bookList);

    List<BookDto> toDtoList(List<Book> bookList);
    List<Book> toEntityList(List<BookDto> bookDtoList);
}
