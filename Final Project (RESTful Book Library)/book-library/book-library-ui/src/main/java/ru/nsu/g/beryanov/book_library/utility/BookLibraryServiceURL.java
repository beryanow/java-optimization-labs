package ru.nsu.g.beryanov.book_library.utility;

import lombok.experimental.UtilityClass;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BookLibraryServiceURL {
    @Value("${address.find_all.url}")
    public String ADDRESS_FIND_ALL;

    @Value("${address.save.url}")
    public String ADDRESS_SAVE;


    @Value("${author.find_all.url}")
    public String AUTHOR_FIND_ALL;

    @Value("${author.find_by_id.url}")
    public String AUTHOR_FIND_BY_ID;

    @Value("${author.find_by_name.url}")
    public String AUTHOR_FIND_BY_NAME;

    @Value("${author.save.url}")
    public String AUTHOR_SAVE;


    @Value("${book.find_all.url}")
    public String BOOK_FIND_ALL;

    @Value("${book.find_by_id.url}")
    public String BOOK_FIND_BY_ID;

    @Value("${book.find_all_by_author_id.url}")
    public String BOOK_FIND_ALL_BY_AUTHOR_ID;

    @Value("${book.find_all_by_genre_id.url}")
    public String BOOK_FIND_ALL_BY_GENRE_ID;

    @Value("${book.save.url}")
    public String BOOK_SAVE;


    @Value("${book.favourite.find_all.url}")
    public String BOOK_FAVOURITE_FIND_ALL;

    @Value("${book.favourite.find_by_book_id.url}")
    public String BOOK_FAVOURITE_FIND_BY_BOOK_ID;

    @Value("${book.favourite.delete.url}")
    public String BOOK_FAVOURITE_DELETE;

    @Value("${book.favourite.save.url}")
    public String BOOK_FAVOURITE_SAVE;


    @Value("${book.read.find_all.url}")
    public String BOOK_READ_FIND_ALL;

    @Value("${book.read.find_all_by_assessment_id.url}")
    public String BOOK_READ_FIND_ALL_BY_ASSESSMENT_ID;

    @Value("${book.read.find_all_by_date.url}")
    public String BOOK_READ_FIND_ALL_BY_DATE;

    @Value("${book.read.find_by_book_id.url}")
    public String BOOK_READ_FIND_BY_BOOK_ID;

    @Value("${book.read.save.url}")
    public String BOOK_READ_SAVE;

    @Value("${book.read.delete.url}")
    public String BOOK_READ_DELETE;


    @Value("${book.reading.find_all.url}")
    public String BOOK_READING_FIND_ALL;

    @Value("${book.reading.find_by_book_id.url}")
    public String BOOK_READING_FIND_BY_BOOK_ID;

    @Value("${book.reading.save.url}")
    public String BOOK_READING_SAVE;

    @Value("${book.reading.delete.url}")
    public String BOOK_READING_DELETE;


    @Value("${book.to_read.find_all.url}")
    public String BOOK_TO_READ_FIND_ALL;

    @Value("${book.to_read.find_by_book_id.url}")
    public String BOOK_TO_READ_FIND_BY_BOOK_ID;

    @Value("${book.to_read.save.url}")
    public String BOOK_TO_READ_SAVE;

    @Value("${book.to_read.delete.url}")
    public String BOOK_TO_READ_DELETE;


    @Value("${city.find_all.url}")
    public String CITY_FIND_ALL;

    @Value("${city.save.url}")
    public String CITY_SAVE;


    @Value("${country.find_all.url}")
    public String COUNTRY_FIND_ALL;

    @Value("${country.save.url}")
    public String COUNTRY_SAVE;


    @Value("${genre.find_all.url}")
    public String GENRE_FIND_ALL;

    @Value("${genre.find_by_name.url}")
    public String GENRE_FIND_BY_NAME;

    @Value("${genre.save.url}")
    public String GENRE_SAVE;


    @Value("${quote.find_all.url}")
    public String QUOTE_FIND_ALL;

    @Value("${quote.find_by_id.url}")
    public String QUOTE_FIND_BY_ID;

    @Value("${quote.find_by_content.url}")
    public String QUOTE_FIND_BY_CONTENT;

    @Value("${quote.delete_by_content.url}")
    public String QUOTE_DELETE_BY_CONTENT;

    @Value("${quote.delete.url}")
    public String QUOTE_DELETE;

    @Value("${quote.save.url}")
    public String QUOTE_SAVE;
}
