package ru.nsu.g.beryanov.book_library.gui.configuration.label;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.swing.*;
import java.awt.*;

@Configuration
public class LabelConfiguration {
    @Bean(name = "noBookReading")
    public JLabel noBookReading() {
        JLabel noBookReading = new JLabel("Нет книг");
        noBookReading.setAlignmentX(Component.CENTER_ALIGNMENT);
        return noBookReading;
    }

    @Bean(name = "noBookToRead")
    public JLabel noBookToRead() {
        JLabel noBookToRead = new JLabel("Нет книг");
        noBookToRead.setAlignmentX(Component.CENTER_ALIGNMENT);
        return noBookToRead;
    }

    @Bean(name = "noBookRead")
    public JLabel noBookRead() {
        JLabel noBookRead = new JLabel("Нет книг");
        noBookRead.setAlignmentX(Component.CENTER_ALIGNMENT);
        return noBookRead;
    }

    @Bean(name = "noBookSelected")
    public JLabel noBookSelected() {
        JLabel noBookSelected = new JLabel("Книга не выбрана");
        noBookSelected.setAlignmentX(Component.CENTER_ALIGNMENT);
        return noBookSelected;
    }

    @Bean(name = "noQuote")
    public JLabel noQuote() {
        JLabel noQuote = new JLabel("Нет цитаты");
        noQuote.setAlignmentX(Component.CENTER_ALIGNMENT);;
        return noQuote;
    }
}
