package com.gfj.controller;

import com.gfj.entity.Book;
import com.gfj.service.BookService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class BookController {

    @Resource
    BookService service;

    @RequestMapping("/book/{bid}")
    Book findBookById(@PathVariable("bid") int bid){
        return service.getBookById(bid);
    }
}