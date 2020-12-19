package ru.nsu.g.beryanov.book_library;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@Slf4j
@SpringBootApplication
public class BookLibraryUIApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(BookLibraryUIApplication.class)
                .headless(false)
                .web(WebApplicationType.NONE)
                .run(args);
    }
}
