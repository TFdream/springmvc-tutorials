package com.ricky.codelab.springmvc.controller;

import com.ricky.codelab.springmvc.domain.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @create 2016-08-25 11:55
 */
@Controller
@RequestMapping("/book")
public class BookController {

    private AtomicLong idGenerator = new AtomicLong(1);

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    @ResponseBody
    public List<Book> getBooks(){
        List<Book> books = new ArrayList<Book>();
        for(int i=0;i<5;i++){
            Book book = new Book();
            book.setId(idGenerator.getAndIncrement());
            book.setIsbn("I15_"+book.getId());
            book.setName("重构:改善既有代码设计");
            book.setPrice(47.5d);
            book.setAuthor("Martin Fowler");
            books.add(book);
        }
        return books;
    }

    @RequestMapping(value = "/{isbn}", method = RequestMethod.GET)
    @ResponseBody
    public Book getBookById(@PathVariable String isbn){
        Book book = new Book();
        book.setId(idGenerator.getAndIncrement());
        book.setIsbn(isbn);
        book.setName("Thinking In Java 4th Edition");
        book.setPrice(47.5d);
        book.setAuthor("Martin Fowler");
        return book;
    }
}
