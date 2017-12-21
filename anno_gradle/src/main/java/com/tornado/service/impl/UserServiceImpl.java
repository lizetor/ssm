package com.tornado.service.impl;

import com.tornado.dao.UserDao;
import com.tornado.domain.User;
import com.tornado.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;


    @Override
    public User findUserById(Integer id) {
        return userDao.findUserById(id);
    }
}
