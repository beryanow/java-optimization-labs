package ru.nsu.g.beryanov.book_library.mapping;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ru.nsu.g.beryanov.book_library.dto.BookReadDto;
import ru.nsu.g.beryanov.book_library.model.BookRead;

import java.util.List;

@Mapper(uses = {BookMapper.class, QuoteMapper.class, AssessmentMapper.class}, componentModel = "spring")
public interface BookReadMapper {
    @Mapping(target = "bookByBookId", qualifiedByName = "toIncompleteBookDto")
    @Mapping(target = "quoteByQuoteId", qualifiedByName = "toIncompleteQuoteDto")
    @Mapping(target = "assessmentByAssessmentId", qualifiedByName = "toIncompleteAssessmentDto")
    BookReadDto toDto(BookRead bookRead);
    BookRead toEntity(BookReadDto bookReadDto);

    @Named("toIncompleteBookReadDto")
    @Mapping(target = "bookByBookId", ignore = true)
    @Mapping(target = "quoteByQuoteId", ignore = true)
    @Mapping(target = "assessmentByAssessmentId", ignore = true)
    BookReadDto toIncompleteDto(BookRead bookRead);

    @Named("toIncompleteBookReadDtoList")
    @IterableMapping(qualifiedByName = "toIncompleteBookReadDto")
    List<BookReadDto> toIncompleteDtoList(List<BookRead> bookReadList);

    List<BookReadDto> toDtoList(List<BookRead> bookReadList);
    List<BookRead> toEntityList(List<BookReadDto> bookReadDtoList);
}
