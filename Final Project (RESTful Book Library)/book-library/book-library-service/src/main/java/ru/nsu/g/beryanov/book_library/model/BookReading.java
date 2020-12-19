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
import java.util.Date;

@Data
@Entity
@Table(name = "book_reading", schema = "book_library")
public class BookReading {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "book_id")
    private Long bookId;
    @Column(name = "start_date")
    private Date startDate;
    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private Book bookByBookId;
}
