package ru.nsu.g.beryanov.book_library.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.g.beryanov.book_library.dto.AddressDto;
import ru.nsu.g.beryanov.book_library.service.AddressService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/address")
public class AddressController {
    private final AddressService addressService;

    @GetMapping("/all")
    public List<AddressDto> findAll() {
        return addressService.findAll();
    }

    @PostMapping("/save")
    public AddressDto save(@RequestBody AddressDto addressDto) {
        return addressService.save(addressDto);
    }
}
