package com.company.dao;

import com.company.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> getUserList();
    User getUserById(int id);
}
