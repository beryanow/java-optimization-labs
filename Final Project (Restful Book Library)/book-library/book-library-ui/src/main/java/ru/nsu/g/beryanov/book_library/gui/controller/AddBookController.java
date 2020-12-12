package ru.nsu.g.beryanov.book_library.gui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.swing.*;
import java.awt.*;

@Controller
public class AddBookController {
    @Autowired
    @Qualifier(value = "addBookPanel")
    private JPanel addBookPanel;

    @Autowired
    @Qualifier(value = "bookTextField")
    private JTextField bookTextField;

    @Autowired
    @Qualifier(value = "genreTextField")
    private JTextField genreTextField;

    @Autowired
    @Qualifier(value = "authorTextField")
    private JTextField authorTextField;

    @Autowired
    @Qualifier(value = "cityTextField")
    private JTextField cityTextField;

    @Autowired
    @Qualifier(value = "countryTextField")
    private JTextField countryTextField;

    @Autowired
    @Qualifier(value = "selectImageButton")
    private JButton selectImageButton;

    @Autowired
    @Qualifier(value = "addBookButtonOk")
    private JButton addBookButtonOk;

    @Autowired
    @Qualifier(value = "addBookButtonCancel")
    private JButton addBookButtonCancel;

    @Autowired
    @Qualifier(value = "bookPanel")
    private JPanel bookPanel;

    public void createAddBook() {
        addBookPanel.removeAll();
        addBookPanel.repaint();
        addBookPanel.revalidate();

        Font font = new Font(new JLabel("").getFont().getName(), Font.PLAIN, 16);

        JLabel bookName = new JLabel("Книга:");
        JLabel genreName = new JLabel("Жанр:");
        JLabel authorName = new JLabel("Автор:");
        JLabel cityName = new JLabel("Город:");
        JLabel countryName = new JLabel("Страна:");
        JLabel imageName = new JLabel("Полноразмерная обложка:");

        bookName.setFont(font.deriveFont(font.getStyle() | Font.BOLD));
        genreName.setFont(font.deriveFont(font.getStyle() | Font.BOLD));
        authorName.setFont(font.deriveFont(font.getStyle() | Font.BOLD));
        cityName.setFont(font.deriveFont(font.getStyle() | Font.BOLD));
        countryName.setFont(font.deriveFont(font.getStyle() | Font.BOLD));
        imageName.setFont(font.deriveFont(font.getStyle() | Font.BOLD));

        addBookPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        addBookPanel.add(bookName);
        addBookPanel.add(bookTextField);
        addBookPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        addBookPanel.add(genreName);
        addBookPanel.add(genreTextField);
        addBookPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        addBookPanel.add(authorName);
        addBookPanel.add(authorTextField);
        addBookPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        addBookPanel.add(cityName);
        addBookPanel.add(cityTextField);
        addBookPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        addBookPanel.add(countryName);
        addBookPanel.add(countryTextField);
        addBookPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        addBookPanel.add(imageName);
        addBookPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        addBookPanel.add(selectImageButton);

        addBookPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        addBookPanel.add(addBookButtonOk);
        addBookPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        addBookPanel.add(addBookButtonCancel);
        addBookPanel.add(Box.createRigidArea(new Dimension(0, 280)));

        bookPanel.removeAll();
        bookPanel.repaint();
        bookPanel.revalidate();

        bookPanel.add(addBookPanel);
    }
}
