package com.company.dao;

import com.company.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> getUserList();
    User getUserById(int id);

    List<User> getUserByLimit(Map<String,Integer> map);

    List<User> getUserByRowBounds();
}
