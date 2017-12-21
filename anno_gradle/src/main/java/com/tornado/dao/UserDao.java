package com.tornado.dao;


import com.tornado.domain.User;

public interface UserDao {

    User findUserById(Integer id);

}
