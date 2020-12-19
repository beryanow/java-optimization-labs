package ru.nsu.g.beryanov.book_library.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "book_favourite", schema = "book_library")
public class BookFavourite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "book_id")
    private Long bookId;
    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private Book bookByBookId;
}
