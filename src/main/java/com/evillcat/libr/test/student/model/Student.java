package com.evillcat.libr.test.student.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "students")
public class Student {

    @Id
    @Column(name="id")
    private long id;

    @Column(name="full_name")
    private String fullName;

    @Column(name = "overdue_days")
    private int overdueDays;
}
