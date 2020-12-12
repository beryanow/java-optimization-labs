package ru.nsu.g.beryanov.book_library.gui.configuration.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.nsu.g.beryanov.book_library.dto.BookDto;
import ru.nsu.g.beryanov.book_library.dto.BookFavouriteDto;
import ru.nsu.g.beryanov.book_library.dto.BookReadDto;
import ru.nsu.g.beryanov.book_library.dto.BookReadingDto;
import ru.nsu.g.beryanov.book_library.dto.BookToReadDto;
import ru.nsu.g.beryanov.book_library.dto.QuoteDto;
import ru.nsu.g.beryanov.book_library.gui.component.BookEntityRenderer;
import ru.nsu.g.beryanov.book_library.gui.component.BookReadSectionEntityRenderer;
import ru.nsu.g.beryanov.book_library.gui.component.BookReadThisMonthSectionEntityRenderer;
import ru.nsu.g.beryanov.book_library.gui.component.BookReadingSectionEntityRenderer;
import ru.nsu.g.beryanov.book_library.gui.component.BookToReadSectionEntityRenderer;
import ru.nsu.g.beryanov.book_library.gui.component.FavouritesEntityRenderer;
import ru.nsu.g.beryanov.book_library.gui.component.QuoteEntityRenderer;
import ru.nsu.g.beryanov.book_library.gui.controller.ListenerController;

import javax.annotation.PostConstruct;
import javax.swing.*;

@Configuration(value = "listConfiguration")
public class ListConfiguration {
    @Autowired
    private BookReadSectionEntityRenderer bookReadSectionEntityRenderer;

    @Autowired
    private BookToReadSectionEntityRenderer bookToReadSectionEntityRenderer;

    @Autowired
    private BookReadingSectionEntityRenderer bookReadingSectionEntityRenderer;

    @Autowired
    private BookReadThisMonthSectionEntityRenderer bookReadThisMonthSectionEntityRenderer;

    @Autowired
    private BookEntityRenderer bookEntityRenderer;

    @Autowired
    private FavouritesEntityRenderer favouritesEntityRenderer;

    @Bean(name = "bookList")
    public JList<BookDto> bookList() {
        JList<BookDto> bookList = new JList<>();
        bookList.setCellRenderer(bookEntityRenderer);
        bookList.setLayoutOrientation(JList.VERTICAL);
        return bookList;
    }

    @Bean(name = "bookToReadList")
    public JList<BookToReadDto> bookToReadList() {
        JList<BookToReadDto> bookToReadList = new JList<>();
        bookToReadList.setLayoutOrientation(JList.VERTICAL);
        bookToReadList.setCellRenderer(bookToReadSectionEntityRenderer);
        return bookToReadList;
    }

    @Bean(name = "bookReadingList")
    public JList<BookReadingDto> bookReadingList() {
        JList<BookReadingDto> bookReadingList = new JList<>();
        bookReadingList.setLayoutOrientation(JList.VERTICAL);
        bookReadingList.setCellRenderer(bookReadingSectionEntityRenderer);
        return bookReadingList;
    }

    @Bean(name = "bookReadList")
    public JList<BookReadDto> bookReadList() {
        JList<BookReadDto> bookReadList = new JList<>();
        bookReadList.setLayoutOrientation(JList.VERTICAL);
        bookReadList.setCellRenderer(bookReadSectionEntityRenderer);
        return bookReadList;
    }

    @Bean(name = "bookReadThisMonthList")
    public JList<BookReadDto> bookReadThisMonthList() {
        JList<BookReadDto> bookReadThisMonthList = new JList<>();
        bookReadThisMonthList.setLayoutOrientation(JList.VERTICAL);
        bookReadThisMonthList.setCellRenderer(bookReadThisMonthSectionEntityRenderer);
        return bookReadThisMonthList;
    }

    @Bean(name = "favouritesList")
    public JList<BookFavouriteDto> favouritesList() {
        JList<BookFavouriteDto> favouritesList = new JList<>();
        favouritesList.setLayoutOrientation(JList.VERTICAL);
        favouritesList.setCellRenderer(favouritesEntityRenderer);
        return favouritesList;
    }

    @Bean(name = "quoteList")
    public JList<QuoteDto> quoteList() {
        JList<QuoteDto> quoteList = new JList<>();
        quoteList.setLayoutOrientation(JList.VERTICAL);
        quoteList.setCellRenderer(new QuoteEntityRenderer());
        return quoteList;
    }

    @Autowired
    private ListenerController listenerController;

    @PostConstruct
    private void initializeListener() {
        listenerController.addBookListListener();
    }
}
