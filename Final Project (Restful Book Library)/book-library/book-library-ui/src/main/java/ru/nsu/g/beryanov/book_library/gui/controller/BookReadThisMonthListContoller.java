package ru.nsu.g.beryanov.book_library.gui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import ru.nsu.g.beryanov.book_library.dto.BookReadDto;
import ru.nsu.g.beryanov.book_library.service.BookReadService;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

@Controller
public class BookReadThisMonthListContoller {
    @Autowired
    @Qualifier(value = "bookReadThisMonthListModel")
    private DefaultListModel<BookReadDto> bookReadThisMonthListModel;

    @Autowired
    @Qualifier(value = "currentMonthReadPanel")
    private JPanel currentMonthReadPanel;

    @Autowired
    @Qualifier(value = "bookReadThisMonthList")
    private JList<BookReadDto> bookReadThisMonthList;

    @Autowired
    @Qualifier(value = "noBookRead")
    private JLabel noBookRead;

    @Autowired
    private BookReadService bookReadService;

    public void updateReadMonthList() {
        bookReadThisMonthListModel.removeAllElements();

        LocalDate today = LocalDate.now();
        bookReadService.findAllInCurrentMonth(today.getYear(), today.getMonthValue()).forEach(bookReadThisMonthListModel::addElement);

        currentMonthReadPanel.removeAll();
        currentMonthReadPanel.repaint();
        currentMonthReadPanel.revalidate();

        if (bookReadThisMonthListModel.size() > 0) {
            bookReadThisMonthList.setModel(bookReadThisMonthListModel);

            JScrollPane scrollPane = new JScrollPane(bookReadThisMonthList);
            scrollPane.setBorder(BorderFactory.createLineBorder(Color.lightGray));

            currentMonthReadPanel.add(scrollPane);
        } else {
            currentMonthReadPanel.add(Box.createRigidArea(new Dimension(0, 80)));
            currentMonthReadPanel.add(noBookRead);
        }
    }
}
