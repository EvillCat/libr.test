package com.evillcat.libr.test.author.repo;

import com.evillcat.libr.test.author.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Long> {

    @Query("select a from Author a where a.rating=(select max(a.rating) from Author a)")
    //SELECT * FROM authors WHERE rating=(SELECT max(rating) FROM authors);
    Author selectMostPopular();

    @Query("select a from Author a where a.fullName = :fullName")
    Author findAuthorByFullName(@Param("fullName") String fullName);

    @Query("select a from Author a where a.fullName like %?1%")
    List<Author> findAuthorsByName(String fullName);

    @Query("update Author a set a.rating = a.rating+1 where a.id = (select ash.authorId from AuthorShip ash where ash.bookId = :bookId)")
    //UPDATE authors SET rating=rating+1
    //WHERE id=(SELECT author_id FROM authorship WHERE book_id =?);
    void setRatingToAuthors(@Param("bookId") Long bookId);

    //@Query("select a from Author a where a.id = (select ash.authorId from AuthorShip ash where  ash.bookId = ?1)")
    @Query("select a from Author a where a.id=(select )  inner join authorship ash on(a.fullName = ash.full_name)")
    Author findAuthorByBookId(long bookId);

}
