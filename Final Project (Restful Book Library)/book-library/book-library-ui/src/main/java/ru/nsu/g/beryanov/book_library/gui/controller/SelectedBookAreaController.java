package ru.nsu.g.beryanov.book_library.gui.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import ru.nsu.g.beryanov.book_library.dto.BookDto;
import ru.nsu.g.beryanov.book_library.dto.BookFavouriteDto;
import ru.nsu.g.beryanov.book_library.dto.BookReadDto;
import ru.nsu.g.beryanov.book_library.dto.BookReadingDto;
import ru.nsu.g.beryanov.book_library.dto.BookToReadDto;
import ru.nsu.g.beryanov.book_library.service.BookFavouriteService;
import ru.nsu.g.beryanov.book_library.service.BookReadService;
import ru.nsu.g.beryanov.book_library.service.BookReadingService;
import ru.nsu.g.beryanov.book_library.service.BookToReadService;

import javax.swing.*;
import java.awt.*;
import java.util.Collections;
import java.util.List;

@Slf4j
@Controller
public class SelectedBookAreaController {
    @Autowired
    @Qualifier(value = "selectedBookPanel")
    private JPanel selectedBookPanel;

    @Autowired
    @Qualifier(value = "bookList")
    private JList<BookDto> bookList;

    @Autowired
    @Qualifier(value = "addBookReadButton")
    private JButton addBookReadButton;

    @Autowired
    @Qualifier(value = "addBookToReadButton")
    private JButton addBookToReadButton;

    @Autowired
    @Qualifier(value = "addBookReadingButton")
    private JButton addBookReadingButton;

    @Autowired
    @Qualifier(value = "addBookToReadButtonAlready")
    private JButton addBookToReadButtonAlready;

    @Autowired
    @Qualifier(value = "addBookReadButtonAlready")
    private JButton addBookReadButtonAlready;

    @Autowired
    @Qualifier(value = "buttonsReadPanel")
    private JPanel buttonsReadPanel;

    @Autowired
    @Qualifier(value = "addQuoteButton")
    private JButton addQuoteButton;

    @Autowired
    @Qualifier(value = "addAssessmentButton")
    private JButton addAssessmentButton;

    @Autowired
    @Qualifier(value = "addFavouritesButtonAlready")
    private JButton addFavouritesButtonAlready;

    @Autowired
    @Qualifier(value = "addFavouritesButton")
    private JButton addFavouritesButton;

    @Autowired
    @Qualifier(value = "assessmentButtonsGroup")
    private ButtonGroup assessmentButtonsGroup;

    @Autowired
    @Qualifier(value = "addBookReadingButtonAlready")
    private JButton addBookReadingButtonAlready;

    @Autowired
    @Qualifier(value = "assessmentButtons")
    private JPanel assessmentButtons;

    @Autowired
    @Qualifier(value = "quotePanel")
    private JPanel quotePanel;

    @Autowired
    private QuoteListController quoteListController;

    @Autowired
    private BookToReadService bookToReadService;

    @Autowired
    private BookReadService bookReadService;

    @Autowired
    private BookFavouriteService bookFavouriteService;

    @Autowired
    private BookReadingService bookReadingService;

    public void updateSelectedBookArea() {
        selectedBookPanel.removeAll();
        selectedBookPanel.repaint();
        selectedBookPanel.revalidate();

        try {
            JLabel image = new JLabel(new ImageIcon(new ImageIcon(ArrayUtils.toPrimitive(bookList.getSelectedValue().getImage())).getImage().getScaledInstance(200, 300,  java.awt.Image.SCALE_SMOOTH)));
            image.setAlignmentX(Component.CENTER_ALIGNMENT);
            selectedBookPanel.add(Box.createRigidArea(new Dimension(0, 20)));
            selectedBookPanel.add(image);
            selectedBookPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        } catch (Exception e) {
            log.error(String.valueOf(e));
        }

        JLabel bookName = new JLabel(bookList.getSelectedValue().getName());
        bookName.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel authorName = null;
        try {
            authorName = new JLabel(bookList.getSelectedValue().getAuthorByAuthorId().getName());
        } catch (Exception e) {
            log.error(String.valueOf(e));
        }

        authorName.setAlignmentX(Component.CENTER_ALIGNMENT);

        Font font = new Font(new JLabel("").getFont().getName(), Font.PLAIN, 19);
        authorName.setFont(font.deriveFont(font.getStyle() | Font.BOLD));

        selectedBookPanel.add(authorName);
        selectedBookPanel.add(Box.createRigidArea(new Dimension(0, 7)));
        selectedBookPanel.add(bookName);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBackground(Color.white);
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));

        BookDto selectedBook = bookList.getSelectedValue();

        addBookReadButton.setEnabled(true);
        addBookToReadButton.setEnabled(true);
        addBookReadingButton.setEnabled(true);

        BookToReadDto bookToRead = bookToReadService.findByBookId(selectedBook.getId());

        if (bookToRead != null) {
            buttonsPanel.add(addBookToReadButtonAlready);
            addBookReadingButton.setEnabled(false);
            addBookReadButton.setEnabled(false);
        } else {
            buttonsPanel.add(addBookToReadButton);
        }

        BookReadDto bookReadDto = bookReadService.findByBookId(selectedBook.getId());
        BookFavouriteDto bookFavouriteDto = bookFavouriteService.findByBookId(selectedBook.getId());

        if (bookReadDto != null) {
            buttonsPanel.add(addBookReadButtonAlready);
            addBookReadingButton.setEnabled(false);
            addBookToReadButton.setEnabled(false);

            buttonsReadPanel.removeAll();
            buttonsReadPanel.add(addQuoteButton);
            buttonsReadPanel.add(addAssessmentButton);

            if (bookFavouriteDto != null) {
                buttonsReadPanel.add(addFavouritesButtonAlready);
            } else {
                buttonsReadPanel.add(addFavouritesButton);
            }

            List<AbstractButton> list = Collections.list(assessmentButtonsGroup.getElements());
            for (AbstractButton button : list) {
                if (button.isSelected()) {
                    button.setSelected(false);
                }
                if (button.getText().equals(String.valueOf(bookReadDto.getAssessmentByAssessmentId().getGrade()))) {
                    button.setSelected(true);
                }
            }
        } else {
            buttonsPanel.add(addBookReadButton);
        }

        BookReadingDto bookReadingDto = bookReadingService.findByBookId(selectedBook.getId());

        if (bookReadingDto != null) {
            buttonsPanel.add(addBookReadingButtonAlready);
            addBookReadButton.setEnabled(false);
            addBookToReadButton.setEnabled(false);
        } else {
            buttonsPanel.add(addBookReadingButton);
        }

        selectedBookPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        selectedBookPanel.add(buttonsPanel);

        if (!addBookToReadButton.isEnabled() && !addBookReadingButton.isEnabled()) {
            selectedBookPanel.add(Box.createRigidArea(new Dimension(0, 7)));
            selectedBookPanel.add(buttonsReadPanel);

            selectedBookPanel.add(Box.createRigidArea(new Dimension(0, 10)));
            selectedBookPanel.add(assessmentButtons);
            selectedBookPanel.add(Box.createRigidArea(new Dimension(0, 10)));

            selectedBookPanel.add(quotePanel);
            quoteListController.updateQuoteList();
        }
    }

}
