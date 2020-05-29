package com.kami.web.service;

import java.util.List;

import com.kami.web.entity.User;
import com.kami.web.entity.UserPosition;

/**
 * Created by toutou on 2018/9/15.
 */
public interface UserService {
    List<User> getUser(int age);
    
    UserPosition selectByPrimaryKey(int age);

    List<UserPosition> getUserPosition();

    /**
     * 查找附近1000m的人
     * @author kami
     * @param radius 半径
     * @param lon 经度
     * @param lat 纬度
     * @return List<UserPosition>
     */
	List<UserPosition> getVicinity(double radius, double lon, double lat);
}