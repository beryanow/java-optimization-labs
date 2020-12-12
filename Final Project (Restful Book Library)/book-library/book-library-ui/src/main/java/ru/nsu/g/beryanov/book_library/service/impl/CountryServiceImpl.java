package ru.nsu.g.beryanov.book_library.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsu.g.beryanov.book_library.dto.CountryDto;
import ru.nsu.g.beryanov.book_library.external.ExternalCall;
import ru.nsu.g.beryanov.book_library.service.CountryService;
import ru.nsu.g.beryanov.book_library.utility.BookLibraryServiceURL;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {
    @Autowired
    private ExternalCall externalCall;

    @Autowired
    private BookLibraryServiceURL bookLibraryServiceURL;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<CountryDto> findAll() {
        return externalCall.getCall(bookLibraryServiceURL.COUNTRY_FIND_ALL, List.class);
    }

    @SneakyThrows
    @Override
    public CountryDto save(CountryDto countryDto) {
        return externalCall.postCall(objectMapper.writeValueAsString(countryDto), bookLibraryServiceURL.COUNTRY_SAVE, CountryDto.class);
    }
}
