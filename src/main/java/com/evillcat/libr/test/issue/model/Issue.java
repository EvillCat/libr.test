package com.evillcat.libr.test.issue.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Calendar;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "issues")
public class Issue {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "student_id")
    private long studentId;

    @Column(name = "book_id")
    private long bookId;

    @Column(name = "begin_date")
    private Calendar beginDate;

    @Column(name = "end_date")
    private Calendar endDate;

    @Column(name = "active")
    private boolean active;

    @Column(name="penalty")
    private int penalty;
}
