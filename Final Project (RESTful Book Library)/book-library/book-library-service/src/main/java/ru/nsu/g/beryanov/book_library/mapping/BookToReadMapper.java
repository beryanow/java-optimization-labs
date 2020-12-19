package ru.nsu.g.beryanov.book_library.mapping;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ru.nsu.g.beryanov.book_library.dto.BookToReadDto;
import ru.nsu.g.beryanov.book_library.model.BookToRead;

import java.util.List;

@Mapper(uses = {BookMapper.class}, componentModel = "spring")
public interface BookToReadMapper {
    @Mapping(target = "bookByBookId", qualifiedByName = "toIncompleteBookDto")
    BookToReadDto toDto(BookToRead bookToRead);
    BookToRead toEntity(BookToReadDto bookToReadDto);

    @Named("toIncompleteBookToReadDto")
    @Mapping(target = "bookByBookId", ignore = true)
    BookToReadDto toIncompleteDto(BookToRead bookToRead);

    @Named("toIncompleteBookToReadDtoList")
    @IterableMapping(qualifiedByName = "toIncompleteBookToReadDto")
    List<BookToReadDto> toIncompleteDtoList(List<BookToRead> bookToReadList);

    List<BookToReadDto> toDtoList(List<BookToRead> bookToReadList);
    List<BookToRead> toEntityList(List<BookToReadDto> bookToReadDtoList);
}
