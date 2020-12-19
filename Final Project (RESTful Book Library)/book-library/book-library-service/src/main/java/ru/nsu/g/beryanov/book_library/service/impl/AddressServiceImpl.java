package ru.nsu.g.beryanov.book_library.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsu.g.beryanov.book_library.dto.AddressDto;
import ru.nsu.g.beryanov.book_library.mapping.AddressMapper;
import ru.nsu.g.beryanov.book_library.repository.AddressRepository;
import ru.nsu.g.beryanov.book_library.service.AddressService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    @Override
    @Transactional
    public List<AddressDto> findAll() {
        return addressMapper.toDtoList(addressRepository.findAll());
    }

    @Override
    @Transactional
    public AddressDto save(AddressDto addressDto) {
        return addressMapper.toDto(addressRepository.save(addressMapper.toEntity(addressDto)));
    }
}
