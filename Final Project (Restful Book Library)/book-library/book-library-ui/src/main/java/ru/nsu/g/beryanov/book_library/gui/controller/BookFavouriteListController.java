package ru.nsu.g.beryanov.book_library.gui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import ru.nsu.g.beryanov.book_library.dto.BookFavouriteDto;
import ru.nsu.g.beryanov.book_library.service.BookFavouriteService;

import javax.swing.*;
import java.awt.*;

@Controller
public class BookFavouriteListController {
    @Autowired
    @Qualifier(value = "favouritesListModel")
    private DefaultListModel<BookFavouriteDto> favouritesListModel;

    @Autowired
    @Qualifier(value = "favouritesPanel")
    private JPanel favouritesPanel;

    @Autowired
    @Qualifier(value = "favouritesList")
    private JList<BookFavouriteDto> favouritesList;

    @Autowired
    @Qualifier(value = "noBookRead")
    private JLabel noBookRead;

    @Autowired
    private BookFavouriteService bookFavouriteService;

    public void updateFavouritesList() {
        favouritesListModel.removeAllElements();

        bookFavouriteService.findAll().forEach(favouritesListModel::addElement);

        favouritesPanel.removeAll();
        favouritesPanel.repaint();
        favouritesPanel.revalidate();

        if (favouritesListModel.size() > 0) {
            favouritesList.setModel(favouritesListModel);

            JScrollPane scrollPane = new JScrollPane(favouritesList);
            scrollPane.setBorder(BorderFactory.createLineBorder(Color.lightGray));

            favouritesPanel.add(scrollPane);
        } else {
            favouritesPanel.add(Box.createRigidArea(new Dimension(0, 80)));
            favouritesPanel.add(noBookRead);
        }
    }
}
