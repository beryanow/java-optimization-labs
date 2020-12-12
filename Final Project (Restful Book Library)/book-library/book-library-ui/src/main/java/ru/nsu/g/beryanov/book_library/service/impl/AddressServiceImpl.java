package ru.nsu.g.beryanov.book_library.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsu.g.beryanov.book_library.dto.AddressDto;
import ru.nsu.g.beryanov.book_library.external.ExternalCall;
import ru.nsu.g.beryanov.book_library.service.AddressService;
import ru.nsu.g.beryanov.book_library.utility.BookLibraryServiceURL;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    @Autowired
    private ExternalCall externalCall;

    @Autowired
    private BookLibraryServiceURL bookLibraryServiceURL;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<AddressDto> findAll() {
        return externalCall.getCall(bookLibraryServiceURL.ADDRESS_FIND_ALL, List.class);
    }

    @Override
    @SneakyThrows
    public AddressDto save(AddressDto addressDto) {
        return externalCall.postCall(objectMapper.writeValueAsString(addressDto), bookLibraryServiceURL.ADDRESS_FIND_ALL, AddressDto.class);
    }
}
