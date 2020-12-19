package ru.nsu.g.beryanov.book_library.gui.configuration.textarea;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.swing.*;

@Configuration
public class TextAreaConfiguration {
    @Bean(name = "quoteArea")
    public JTextArea quoteArea() {
        JTextArea quoteArea = new JTextArea("");
        quoteArea.setBorder(BorderFactory.createTitledBorder("ВВОД ЦИТАТЫ"));
        return quoteArea;
    }
}
