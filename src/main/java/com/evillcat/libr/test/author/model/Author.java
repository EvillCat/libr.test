package com.evillcat.libr.test.author.model;


import com.evillcat.libr.test.book.model.Book;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "authors")
public class Author {

    @Id
    @Column(name="id")
    private long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "rating")
    private int rating;

    @ManyToMany
    @JoinTable(name = "authorship",
    joinColumns = @JoinColumn(name = "author_id"),
    inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<Book> books;
}
