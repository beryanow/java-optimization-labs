package ru.nsu.g.beryanov.book_library.mapping;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ru.nsu.g.beryanov.book_library.dto.AuthorDto;
import ru.nsu.g.beryanov.book_library.model.Author;

import java.util.List;

@Mapper(uses = {BookMapper.class, AddressMapper.class}, componentModel = "spring")
public interface AuthorMapper {
    @Mapping(target = "addressByAddressId", qualifiedByName = "toIncompleteAddressDto")
    @Mapping(target = "booksById", qualifiedByName = "toIncompleteBookDtoList")
    AuthorDto toDto(Author author);
    Author toEntity(AuthorDto authorDto);

    @Named("toIncompleteAuthorDto")
    @Mapping(target = "addressByAddressId", ignore = true)
    @Mapping(target = "booksById", ignore = true)
    AuthorDto toIncompleteDto(Author author);

    @Named("toIncompleteAuthorDtoList")
    @IterableMapping(qualifiedByName = "toIncompleteAuthorDto")
    List<AuthorDto> toIncompleteDtoList(List<Author> authorList);

    List<AuthorDto> toDtoList(List<Author> authorList);
    List<Author> toEntityList(List<AuthorDto> authorDtoList);
}
