package com.evillcat.libr.test.issue.repo;

import com.evillcat.libr.test.issue.model.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueRepo extends JpaRepository<Issue, Long> {
}
