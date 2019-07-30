package com.tucker.mybatisdemo.dao;

import com.tucker.mybatisdemo.bean.User;

import java.util.List;

public interface IUserDao {

    List<User> findAll();

}
