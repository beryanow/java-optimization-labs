package ru.nsu.g.beryanov.book_library.mapping;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ru.nsu.g.beryanov.book_library.dto.BookFavouriteDto;
import ru.nsu.g.beryanov.book_library.model.BookFavourite;

import java.util.List;

@Mapper(uses = {BookMapper.class}, componentModel = "spring")
public interface BookFavouriteMapper {
    @Mapping(target = "bookByBookId", qualifiedByName = "toIncompleteBookDto")
    BookFavouriteDto toDto(BookFavourite bookFavourite);
    BookFavourite toEntity(BookFavouriteDto bookFavouriteDto);

    @Named("toIncompleteBookFavouriteDto")
    @Mapping(target = "bookByBookId", ignore = true)
    BookFavouriteDto toIncompleteDto(BookFavourite bookFavourite);

    @Named("toIncompleteBookFavouriteDtoList")
    @IterableMapping(qualifiedByName = "toIncompleteBookFavouriteDto")
    List<BookFavouriteDto> toIncompleteDtoList(List<BookFavourite> bookFavouriteList);

    List<BookFavouriteDto> toDtoList(List<BookFavourite> bookFavouriteList);
    List<BookFavourite> toEntityList(List<BookFavouriteDto> bookFavouriteDtoList);
}
