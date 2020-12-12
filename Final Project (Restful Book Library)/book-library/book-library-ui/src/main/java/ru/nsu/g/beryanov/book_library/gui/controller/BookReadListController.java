package ru.nsu.g.beryanov.book_library.gui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import ru.nsu.g.beryanov.book_library.dto.BookReadDto;
import ru.nsu.g.beryanov.book_library.service.BookReadService;

import javax.swing.*;
import java.awt.*;

@Controller
public class BookReadListController {
    @Autowired
    @Qualifier(value = "bookReadListModel")
    private DefaultListModel<BookReadDto> bookReadListModel;

    @Autowired
    @Qualifier(value = "bookReadPanel")
    private JPanel bookReadPanel;

    @Autowired
    @Qualifier(value = "bookReadList")
    private JList<BookReadDto> bookReadList;

    @Autowired
    @Qualifier(value = "noBookRead")
    private JLabel noBookRead;

    @Autowired
    private BookReadService bookReadService;

    public void updateBookReadList() {
        bookReadListModel.removeAllElements();
        bookReadService.findAll().forEach(bookReadListModel::addElement);

        bookReadPanel.removeAll();
        bookReadPanel.repaint();
        bookReadPanel.revalidate();

        if (bookReadListModel.size() > 0) {
            bookReadList.setModel(bookReadListModel);

            JScrollPane scrollPane = new JScrollPane(bookReadList);
            scrollPane.setBorder(BorderFactory.createLineBorder(Color.lightGray));

            bookReadPanel.add(scrollPane);
        } else {
            bookReadPanel.add(Box.createRigidArea(new Dimension(0, 80)));
            bookReadPanel.add(noBookRead);
        }
    }
}
