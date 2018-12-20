package com.evillcat.libr.test.book.service;

import com.evillcat.libr.test.book.model.Book;
import com.evillcat.libr.test.book.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepo bookRepo;

    public List<Book> getBooksList(){return bookRepo.findAll();}

    public List<String> getBooksTitlesByText(String text){
        List<String> titles = new ArrayList<>();
        List<Book> books = bookRepo.takeBooksListByTitle(text);
        for(Book book : books)
            titles.add(book.getTitle());

        return titles;
    }

    public List<Book> getBooksListByTitle(String text){
        return bookRepo.takeBooksListByTitle(text);
    }

    public List <Book> getBookByAuthorName(String fullName){
        return bookRepo.findBookByAuthorName(fullName);
    }

    public List<Book> getAllByPubOfficeName(String pubOffice){
        return bookRepo.findAllByPubOffice(pubOffice);
    }

    public List<String> getBooksPubOfficesByRequest(String pubOffice){
        List<String> years = new ArrayList<>();
        List<Book> books = bookRepo.findAllByPubOffice(pubOffice);
        for(Book book : books)
            years.add(book.getPubOffice());

        return years;
    }



}
