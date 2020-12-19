package ru.nsu.g.beryanov.book_library.gui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import ru.nsu.g.beryanov.book_library.dto.BookDto;
import ru.nsu.g.beryanov.book_library.service.AuthorService;
import ru.nsu.g.beryanov.book_library.service.GenreService;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

@Controller
public class FilterListController {
    @Autowired
    @Qualifier(value = "bookPanel")
    private JPanel bookPanel;

    @Autowired
    @Qualifier(value = "filterButtonOk")
    private JButton filterButtonOk;

    @Autowired
    @Qualifier(value = "authorCheckBoxesPanel")
    private JPanel authorCheckBoxesPanel;

    @Autowired
    @Qualifier(value = "genreCheckBoxesPanel")
    private JPanel genreCheckBoxesPanel;

    @Autowired
    @Qualifier(value = "assessmentCheckBoxesPanel")
    private JPanel assessmentCheckBoxesPanel;

    @Autowired
    @Qualifier(value = "bookList")
    private JList<BookDto> bookList;

    @Autowired
    @Qualifier(value = "bookListModel")
    private DefaultListModel<BookDto> bookListModel;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private GenreService genreService;

    public void createFilterList() {
        ArrayList<String> authors = new ArrayList<>();
        ArrayList<String> genres = new ArrayList<>();

        String[] assessments = {"0", "1", "2", "3", "4", "5"};
        authorService.findAll().forEach(author -> authors.add(author.getName()));
        genreService.findAll().forEach(genre -> genres.add(genre.getName()));

        JLabel authorsLabel = new JLabel(" Авторы:");
        Font font = new Font(new JLabel("").getFont().getName(), Font.PLAIN, 16);
        authorsLabel.setFont(font.deriveFont(font.getStyle() | Font.BOLD));

        JPanel boxesPanel = new JPanel();
        boxesPanel.setBackground(Color.white);
        boxesPanel.setLayout(new BoxLayout(boxesPanel, BoxLayout.Y_AXIS));

        boxesPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        boxesPanel.add(authorsLabel);
        boxesPanel.add(Box.createRigidArea(new Dimension(0, 5)));

        authorCheckBoxesPanel.removeAll();
        authorCheckBoxesPanel.repaint();
        authorCheckBoxesPanel.revalidate();

        for (String author : authors) {
            JCheckBox checkBox = new JCheckBox(author);
            authorCheckBoxesPanel.add(checkBox);
        }

        boxesPanel.add(authorCheckBoxesPanel);

        JLabel genresLabel = new JLabel(" Жанры:");
        genresLabel.setFont(font.deriveFont(font.getStyle() | Font.BOLD));

        boxesPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        boxesPanel.add(genresLabel);
        boxesPanel.add(Box.createRigidArea(new Dimension(0, 5)));

        genreCheckBoxesPanel.removeAll();
        genreCheckBoxesPanel.repaint();
        genreCheckBoxesPanel.revalidate();

        for (String genre : genres) {
            JCheckBox checkBox = new JCheckBox(genre);
            genreCheckBoxesPanel.add(checkBox);
        }

        boxesPanel.add(genreCheckBoxesPanel);

        JLabel assessmentLabel = new JLabel(" Оценки:");
        assessmentLabel.setFont(font.deriveFont(font.getStyle() | Font.BOLD));

        boxesPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        boxesPanel.add(assessmentLabel);
        boxesPanel.add(Box.createRigidArea(new Dimension(0, 5)));

        assessmentCheckBoxesPanel.removeAll();
        assessmentCheckBoxesPanel.repaint();
        assessmentCheckBoxesPanel.revalidate();

        for (String assessment : assessments) {
            JCheckBox checkBox = new JCheckBox(assessment);
            assessmentCheckBoxesPanel.add(checkBox);
        }

        boxesPanel.add(assessmentCheckBoxesPanel);

        bookPanel.removeAll();
        bookPanel.repaint();
        bookPanel.revalidate();

        bookPanel.add(boxesPanel);
        bookPanel.add(Box.createRigidArea(new Dimension(0, 5)));

        bookPanel.add(filterButtonOk);
    }
}
