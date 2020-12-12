package ru.nsu.g.beryanov.book_library.mapping;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ru.nsu.g.beryanov.book_library.dto.GenreDto;
import ru.nsu.g.beryanov.book_library.model.Genre;

import java.util.List;

@Mapper(uses = {BookMapper.class}, componentModel = "spring")
public interface GenreMapper {
    @Mapping(target = "booksById", qualifiedByName = "toIncompleteBookDtoList")
    GenreDto toDto(Genre genre);
    Genre toEntity(GenreDto genreDto);

    @Named("toIncompleteGenreDto")
    @Mapping(target = "booksById", ignore = true)
    GenreDto toIncompleteDto(Genre genre);

    @Named("toIncompleteGenreDtoList")
    @IterableMapping(qualifiedByName = "toIncompleteGenreDto")
    List<GenreDto> toIncompleteDtoList(List<Genre> genreList);

    List<GenreDto> toDtoList(List<Genre> genreList);
    List<Genre> toEntityList(List<GenreDto> genreDtoList);
}
