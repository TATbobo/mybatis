package com.tucker.mybatisdemo.bean;

import lombok.Data;

import java.util.Date;

@Data
public class User {

    private Integer id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;
}
