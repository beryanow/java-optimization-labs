package ru.nsu.g.beryanov.book_library.gui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Controller;
import ru.nsu.g.beryanov.book_library.dto.BookDto;
import ru.nsu.g.beryanov.book_library.service.BookService;

import javax.swing.*;
import java.awt.*;

@Controller
@DependsOn(value = "listConfiguration")
public class BookListController {
    @Autowired
    @Qualifier(value = "bookPanel")
    private JPanel bookPanel;

    @Autowired
    @Qualifier(value = "bookListModel")
    private DefaultListModel<BookDto> bookListModel;

    @Autowired
    @Qualifier(value = "bookList")
    private JList<BookDto> bookList;

    @Autowired
    @Qualifier(value = "filterButton")
    private JButton filterButton;

    @Autowired
    @Qualifier(value = "addBookButton")
    private JButton addBookButton;

    @Autowired
    private BookService bookService;

    public void drawBookList() {
        bookPanel.removeAll();
        bookPanel.repaint();
        bookPanel.revalidate();

        JScrollPane scrollPane = new JScrollPane(bookList);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.lightGray));

        bookPanel.add(scrollPane);

        JPanel buttonsPanel = new JPanel(new FlowLayout());
        buttonsPanel.setBackground(Color.WHITE);
        buttonsPanel.add(filterButton);
        buttonsPanel.add(addBookButton);

        bookPanel.add(buttonsPanel);
    }

    public void updateBookList() {
        bookListModel.removeAllElements();
        bookService.findAll().forEach(bookListModel::addElement);
        bookList.setModel(bookListModel);

        drawBookList();
    }
}
