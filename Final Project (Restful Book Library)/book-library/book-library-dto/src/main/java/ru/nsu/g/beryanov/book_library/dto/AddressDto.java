package ru.nsu.g.beryanov.book_library.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
    private Long id;
    private Long countryId;
    private Long cityId;
    private CountryDto countryByCountryId;
    private CityDto cityByCityId;
    private List<AuthorDto> authorsById;
}
