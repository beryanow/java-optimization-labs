package ru.nsu.g.beryanov.book_library.gui.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Controller;
import ru.nsu.g.beryanov.book_library.dto.AddressDto;
import ru.nsu.g.beryanov.book_library.dto.AuthorDto;
import ru.nsu.g.beryanov.book_library.dto.BookDto;
import ru.nsu.g.beryanov.book_library.dto.BookFavouriteDto;
import ru.nsu.g.beryanov.book_library.dto.BookReadDto;
import ru.nsu.g.beryanov.book_library.dto.BookReadingDto;
import ru.nsu.g.beryanov.book_library.dto.BookToReadDto;
import ru.nsu.g.beryanov.book_library.dto.CityDto;
import ru.nsu.g.beryanov.book_library.dto.CountryDto;
import ru.nsu.g.beryanov.book_library.dto.GenreDto;
import ru.nsu.g.beryanov.book_library.dto.QuoteDto;
import ru.nsu.g.beryanov.book_library.service.AddressService;
import ru.nsu.g.beryanov.book_library.service.AuthorService;
import ru.nsu.g.beryanov.book_library.service.BookFavouriteService;
import ru.nsu.g.beryanov.book_library.service.BookReadService;
import ru.nsu.g.beryanov.book_library.service.BookReadingService;
import ru.nsu.g.beryanov.book_library.service.BookService;
import ru.nsu.g.beryanov.book_library.service.BookToReadService;
import ru.nsu.g.beryanov.book_library.service.CityService;
import ru.nsu.g.beryanov.book_library.service.CountryService;
import ru.nsu.g.beryanov.book_library.service.GenreService;
import ru.nsu.g.beryanov.book_library.service.QuoteService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Slf4j
@DependsOn("bookList")
@Controller
public class ListenerController {
    private Byte[] uploadedImage;

    @Autowired
    private CityService cityService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private GenreService genreService;

    @Autowired
    private CountryService countryService;

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
    @Qualifier(value = "addBookButtonOk")
    private JButton addBookButtonOk;

    @Autowired
    @Qualifier(value = "filterButton")
    private JButton filterButton;

    @Autowired
    @Qualifier(value = "addFavouritesButton")
    private JButton addFavouritesButton;

    @Autowired
    @Qualifier(value = "bookListModel")
    private DefaultListModel<BookDto> bookListModel;

    @Autowired
    @Qualifier(value = "quoteArea")
    private JTextArea quoteArea;

    @Autowired
    @Qualifier(value = "authorCheckBoxesPanel")
    private JPanel authorCheckBoxesPanel;

    @Autowired
    @Qualifier(value = "saveQuoteButton")
    private JButton saveQuoteButton;

    @Autowired
    @Qualifier(value = "addAssessmentButton")
    private JButton addAssessmentButton;

    @Autowired
    @Qualifier(value = "selectImageButton")
    private JButton selectImageButton;

    @Autowired
    @Qualifier(value = "assessmentButtons")
    private JPanel assessmentButtons;

    @Autowired
    @Qualifier(value = "addBookButtonCancel")
    private JButton addBookButtonCancel;

    @Autowired
    @Qualifier(value = "buttonsReadPanel")
    private JPanel buttonsReadPanel;

    @Autowired
    @Qualifier(value = "quotePanel")
    private JPanel quotePanel;

    @Autowired
    @Qualifier(value = "selectedBookPanel")
    private JPanel selectedBookPanel;

    @Autowired
    @Qualifier(value = "addQuoteButton")
    private JButton addQuoteButton;

    @Autowired
    @Qualifier(value = "addBookReadingButtonAlready")
    private JButton addBookReadingButtonAlready;

    @Autowired
    @Qualifier(value = "addBookReadButtonAlready")
    private JButton addBookReadButtonAlready;

    @Autowired
    @Qualifier("addBookButton")
    private JButton addBookButton;

    @Autowired
    @Qualifier(value = "assessmentCheckBoxesPanel")
    private JPanel assessmentCheckBoxesPanel;

    @Autowired
    @Qualifier(value = "filterButtonOk")
    private JButton filterButtonOk;

    @Autowired
    @Qualifier("addBookReadButton")
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
    @Qualifier(value = "bookList")
    private JList<BookDto> bookList;

    @Autowired
    @Qualifier(value = "assessmentButtonsGroup")
    private ButtonGroup assessmentButtonsGroup;

    @Autowired
    @Qualifier(value = "addFavouritesButtonAlready")
    private JButton addFavouritesButtonAlready;

    @Autowired
    @Qualifier(value = "genreCheckBoxesPanel")
    private JPanel genreCheckBoxesPanel;

    @Autowired
    private FilterListController filterListController;

    @Autowired
    private AddBookController addBookController;

    @Autowired
    private SelectedBookAreaController selectedBookAreaController;

    @Autowired
    private BookReadService bookReadService;

    @Autowired
    private BookReadListController bookReadListController;

    @Autowired
    private BookToReadService bookToReadService;

    @Autowired
    private BookFavouriteListController bookFavouriteListController;

    @Autowired
    private BookReadThisMonthListContoller bookReadThisMonthListContoller;

    @Autowired
    private GraphicPanelController graphicPanelController;

    @Autowired
    private BookToReadListController bookToReadListController;

    @Autowired
    private BookReadingService bookReadingService;

    @Autowired
    private BookReadingListController bookReadingListController;

    @Autowired
    private QuoteService quoteService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookFavouriteService bookFavouriteService;

    @Autowired
    private BookService bookService;

    @Autowired
    private BookListController bookListController;

    public void addBookButtonListener() {
        addBookButton.addActionListener(actionEvent -> addBookController.createAddBook());
    }

    public void addBookListListener() {
        bookList.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                selectedBookAreaController.updateSelectedBookArea();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
    }

    public void addBookReadButtonListener() {
        addBookReadButton.addActionListener(actionEvent -> {
            BookDto selectedBook = bookList.getSelectedValue();

            BookReadDto bookReadDto = new BookReadDto();
            bookReadDto.setBookId(selectedBook.getId());
            bookReadDto.setQuoteId(1L);
            bookReadDto.setAssessmentId(1L);

            Calendar today = Calendar.getInstance();
            today.set(Calendar.HOUR_OF_DAY, 0);
            today.set(Calendar.MINUTE, 0);
            today.set(Calendar.SECOND, 0);
            bookReadDto.setDateOfCompletion(new Date(today.getTimeInMillis()));

            bookReadService.save(bookReadDto);

            bookReadListController.updateBookReadList();
            bookReadThisMonthListContoller.updateReadMonthList();
            selectedBookAreaController.updateSelectedBookArea();
            graphicPanelController.updateGraphicPanel();
        });
    }

    public void addBookReadButtonAlreadyListener() {
        addBookReadButtonAlready.addActionListener(actionEvent -> {
            BookDto selectedBook = bookList.getSelectedValue();
            List<BookReadDto> booksRead = bookReadService.findAll();

            for (BookReadDto bookReadDto : booksRead) {
                if (selectedBook.getId().equals(bookReadDto.getBookId())) {
                    bookReadService.deleteById(bookReadDto.getId());
                }
            }

            bookReadListController.updateBookReadList();
            bookReadThisMonthListContoller.updateReadMonthList();
            selectedBookAreaController.updateSelectedBookArea();
            graphicPanelController.updateGraphicPanel();
        });
    }

    public void addBookToReadButtonListener() {
        addBookToReadButton.addActionListener(actionEvent -> {
            BookDto selectedBook = bookList.getSelectedValue();

            BookToReadDto bookToReadDto = new BookToReadDto();
            bookToReadDto.setBookId(selectedBook.getId());
            bookToReadDto.setDateOfAddition(new Date(Calendar.getInstance().getTime().getTime()));
            bookToReadService.save(bookToReadDto);

            bookToReadListController.updateBookToReadList();
            selectedBookAreaController.updateSelectedBookArea();
        });
    }

    public void addBookReadingButtonListener() {
        addBookReadingButton.addActionListener(actionEvent -> {
            BookDto selectedBook = bookList.getSelectedValue();

            BookReadingDto bookReadingDto = new BookReadingDto();
            bookReadingDto.setBookId(selectedBook.getId());

            Calendar today = Calendar.getInstance();
            today.set(Calendar.HOUR_OF_DAY, 0);
            today.set(Calendar.MINUTE, 0);
            today.set(Calendar.SECOND, 0);

            bookReadingDto.setStartDate(new Date(today.getTimeInMillis()));
            bookReadingService.save(bookReadingDto);

            bookReadingListController.updateBookReadingList();
            selectedBookAreaController.updateSelectedBookArea();
        });
    }

    public void addBookToReadButtonAlreadyListener() {
        addBookToReadButtonAlready.addActionListener(actionEvent -> {
            BookDto selectedBook = bookList.getSelectedValue();
            List<BookToReadDto> bookToReadDtoList = bookToReadService.findAll();

            for (BookToReadDto bookToReadDto : bookToReadDtoList) {
                if (selectedBook.getId().equals(bookToReadDto.getBookId())) {
                    bookToReadService.deleteById(bookToReadDto.getId());
                }
            }

            bookToReadListController.updateBookToReadList();
            selectedBookAreaController.updateSelectedBookArea();
        });
    }

    public void addBookReadingButtonAlreadyListener() {
        addBookReadingButtonAlready.addActionListener(actionEvent -> {
            BookDto selectedBook = bookList.getSelectedValue();
            List<BookReadingDto> bookReadingDtoList = bookReadingService.findAll();

            for (BookReadingDto bookReadingDto : bookReadingDtoList) {
                if (selectedBook.getId().equals(bookReadingDto.getBookId())) {
                    bookReadingService.deleteById(bookReadingDto.getId());
                }
            }

            bookReadingListController.updateBookReadingList();
            selectedBookAreaController.updateSelectedBookArea();
        });
    }

    public void addQuoteButtonListener() {
        addQuoteButton.addActionListener(actionEvent -> {
            selectedBookPanel.remove(quotePanel);
            selectedBookPanel.remove(assessmentButtons);
            buttonsReadPanel.remove(addAssessmentButton);
            buttonsReadPanel.remove(addQuoteButton);
            buttonsReadPanel.add(saveQuoteButton);
            buttonsReadPanel.repaint();

            selectedBookPanel.add(quoteArea);
            selectedBookPanel.repaint();
            selectedBookPanel.revalidate();
        });
    }

    public void addSaveQuoteButtonListener() {
        saveQuoteButton.addActionListener(actionEvent -> {
            BookDto selectedBook = bookList.getSelectedValue();

            BookReadDto bookReadDto = bookReadService.findByBookId(selectedBook.getId());

            Long oldQuoteIndex = bookReadDto.getQuoteId();

            String quote = quoteArea.getText();

            quoteArea.setText("");

            QuoteDto quoteDto = QuoteDto.builder().content(quote).build();
            quoteDto = quoteService.save(quoteDto);

            bookReadDto.setQuoteId(quoteDto.getId());
            bookReadService.save(bookReadDto);

            if (oldQuoteIndex != 1) {
                quoteService.deleteById(oldQuoteIndex);
            }

            selectedBookAreaController.updateSelectedBookArea();
        });
    }

    public void addAssessmentButtonListener() {
        addAssessmentButton.addActionListener(actionEvent -> {
            BookDto selectedBook = bookList.getSelectedValue();

            Long assessment = 0L;
            List<AbstractButton> list = Collections.list(assessmentButtonsGroup.getElements());
            for (AbstractButton button : list) {
                if (button.isSelected()) {
                    assessment = Long.parseLong(button.getText());
                }
            }

            BookReadDto bookReadDto = bookReadService.findByBookId(selectedBook.getId());
            bookReadDto.setAssessmentId(assessment + 1);
            bookReadService.save(bookReadDto);

            bookToReadListController.updateBookToReadList();
            selectedBookAreaController.updateSelectedBookArea();
        });
    }

    public void addFavouritesButtonListener() {
        addFavouritesButton.addActionListener(actionEvent -> {
            BookFavouriteDto bookFavouriteDto = BookFavouriteDto.builder().bookId(bookList.getSelectedValue().getId()).build();

            bookFavouriteService.save(bookFavouriteDto);
            bookFavouriteListController.updateFavouritesList();
            selectedBookAreaController.updateSelectedBookArea();
        });
    }

    public void addFavouritesButtonAlreadyListener() {
        addFavouritesButtonAlready.addActionListener(actionEvent -> {
            BookFavouriteDto bookFavouriteDto = bookFavouriteService.findByBookId(bookList.getSelectedValue().getId());

            bookFavouriteService.deleteById(bookFavouriteDto.getId());

            bookFavouriteListController.updateFavouritesList();
            selectedBookAreaController.updateSelectedBookArea();
        });
    }

    public void addFilterButtonListener() {
        filterButton.addActionListener(actionEvent -> filterListController.createFilterList());
    }

    public void addFilterButtonOkListener() {
        filterButtonOk.addActionListener(actionEvent -> {
            bookListModel.removeAllElements();

            ArrayList<BookDto> authorBookListModel = new ArrayList<>();
            ArrayList<BookDto> genreBookListModel = new ArrayList<>();
            ArrayList<BookDto> assessmentBookListModel = new ArrayList<>();

            int any1 = 0;
            for (Component checkBox : authorCheckBoxesPanel.getComponents()) {
                if (((JCheckBox) checkBox).isSelected()) {
                    Long authorId = authorService.findByName(((JCheckBox) checkBox).getText()).getId();
                    authorBookListModel.addAll(bookService.findAllByAuthorId(authorId));
                    any1 = 1;
                }
            }

            int any2 = 0;
            for (Component checkBox : genreCheckBoxesPanel.getComponents()) {
                if (((JCheckBox) checkBox).isSelected()) {
                    Long genreId = genreService.findByName(((JCheckBox) checkBox).getText()).getId();
                    genreBookListModel.addAll(bookService.findAllByGenreId(genreId));
                    any2 = 1;
                }
            }

            int any3 = 0;
            for (Component checkBox : assessmentCheckBoxesPanel.getComponents()) {
                if (((JCheckBox) checkBox).isSelected()) {
                    Long assessmentId = Long.parseLong(((JCheckBox) checkBox).getText()) + 1;
                    bookReadService.findAllByAssessmentId(assessmentId).forEach(bookReadDto -> assessmentBookListModel.add(bookService.findById(bookReadDto.getBookId())));
                    any3 = 1;
                }
            }

            ArrayList<BookDto> intersectModelsAG = new ArrayList<>();
            ArrayList<BookDto> intersectModelsAA = new ArrayList<>();
            ArrayList<BookDto> intersectModelsGA = new ArrayList<>();
            ArrayList<BookDto> intersectModelsAGA = new ArrayList<>();

            ArrayList<BookDto> finalModel;

            for (BookDto book : authorBookListModel) {
                if (genreBookListModel.contains(book)) {
                    intersectModelsAG.add(book);
                }
            }

            for (BookDto book : intersectModelsAG) {
                if (assessmentBookListModel.contains(book)) {
                    intersectModelsAGA.add(book);
                }
            }

            for (BookDto book : authorBookListModel) {
                if (assessmentBookListModel.contains(book)) {
                    intersectModelsAA.add(book);
                }
            }

            for (BookDto book : genreBookListModel) {
                if (assessmentBookListModel.contains(book)) {
                    intersectModelsGA.add(book);
                }
            }

            if (any1 == 0) {
                if (any2 == 0) {
                    finalModel = assessmentBookListModel;
                } else {
                    if (any3 == 0) {
                        finalModel = genreBookListModel;
                    } else {
                        finalModel = intersectModelsGA;
                    }
                }
            } else {
                if (any2 == 0) {
                    if (any3 == 0) {
                        finalModel = authorBookListModel;
                    } else {
                        finalModel = intersectModelsAA;
                    }
                } else {
                    if (any3 == 0) {
                        finalModel = intersectModelsAG;
                    } else {
                        finalModel = intersectModelsAGA;
                    }
                }
            }

            finalModel.sort(Comparator.comparing(BookDto::getId));

            finalModel.forEach(bookListModel::addElement);

            bookList.setModel(bookListModel);

            bookListController.drawBookList();
        });
    }

    public void addBookButtonCancelListener() {
        addBookButtonCancel.addActionListener(actionEvent -> bookListController.updateBookList());
    }

    public void addSelectImageButtonListener() {
        selectImageButton.addActionListener(actionEvent -> {
            JFileChooser jFileChooser = new JFileChooser();
            int ret = jFileChooser.showDialog(null, "Открыть файл");
            if (ret == JFileChooser.APPROVE_OPTION) {
                File source = jFileChooser.getSelectedFile();
                try {
                    uploadedImage = ArrayUtils.toObject(FileUtils.readFileToByteArray(source));
                } catch (IOException ioException) {
                    log.error(String.valueOf(ioException));
                }
            }
        });
    }

    public void addBookButtonOkListener() {
        addBookButtonOk.addActionListener(actionEvent -> {
            String bookName = bookTextField.getText();
            String genreName = genreTextField.getText();
            String authorName = authorTextField.getText();
            String cityName = cityTextField.getText();
            String countryName = countryTextField.getText();

            CityDto cityDto = CityDto.builder().name(cityName).build();
            Long cityId = cityService.save(cityDto).getId();

            CountryDto countryDto = CountryDto.builder().name(countryName).build();
            Long countryId = countryService.save(countryDto).getId();

            GenreDto genreDto = GenreDto.builder().name(genreName).build();
            Long genreId = genreService.save(genreDto).getId();

            AddressDto addressDto = AddressDto.builder().cityId(cityId).countryId(countryId).build();
            Long addressId = addressService.save(addressDto).getId();

            AuthorDto authorDto = AuthorDto.builder().name(authorName).addressId(addressId).build();
            Long authorId = authorService.save(authorDto).getId();

            BookDto bookDto = BookDto.builder().name(bookName).genreId(genreId).authorId(authorId).image(uploadedImage).build();
            bookService.save(bookDto);

            bookListController.updateBookList();
        });
    }
}
