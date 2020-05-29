package com.kami.web.mapper;

import com.kami.web.entity.UserDetails;

public interface UserDetailsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserDetails record);

    int insertSelective(UserDetails record);

    UserDetails selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserDetails record);

    int updateByPrimaryKey(UserDetails record);
}