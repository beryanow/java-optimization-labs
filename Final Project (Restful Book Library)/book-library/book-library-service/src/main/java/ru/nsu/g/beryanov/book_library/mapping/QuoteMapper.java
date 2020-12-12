package ru.nsu.g.beryanov.book_library.mapping;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ru.nsu.g.beryanov.book_library.dto.QuoteDto;
import ru.nsu.g.beryanov.book_library.model.Quote;

import java.util.List;

@Mapper(uses = {BookReadMapper.class}, componentModel = "spring")
public interface QuoteMapper {
    @Mapping(target = "booksReadById", qualifiedByName = "toIncompleteBookReadDtoList")
    QuoteDto toDto(Quote quote);
    Quote toEntity(QuoteDto quoteDto);

    @Named("toIncompleteQuoteDto")
    @Mapping(target = "booksReadById", ignore = true)
    QuoteDto toIncompleteDto(Quote quote);

    @Named("toIncompleteQuoteDtoList")
    @IterableMapping(qualifiedByName = "toIncompleteQuoteDto")
    List<QuoteDto> toIncompleteDtoList(List<Quote> quoteList);

    List<QuoteDto> toDtoList(List<Quote> quoteList);
    List<Quote> toEntityList(List<QuoteDto> quoteDtoList);
}
