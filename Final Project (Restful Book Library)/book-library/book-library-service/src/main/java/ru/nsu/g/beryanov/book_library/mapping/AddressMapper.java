package ru.nsu.g.beryanov.book_library.mapping;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ru.nsu.g.beryanov.book_library.dto.AddressDto;
import ru.nsu.g.beryanov.book_library.model.Address;

import java.util.List;

@Mapper(uses = {AuthorMapper.class, CountryMapper.class, CityMapper.class}, componentModel = "spring")
public interface AddressMapper {
    @Mapping(target = "countryByCountryId", qualifiedByName = "toIncompleteCountryDto")
    @Mapping(target = "cityByCityId", qualifiedByName = "toIncompleteCityDto")
    @Mapping(target = "authorsById", qualifiedByName = "toIncompleteAuthorDtoList")
    AddressDto toDto(Address address);
    Address toEntity(AddressDto addressDto);

    @Named("toIncompleteAddressDto")
    @Mapping(target = "countryByCountryId", ignore = true)
    @Mapping(target = "cityByCityId", ignore = true)
    @Mapping(target = "authorsById", ignore = true)
    AddressDto toIncompleteDto(Address address);

    @Named("toIncompleteAddressDtoList")
    @IterableMapping(qualifiedByName = "toIncompleteAddressDto")
    List<AddressDto> toIncompleteDtoList(List<Address> addressList);

    List<AddressDto> toDtoList(List<Address> addressList);
    List<Address> toEntityList(List<AddressDto> addressDtoList);
}
