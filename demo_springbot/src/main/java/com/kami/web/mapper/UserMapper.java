package com.kami.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.kami.web.entity.User;

/**
 * 用户表
 * @author Kami
 * @date 2020/05/27
 */
public interface UserMapper {
    @Select("SELECT id,username,age,phone,email FROM USERS WHERE AGE=#{age}")
    List<User> getUser(int age);
}