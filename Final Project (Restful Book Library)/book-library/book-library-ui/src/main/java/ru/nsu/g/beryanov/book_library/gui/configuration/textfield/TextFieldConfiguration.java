package ru.nsu.g.beryanov.book_library.gui.configuration.textfield;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.swing.*;

@Configuration
public class TextFieldConfiguration {
    @Bean(name = "bookTextField")
    public JTextField bookTextField() {
        return new JTextField();
    }

    @Bean(name = "genreTextField")
    public JTextField genreTextField() {
        return new JTextField();
    }

    @Bean(name = "authorTextField")
    public JTextField authorTextField() {
        return new JTextField();
    }

    @Bean(name = "cityTextField")
    public JTextField cityTextField() {
        return new JTextField();
    }

    @Bean(name = "countryTextField")
    public JTextField countryTextField() {
        return new JTextField();
    }
}
