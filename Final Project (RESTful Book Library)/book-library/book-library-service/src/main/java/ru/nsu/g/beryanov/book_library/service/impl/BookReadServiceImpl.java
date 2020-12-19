package ru.nsu.g.beryanov.book_library.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import ru.nsu.g.beryanov.book_library.dto.BookReadDto;
import ru.nsu.g.beryanov.book_library.mapping.BookReadMapper;
import ru.nsu.g.beryanov.book_library.repository.BookReadRepository;
import ru.nsu.g.beryanov.book_library.service.BookReadService;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookReadServiceImpl implements BookReadService {
    private final BookReadRepository bookReadRepository;
    private final BookReadMapper bookReadMapper;

    @Override
    @Transactional
    public List<BookReadDto> findAll() {
        return bookReadMapper.toDtoList(bookReadRepository.findAll());
    }

    @Override
    @Transactional
    public List<BookReadDto> findAllByAssessmentId(Long assessmentId) {
        return bookReadMapper.toDtoList(bookReadRepository.findAllByAssessmentId(assessmentId));
    }

    @SneakyThrows
    @Override
    @Transactional
    public List<BookReadDto> findAllInCurrentMonth(Long year, Long month) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String MM = String.valueOf(month);
        if (MM.length() == 1) {
            MM = "0" + MM;
        }

        String dd = "31";
        switch (Month.of(Math.toIntExact(month))) {
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
        return bookReadMapper.toDtoList(bookReadRepository.findAllByDateOfCompletionBetween(startDate, stopDate));
    }

    @Override
    @Transactional
    public BookReadDto save(BookReadDto bookReadDto) {
        return bookReadMapper.toDto(bookReadRepository.save(bookReadMapper.toEntity(bookReadDto)));
    }

    @Override
    @Transactional
    public BookReadDto findByBookId(Long bookId) {
        return bookReadMapper.toDto(bookReadRepository.findBookReadByBookId(bookId));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        bookReadRepository.deleteById(id);
    }
}
