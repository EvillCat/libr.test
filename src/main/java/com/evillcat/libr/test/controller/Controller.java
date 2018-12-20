package com.evillcat.libr.test.controller;

import com.evillcat.libr.test.author.service.AuthorService;
import com.evillcat.libr.test.book.service.BookService;
import com.evillcat.libr.test.util.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    BookService bookService;
    @Autowired
    AuthorService authorService;
    @Autowired
    private HttpServletRequest context;

    private SearchResult search;

    @GetMapping("/search/titles")
    public List<String> getTitles(){
        String term = context.getParameter("term");
        return bookService.getBooksTitlesByText(term);
    }

    @GetMapping("/search/authors")
    public List<String> getAuthors(){
        String term = context.getParameter("term");
        return authorService.getAuthorsNamesByRequest(term);
    }

    @GetMapping("/search/publishers")
    public List<String> getYears(){
        String term = context.getParameter("term");
        return bookService.getBooksPubOfficesByRequest(term);
    }

    @PostMapping("/search")
    public String search(){
        String status;
        String title = context.getParameter("title");
        String fullName = context.getParameter("fullName");
        String pubOffice = context.getParameter("pubOffice");

        if(title != null || fullName != null || pubOffice != null){
            status = "OK";
            search = new SearchResult(title, fullName, pubOffice);
        }
        else {
            status = "FAILED";
        }
        return status;
    }

    @GetMapping("/search/result")
    public Response<SearchResult> getResult(){
        Response<SearchResult> response = new Response<>();
        response.setData(search);
        if((response.getData().getResultList()) == null) {
            response.setStatus("No data");
            response.setMessage("К сожалению, по Вашему запросу ничего не найдено");
        }
        return response;
    }







   /*@GetMapping("/issue")
    public @ResponseBody
    Response<Collection<Book>> getBooks(){
       Response<Collection<Book>> response = new Response<>();
       Collection<Book> books = bookService.getBooksList();
       response.setData(books);
       return response;
    }*/
}
