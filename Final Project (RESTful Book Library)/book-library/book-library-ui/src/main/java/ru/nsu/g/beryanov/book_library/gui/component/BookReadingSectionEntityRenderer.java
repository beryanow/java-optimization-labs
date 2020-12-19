package ru.nsu.g.beryanov.book_library.gui.component;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsu.g.beryanov.book_library.dto.AuthorDto;
import ru.nsu.g.beryanov.book_library.dto.BookDto;
import ru.nsu.g.beryanov.book_library.dto.BookReadingDto;
import ru.nsu.g.beryanov.book_library.service.AuthorService;
import ru.nsu.g.beryanov.book_library.service.BookService;

import javax.swing.*;
import java.awt.*;

@Service
public class BookReadingSectionEntityRenderer extends JLabel implements ListCellRenderer<BookReadingDto> {
    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    public BookReadingSectionEntityRenderer() {
        setOpaque(true);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends BookReadingDto> list, BookReadingDto bookReadingDto, int index, boolean isSelected, boolean cellHasFocus) {
        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        BookDto bookDto = bookService.findById(bookReadingDto.getBookId());
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(ArrayUtils.toPrimitive(bookDto.getImage())).getImage().getScaledInstance(40, 60,  java.awt.Image.SCALE_SMOOTH));
        setIcon(imageIcon);

        AuthorDto authorDto = authorService.findById(bookDto.getAuthorId());
        setPreferredSize(new Dimension(330, 70));
        setText(" " + authorDto.getName() + " -> " + bookDto.getName());

        return this;
    }
}
