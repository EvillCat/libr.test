package com.evillcat.libr.test.author.service;

import com.evillcat.libr.test.author.model.Author;
import com.evillcat.libr.test.author.repo.AuthorRepo;
import com.evillcat.libr.test.issue.model.Issue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    @Autowired
    AuthorRepo authorRepo;


    public Author getMostPopularAuthor(){ return authorRepo.selectMostPopular();}

    public Author findAuthroByName(String name){return authorRepo.findAuthorByFullName(name);}

    public void addRatingPoint(Issue issue){ authorRepo.setRatingToAuthors(issue.getBookId());}

    public List<String> getAuthorsNamesByRequest(String fullName){
        List<String> names = new ArrayList<>();
        List<Author> authors = authorRepo.findAuthorsByName(fullName);
        for(Author author : authors)
            names.add(author.getFullName());

        return names;
    }

    public String getAuthorNameByBookId(long id){
        return (authorRepo.findAuthorByBookId(id)).getFullName();
    }
}
