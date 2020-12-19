package ru.nsu.g.beryanov.book_library.service;


import ru.nsu.g.beryanov.book_library.dto.AddressDto;

import java.util.List;

public interface AddressService {
    List<AddressDto> findAll();
    AddressDto save(AddressDto addressDto);
}
