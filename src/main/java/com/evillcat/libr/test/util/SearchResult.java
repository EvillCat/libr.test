package com.evillcat.libr.test.util;

import com.evillcat.libr.test.author.service.AuthorService;
import com.evillcat.libr.test.book.model.Book;
import com.evillcat.libr.test.book.service.BookService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Data
public class SearchResult {

    @Autowired
    BookService bookService;
    @Autowired
    AuthorService authorService;

    private long id;

    private String title;

    private String pubOffice;

    private int pubYear;

    private int numPages;

    private int numPics;

    private float price;

    private int copies;

    private int issues;

    private String authorName;

    private List<SearchResult> resultList;

    protected SearchResult(Book book, String authorNameByBookId)
    {
        this.id = book.getId();
        this.title = book.getTitle();
        this.pubOffice = book.getPubOffice();
        this.pubYear = book.getPubYear();
        this.numPages = book.getNumPages();
        this.numPics = book.getNumPics();
        this.price = book.getPrice();
        this.copies = book.getCopies();
        this.issues = book.getIssues();
        this.authorName = authorNameByBookId;
    }

    public SearchResult(String title, String fullName, String pubOffice){
        resultList = new ArrayList<>();
        if(title!=null){
            List<Book> books = bookService.getBooksListByTitle(title);
            for(Book book : books)
                resultList.add(new SearchResult(book, authorService.getAuthorNameByBookId(book.getId())));
        }

        if(fullName!=null){
            List<Book> books = bookService.getBookByAuthorName(fullName);
            for(Book book : books)
                resultList.add(new SearchResult(book, fullName));
        }

        if(pubOffice!=null){
            List<Book> books = bookService.getAllByPubOfficeName(pubOffice);
            for(Book book : books)
                resultList.add(new SearchResult(book, authorService.getAuthorNameByBookId(book.getId())));
        }
    }


}
