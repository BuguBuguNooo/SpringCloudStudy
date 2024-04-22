package com.gfj.service.impl;

import com.gfj.entity.Book;
import com.gfj.mapper.BookMapper;
import com.gfj.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BookServiceImpl implements BookService {

    @Resource
    BookMapper mapper;

    @Override
    public Book getBookById(int bid) {
        return mapper.getBookById(bid);
    }
}