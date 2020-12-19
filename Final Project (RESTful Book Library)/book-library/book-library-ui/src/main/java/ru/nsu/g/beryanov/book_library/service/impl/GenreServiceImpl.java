package ru.nsu.g.beryanov.book_library.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsu.g.beryanov.book_library.dto.GenreDto;
import ru.nsu.g.beryanov.book_library.external.ExternalCall;
import ru.nsu.g.beryanov.book_library.service.GenreService;
import ru.nsu.g.beryanov.book_library.utility.BookLibraryServiceURL;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {
    @Autowired
    private ExternalCall externalCall;

    @Autowired
    private BookLibraryServiceURL bookLibraryServiceURL;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<GenreDto> findAll() {
        return externalCall.getCall(bookLibraryServiceURL.GENRE_FIND_ALL, List.class);
    }

    @Override
    public GenreDto findByName(String name) {
        return externalCall.getCall(String.format(bookLibraryServiceURL.GENRE_FIND_BY_NAME, name), GenreDto.class);
    }

    @SneakyThrows
    @Override
    public GenreDto save(GenreDto genreDto) {
        return externalCall.postCall(objectMapper.writeValueAsString(genreDto), bookLibraryServiceURL.GENRE_SAVE, GenreDto.class);
    }
}
