package com.evillcat.libr.test;

import com.evillcat.libr.test.book.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	BookService bookService;

	@Test
	public void contextLoads() {
		List<String> titles = bookService.getBooksTitlesByText("Крас");
		for (String s : titles)
			System.out.println(s);
	}

}

