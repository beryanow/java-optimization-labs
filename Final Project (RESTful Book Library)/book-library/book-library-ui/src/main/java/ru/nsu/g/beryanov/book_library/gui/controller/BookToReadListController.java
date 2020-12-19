package ru.nsu.g.beryanov.book_library.gui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import ru.nsu.g.beryanov.book_library.dto.BookToReadDto;
import ru.nsu.g.beryanov.book_library.service.BookToReadService;

import javax.swing.*;
import java.awt.*;

@Controller
public class BookToReadListController {
    @Autowired
    @Qualifier(value = "bookToReadListModel")
    private DefaultListModel<BookToReadDto> bookToReadListModel;

    @Autowired
    @Qualifier(value = "bookToReadPanel")
    private JPanel bookToReadPanel;

    @Autowired
    @Qualifier(value = "bookToReadList")
    private JList<BookToReadDto> bookToReadList;

    @Autowired
    @Qualifier(value = "noBookToRead")
    private JLabel noBookToRead;

    @Autowired
    private BookToReadService bookToReadService;

    public void updateBookToReadList() {
        bookToReadListModel.removeAllElements();
        bookToReadService.findAll().forEach(bookToReadListModel::addElement);

        bookToReadPanel.removeAll();
        bookToReadPanel.repaint();
        bookToReadPanel.revalidate();

        if (bookToReadListModel.size() > 0) {
            bookToReadList.setModel(bookToReadListModel);

            JScrollPane scrollPane = new JScrollPane(bookToReadList);
            scrollPane.setBorder(BorderFactory.createLineBorder(Color.lightGray));

            bookToReadPanel.add(scrollPane);
        } else {
            bookToReadPanel.add(Box.createRigidArea(new Dimension(0, 80)));
            bookToReadPanel.add(noBookToRead);
        }
    }
}
