package ru.nsu.g.beryanov.book_library.mapping;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ru.nsu.g.beryanov.book_library.dto.BookReadingDto;
import ru.nsu.g.beryanov.book_library.model.BookReading;

import java.util.List;

@Mapper(uses = {BookMapper.class}, componentModel = "spring")
public interface BookReadingMapper {
    @Mapping(target = "bookByBookId", qualifiedByName = "toIncompleteBookDto")
    BookReadingDto toDto(BookReading bookReading);
    BookReading toEntity(BookReadingDto bookReadingDto);

    @Named("toIncompleteBookReadingDto")
    @Mapping(target = "bookByBookId", ignore = true)
    BookReadingDto toIncompleteDto(BookReading bookReading);

    @Named("toIncompleteBookReadingDtoList")
    @IterableMapping(qualifiedByName = "toIncompleteBookReadingDto")
    List<BookReadingDto> toIncompleteDtoList(List<BookReading> bookReadingList);

    List<BookReadingDto> toDtoList(List<BookReading> bookReadingList);
    List<BookReading> toEntityList(List<BookReadingDto> bookReadingDtoList);
}
