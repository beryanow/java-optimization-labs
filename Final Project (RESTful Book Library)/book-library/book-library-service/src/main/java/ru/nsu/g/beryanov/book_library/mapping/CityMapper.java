package ru.nsu.g.beryanov.book_library.mapping;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ru.nsu.g.beryanov.book_library.dto.CityDto;
import ru.nsu.g.beryanov.book_library.model.City;

import java.util.List;

@Mapper(uses = {AddressMapper.class}, componentModel = "spring")
public interface CityMapper {
    @Mapping(target = "addressesById", qualifiedByName = "toIncompleteAddressDtoList")
    CityDto toDto(City city);
    City toEntity(CityDto cityDto);

    @Named("toIncompleteCityDto")
    @Mapping(target = "addressesById", ignore = true)
    CityDto toIncompleteDto(City city);

    @Named("toIncompleteCityDtoList")
    @IterableMapping(qualifiedByName = "toIncompleteCityDto")
    List<CityDto> toIncompleteDtoList(List<City> cityList);

    List<CityDto> toDtoList(List<City> cityList);
    List<City> toEntityList(List<CityDto> cityDtoList);
}
