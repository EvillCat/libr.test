package com.evillcat.libr.test.author.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//@Entity
@Table(name = "authorship")
public class AuthorShip {

    @Id
    @Column(name = "id")
    private long id;

    //@ManyToOne
    //@JoinColumn(name = "author_id")
    //private Author author;

    @Column(name = "book_id")
    private long bookId;
}
