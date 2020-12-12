package ru.nsu.g.beryanov.book_library.gui.configuration.button;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.nsu.g.beryanov.book_library.dto.BookDto;
import ru.nsu.g.beryanov.book_library.gui.controller.BookFavouriteListController;
import ru.nsu.g.beryanov.book_library.gui.controller.BookListController;
import ru.nsu.g.beryanov.book_library.gui.controller.BookReadListController;
import ru.nsu.g.beryanov.book_library.gui.controller.BookReadThisMonthListContoller;
import ru.nsu.g.beryanov.book_library.gui.controller.BookReadingListController;
import ru.nsu.g.beryanov.book_library.gui.controller.BookToReadListController;
import ru.nsu.g.beryanov.book_library.gui.controller.GraphicPanelController;
import ru.nsu.g.beryanov.book_library.gui.controller.ListenerController;

import javax.annotation.PostConstruct;
import javax.swing.*;

@Slf4j
@Configuration
public class ButtonConfiguration {
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
    @Qualifier(value = "bookListModel")
    private DefaultListModel<BookDto> bookListModel;

    @Autowired
    @Qualifier(value = "authorCheckBoxesPanel")
    private JPanel authorCheckBoxesPanel;

    @Autowired
    @Qualifier(value = "genreCheckBoxesPanel")
    private JPanel genreCheckBoxesPanel;

    @Autowired
    @Qualifier(value = "assessmentCheckBoxesPanel")
    private JPanel assessmentCheckBoxesPanel;

//    @Autowired
//    @Qualifier(value = "bookList")
//    private JList<BookDto> bookList;

    @Autowired
    @Qualifier(value = "saveQuoteButton")
    private JButton saveQuoteButton;

    @Autowired
    @Qualifier(value = "assessmentButtonsGroup")
    private ButtonGroup assessmentButtonsGroup;

    @Autowired
    @Qualifier(value = "selectedBookPanel")
    private JPanel selectedBookPanel;

    @Autowired
    @Qualifier(value = "quotePanel")
    private JPanel quotePanel;

    @Autowired
    @Qualifier(value = "buttonsReadPanel")
    private JPanel buttonsReadPanel;

    @Autowired
    @Qualifier(value = "assessmentButtons")
    private JPanel assessmentButtons;

    @Autowired
    @Qualifier(value = "addAssessmentButton")
    private JButton addAssessmentButton;

    @Autowired
    @Qualifier(value = "quoteArea")
    private JTextArea quoteArea;

    @Bean(name = "addBookButton")
    public JButton addBookButton() {
        return new JButton("Добавить новую книгу");
    }

    @Bean(name = "filterButton")
    public JButton filterButton() {
        return new JButton("Фильтровать список");
    }

    @Bean(name = "addBookReadButton")
    public JButton addBookReadButton() {
        return new JButton("+ Прочитал");
    }

    @Bean(name = "addBookReadButtonAlready")
    public JButton addBookReadButtonAlready() {
        return new JButton("- Прочитал");
    }

    @Bean(name = "addBookToReadButton")
    public JButton addBookToReadButton() {
        return new JButton(" + Хочу прочитать");
    }

    @Bean(name = "addBookToReadButtonAlready")
    public JButton addBookToReadButtonAlready() {
        return new JButton(" - Хочу прочитать");
    }

    @Bean(name = "addBookReadingButton")
    public JButton addBookReadingButton() {
        return new JButton(" + Читаю");
    }

    @Bean(name = "addBookReadingButtonAlready")
    public JButton addBookReadingButtonAlready() {
        return new JButton("- Читаю");
    }

    @Bean(name = "selectImageButton")
    public JButton selectImageButton() {
        return new JButton("Указать путь до изображения на диске");
    }

    @Bean(name = "filterButtonOk")
    public JButton filterButtonOk() {
        return new JButton("Подтвердить параметры фильтрации");
    }

    @Bean(name = "addBookButtonCancel")
    public JButton addBookButtonCancel() {
        return new JButton("Отменить добавление новой книги");
    }

    @Bean(name = "addBookButtonOk")
    public JButton addBookButtonOk() {
        return new JButton("Сохранить данные новой книги в список");
    }

    @Bean(name = "addQuoteButton")
    public JButton addQuoteButton() {
        return new JButton("Изменить цитату");
    }

    @Bean(name = "saveQuoteButton")
    public JButton saveQuoteButton() {
        return new JButton("Сохранить введённую цитату");
    }

    @Bean(name = "addAssessmentButton")
    public JButton addAssessmentButton() {
        return new JButton("Оценить");
    }

    @Bean(name = "addFavouritesButton")
    public JButton addFavouritesButton() {
        return new JButton("+ Избранное");
    }

    @Bean(name = "addFavouritesButtonAlready")
    public JButton addFavouritesButtonAlready() {
        return new JButton("- Избранное");
    }

    @Bean(name = "assessmentButtonsGroup")
    public ButtonGroup assessmentButtonsGroup() {
        return new ButtonGroup();
    }

    @Autowired
    private BookListController bookListController;

    @Autowired
    private ListenerController listenerController;

    @Autowired
    private BookReadThisMonthListContoller bookReadThisMonthListContoller;

    @Autowired
    private BookToReadListController bookToReadListController;

    @Autowired
    private BookReadingListController bookReadingListController;

    @Autowired
    private BookReadListController bookReadListController;

    @Autowired
    private BookFavouriteListController bookFavouriteListController;

    @Autowired
    private GraphicPanelController graphicPanelController;

    @SneakyThrows
    @PostConstruct
    private void postConstruct() {
        bookListController.updateBookList();

        listenerController.addBookReadButtonListener();
        listenerController.addBookReadButtonAlreadyListener();
        listenerController.addBookToReadButtonListener();
        listenerController.addBookReadingButtonListener();
        listenerController.addBookToReadButtonAlreadyListener();
        listenerController.addBookReadingButtonAlreadyListener();
        listenerController.addQuoteButtonListener();
        listenerController.addSaveQuoteButtonListener();
        listenerController.addAssessmentButtonListener();
        listenerController.addFavouritesButtonListener();
        listenerController.addFavouritesButtonAlreadyListener();
        listenerController.addFilterButtonListener();
        listenerController.addFilterButtonOkListener();
        listenerController.addBookButtonListener();
        listenerController.addBookButtonCancelListener();
        listenerController.addSelectImageButtonListener();
        listenerController.addBookButtonOkListener();

        bookReadThisMonthListContoller.updateReadMonthList();
        bookToReadListController.updateBookToReadList();
        bookReadingListController.updateBookReadingList();
        bookReadListController.updateBookReadList();
        bookFavouriteListController.updateFavouritesList();
        graphicPanelController.updateGraphicPanel();
    }
}
