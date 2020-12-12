package ru.nsu.g.beryanov.book_library.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "book", schema = "book_library")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "author_id")
    private Long authorId;
    @Column(name = "genre_id")
    private Long genreId;
    @Lob
    private Byte[] image;
    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Author authorByAuthorId;
    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Genre genreByGenreId;
    @OneToMany(mappedBy = "bookByBookId")
    private List<BookRead> booksReadById;
    @OneToMany(mappedBy = "bookByBookId")
    private List<BookReading> booksReadingById;
    @OneToMany(mappedBy = "bookByBookId")
    private List<BookToRead> booksToReadById;
    @OneToMany(mappedBy = "bookByBookId")
    private List<BookFavourite> booksFavouriteById;
}
