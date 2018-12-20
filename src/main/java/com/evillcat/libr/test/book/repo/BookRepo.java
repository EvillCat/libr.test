package com.evillcat.libr.test.book.repo;

import com.evillcat.libr.test.book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {

    @Query("select book from Book book where book.title like %?1%")
    List<Book> takeBooksListByTitle(String title);

    @Query("select book from Book book where book.pubOffice like %?1%")
    List<Book> findAllByPubOffice(String pubOffice);

    @Query("select book from Book book where book.id =(select ash.bookId from AuthorShip ash where ash.authorId =(select a.id from Author a where a.fullName = ?1))")
    List<Book> findBookByAuthorName(String fullName);





}
