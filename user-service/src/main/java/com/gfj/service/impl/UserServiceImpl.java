package com.gfj.service.impl;

import com.gfj.entity.User;
import com.gfj.mapper.UserMapper;
import com.gfj.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper mapper;

    @Override
    public User getUserById(int uid) {
        return mapper.getUserById(uid);
    }
}