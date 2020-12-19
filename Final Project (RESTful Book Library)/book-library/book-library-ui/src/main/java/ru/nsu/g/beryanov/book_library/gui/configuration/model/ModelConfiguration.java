package ru.nsu.g.beryanov.book_library.gui.configuration.model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.nsu.g.beryanov.book_library.dto.BookDto;
import ru.nsu.g.beryanov.book_library.dto.BookFavouriteDto;
import ru.nsu.g.beryanov.book_library.dto.BookReadDto;
import ru.nsu.g.beryanov.book_library.dto.BookReadingDto;
import ru.nsu.g.beryanov.book_library.dto.BookToReadDto;

import javax.swing.*;

@Configuration
public class ModelConfiguration {
    @Bean(name = "bookListModel")
    public DefaultListModel<BookDto> bookListModel() {
        return new DefaultListModel<>();
    }

    @Bean(name = "bookToReadListModel")
    public DefaultListModel<BookToReadDto> bookToReadListModel() {
        return new DefaultListModel<>();
    }

    @Bean(name = "bookReadingListModel")
    public DefaultListModel<BookReadingDto> bookReadingListModel() {
        return new DefaultListModel<>();
    }

    @Bean(name = "bookReadListModel")
    public DefaultListModel<BookReadDto> bookReadListModel() {
        return new DefaultListModel<>();
    }

    @Bean(name = "bookReadThisMonthListModel")
    public DefaultListModel<BookReadDto> bookReadThisMonthListModel() {
        return new DefaultListModel<>();
    }

    @Bean(name = "favouritesListModel")
    public DefaultListModel<BookFavouriteDto> favouritesListModel() {
        return new DefaultListModel<>();
    }
}
