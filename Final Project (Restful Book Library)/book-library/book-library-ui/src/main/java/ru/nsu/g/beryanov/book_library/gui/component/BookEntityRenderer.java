package ru.nsu.g.beryanov.book_library.gui.component;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.stereotype.Service;
import ru.nsu.g.beryanov.book_library.dto.BookDto;

import javax.swing.*;
import java.awt.*;

@Slf4j
@Service
public class BookEntityRenderer extends JLabel implements ListCellRenderer<BookDto> {
    public BookEntityRenderer() {
        setOpaque(true);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends BookDto> list, BookDto bookDto, int index, boolean isSelected, boolean cellHasFocus) {
        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        try {
            ImageIcon imageIcon = new ImageIcon(new ImageIcon(ArrayUtils.toPrimitive(bookDto.getImage())).getImage().getScaledInstance(40, 60,  java.awt.Image.SCALE_SMOOTH));
            setIcon(imageIcon);
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        setPreferredSize(new Dimension(270, 70));
        try {
            setText(" " + bookDto.getAuthorByAuthorId().getName() + " -> " + bookDto.getName());
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return this;
    }
}
