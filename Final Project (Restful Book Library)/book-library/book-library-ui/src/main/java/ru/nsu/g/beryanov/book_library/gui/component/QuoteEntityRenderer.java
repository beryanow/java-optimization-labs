package ru.nsu.g.beryanov.book_library.gui.component;

import ru.nsu.g.beryanov.book_library.dto.QuoteDto;

import javax.swing.*;
import java.awt.*;

public class QuoteEntityRenderer extends JTextArea implements ListCellRenderer<QuoteDto> {
    public QuoteEntityRenderer() {
        setOpaque(true);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends QuoteDto> list, QuoteDto quoteDto, int index, boolean isSelected, boolean cellHasFocus) {
        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        setPreferredSize(new Dimension(330, 70));
        setText(" " + quoteDto.getContent());
        return this;
    }
}
