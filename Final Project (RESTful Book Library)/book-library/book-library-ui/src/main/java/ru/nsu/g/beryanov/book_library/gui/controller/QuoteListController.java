package ru.nsu.g.beryanov.book_library.gui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import ru.nsu.g.beryanov.book_library.dto.BookDto;
import ru.nsu.g.beryanov.book_library.dto.BookReadDto;
import ru.nsu.g.beryanov.book_library.service.BookReadService;

import javax.swing.*;
import java.awt.*;
import java.util.List;

@Controller
public class QuoteListController {
    @Autowired
    @Qualifier(value = "quotePanel")
    private JPanel quotePanel;

    @Autowired
    @Qualifier(value = "bookList")
    private JList<BookDto> bookList;

    @Autowired
    private BookReadService bookReadService;

    public void updateQuoteList() {
        BookDto selectedBook = bookList.getSelectedValue();

        Long bookId = selectedBook.getId();

        List<BookReadDto> bookReadDtoList = bookReadService.findAll();

        String quote = "";
        for (BookReadDto bookReadDto : bookReadDtoList) {
            if (bookReadDto.getBookId().equals(bookId)) {
                quote = bookReadDto.getQuoteByQuoteId().getContent();
                break;
            }
        }

        quotePanel.removeAll();
        quotePanel.add(Box.createRigidArea(new Dimension(0, 100)));
        quotePanel.add(new JTextArea(quote));

        quotePanel.repaint();
        quotePanel.revalidate();
    }
}
