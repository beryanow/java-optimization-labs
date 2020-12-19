package ru.nsu.g.beryanov.book_library.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "assessment", schema = "book_library")
public class Assessment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "grade")
    private Byte grade;
    @OneToMany(mappedBy = "assessmentByAssessmentId")
    private List<BookRead> booksReadById;
}
