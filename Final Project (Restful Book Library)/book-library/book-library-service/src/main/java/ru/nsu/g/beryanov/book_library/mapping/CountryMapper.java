package ru.nsu.g.beryanov.book_library.mapping;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ru.nsu.g.beryanov.book_library.dto.CountryDto;
import ru.nsu.g.beryanov.book_library.model.Country;

import java.util.List;

@Mapper(uses = {AddressMapper.class}, componentModel = "spring")
public interface CountryMapper {
    @Mapping(target = "addressesById", qualifiedByName = "toIncompleteAddressDtoList")
    CountryDto toDto(Country country);
    Country toEntity(CountryDto countryDto);

    @Named("toIncompleteCountryDto")
    @Mapping(target = "addressesById", ignore = true)
    CountryDto toIncompleteDto(Country country);

    @Named("toIncompleteCountryDtoList")
    @IterableMapping(qualifiedByName = "toIncompleteCountryDto")
    List<CountryDto> toIncompleteDtoList(List<Country> countryList);

    List<CountryDto> toDtoList(List<Country> countryList);
    List<Country> toEntityList(List<CountryDto> countryDtoList);
}
