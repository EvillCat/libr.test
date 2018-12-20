package com.evillcat.libr.test.issue.service;

import com.evillcat.libr.test.author.service.AuthorService;
import com.evillcat.libr.test.issue.model.Issue;
import com.evillcat.libr.test.issue.repo.IssueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IssueService {
    @Autowired
    IssueRepo issueRepo;
    AuthorService authorService;

    public void creatIssue(Issue issue){
        issueRepo.save(issue);

    }
}
