package com.gfj.service.impl;

import com.gfj.entity.Borrow;
import com.gfj.entity.UserBorrowDetail;
import com.gfj.mapper.BorrowMapper;
import com.gfj.service.BorrowService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.gfj.entity.Book;
import com.gfj.entity.User;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowServiceImpl implements BorrowService {

    @Resource
    BorrowMapper mapper;

    //根据用户id获取用户借阅信息
    @Override
    public UserBorrowDetail getUserBorrowDetailByUid(int uid) {
        //获取用户的借阅信息
        List<Borrow> borrow = mapper.getBorrowsByUid(uid);
        //RestTemplate支持多种方式的远程调用
        RestTemplate template = new RestTemplate();
        //这里通过调用getForObject来请求其他服务，并将结果自动进行封装
        //获取User信息
        User user = template.getForObject("http://localhost:8101/user/"+uid, User.class);
        //获取每一本书的详细信息
        List<Book> bookList = borrow
                .stream()
                .map(b -> template.getForObject("http://localhost:8201/book/"+b.getBid(), Book.class))
                .collect(Collectors.toList());
        return new UserBorrowDetail(user, bookList);
    }
}