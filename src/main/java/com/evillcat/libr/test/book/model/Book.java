package com.evillcat.libr.test.book.model;

import com.evillcat.libr.test.author.model.Author;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book {

    @Id
    @Column(name="id")
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "pub_office")
    private String pubOffice;

    @Column(name = "pub_year")
    private int pubYear;

    @Column(name = "num_of_pages")
    private int numPages;

    @Column(name = "num_of_pics")
    private int numPics;

    @Column(name = "price")
    private float price;

    @Column(name ="copies")
    private int copies;

    @Column(name = "issues")
    private int issues;

    @ManyToMany
    @JoinTable(name = "authorship",
    joinColumns = @JoinColumn(name = "book_id"),
    inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<Author> authors;



}
