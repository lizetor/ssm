package com.tornado.service;

import com.tornado.domain.User;

public interface UserService {
    User findUserById(Integer id);
}
