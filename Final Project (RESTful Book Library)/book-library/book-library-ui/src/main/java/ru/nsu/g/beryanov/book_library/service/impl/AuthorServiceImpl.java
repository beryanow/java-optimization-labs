package ru.nsu.g.beryanov.book_library.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsu.g.beryanov.book_library.dto.AuthorDto;
import ru.nsu.g.beryanov.book_library.external.ExternalCall;
import ru.nsu.g.beryanov.book_library.service.AuthorService;
import ru.nsu.g.beryanov.book_library.utility.BookLibraryServiceURL;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private ExternalCall externalCall;

    @Autowired
    private BookLibraryServiceURL bookLibraryServiceURL;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<AuthorDto> findAll() {
        return externalCall.getCall(bookLibraryServiceURL.AUTHOR_FIND_ALL, List.class);
    }

    @Override
    public AuthorDto findById(Long id) {
        return externalCall.getCall(String.format(bookLibraryServiceURL.AUTHOR_FIND_BY_ID, id), AuthorDto.class);
    }

    @Override
    public AuthorDto findByName(String name) {
        return externalCall.getCall(String.format(bookLibraryServiceURL.AUTHOR_FIND_BY_NAME, name), AuthorDto.class);
    }

    @SneakyThrows
    @Override
    public AuthorDto save(AuthorDto authorDto) {
        return externalCall.postCall(objectMapper.writeValueAsString(authorDto), bookLibraryServiceURL.AUTHOR_SAVE, AuthorDto.class);
    }
}
