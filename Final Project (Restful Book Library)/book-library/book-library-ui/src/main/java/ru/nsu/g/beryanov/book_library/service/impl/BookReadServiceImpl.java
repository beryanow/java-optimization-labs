package ru.nsu.g.beryanov.book_library.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsu.g.beryanov.book_library.dto.BookReadDto;
import ru.nsu.g.beryanov.book_library.dto.BookToReadDto;
import ru.nsu.g.beryanov.book_library.external.ExternalCall;
import ru.nsu.g.beryanov.book_library.service.BookReadService;
import ru.nsu.g.beryanov.book_library.utility.BookLibraryServiceURL;

import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookReadServiceImpl implements BookReadService {
    @Autowired
    private ExternalCall externalCall;

    @Autowired
    private BookLibraryServiceURL bookLibraryServiceURL;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<BookReadDto> findAll() {
        return (List<BookReadDto>) externalCall.getCall(bookLibraryServiceURL.BOOK_READ_FIND_ALL, List.class).stream().map(bookHashMap -> objectMapper.convertValue(bookHashMap, BookReadDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<BookReadDto> findAllByAssessmentId(Long assessmentId) {
        return externalCall.getCall(String.format(bookLibraryServiceURL.BOOK_READ_FIND_ALL_BY_ASSESSMENT_ID, assessmentId), List.class);
    }

    @SneakyThrows
    @Override
    public List<BookReadDto> findAllInCurrentMonth(int year, int month) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String MM = String.valueOf(month);
        if (MM.length() == 1) {
            MM = "0" + MM;
        }

        String dd = "31";
        switch (Month.of(month)) {
            case JANUARY:
                dd = "31";
                break;
            case FEBRUARY:
                dd = year % 4 == 0 ? "29" : "28";
                break;
            case MARCH:
                dd = "31";
                break;
            case APRIL:
                dd = "30";
                break;
            case MAY:
                dd = "31";
                break;
            case JUNE:
                dd = "30";
                break;
            case JULY:
                dd = "31";
                break;
            case AUGUST:
                dd = "31";
                break;
            case SEPTEMBER:
                dd = "30";
                break;
            case OCTOBER:
                dd = "31";
                break;
            case NOVEMBER:
                dd = "30";
                break;
            case DECEMBER:
                dd = "31";
                break;
        }

        Date startDate = dateFormat.parse(year + "-" + MM + "-" + "01");
        Date stopDate = dateFormat.parse(year + "-" + MM + "-" + dd);
        return (List<BookReadDto>) externalCall.getCall(String.format(bookLibraryServiceURL.BOOK_READ_FIND_ALL_BY_DATE, year, month), List.class).stream().map(bookRead -> objectMapper.convertValue(bookRead, BookReadDto.class)).collect(Collectors.toList());
    }

    @SneakyThrows
    @Override
    public BookReadDto save(BookReadDto bookReadDto) {
        return externalCall.postCall(objectMapper.writeValueAsString(bookReadDto), bookLibraryServiceURL.BOOK_READ_SAVE, BookReadDto.class);
    }

    @Override
    public BookReadDto findByBookId(Long bookId) {
        return externalCall.getCall(String.format(bookLibraryServiceURL.BOOK_READ_FIND_BY_BOOK_ID, bookId), BookReadDto.class);
    }

    @Override
    public void deleteById(Long id) {
        externalCall.postCall("", String.format(bookLibraryServiceURL.BOOK_READ_DELETE, id), BookReadDto.class);
    }
}
