package ru.nsu.g.beryanov.book_library.gui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import ru.nsu.g.beryanov.book_library.dto.BookReadingDto;
import ru.nsu.g.beryanov.book_library.service.BookReadingService;

import javax.swing.*;
import java.awt.*;

@Controller
public class BookReadingListController {
    @Autowired
    @Qualifier(value = "bookReadingListModel")
    private DefaultListModel<BookReadingDto> bookReadingListModel;

    @Autowired
    @Qualifier(value = "bookReadingPanel")
    private JPanel bookReadingPanel;

    @Autowired
    @Qualifier(value = "bookReadingList")
    private JList<BookReadingDto> bookReadingList;

    @Autowired
    @Qualifier(value = "noBookReading")
    private JLabel noBookReading;

    @Autowired
    private BookReadingService bookReadingService;

    public void updateBookReadingList() {
        bookReadingListModel.removeAllElements();
        bookReadingService.findAll().forEach(bookReadingListModel::addElement);

        bookReadingPanel.removeAll();
        bookReadingPanel.repaint();
        bookReadingPanel.revalidate();

        if (bookReadingListModel.size() > 0) {
            bookReadingList.setModel(bookReadingListModel);

            JScrollPane scrollPane = new JScrollPane(bookReadingList);
            scrollPane.setBorder(BorderFactory.createLineBorder(Color.lightGray));

            bookReadingPanel.add(scrollPane);
        } else {
            bookReadingPanel.add(Box.createRigidArea(new Dimension(0, 80)));
            bookReadingPanel.add(noBookReading);
        }
    }
}
