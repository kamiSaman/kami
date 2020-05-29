package com.kami.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kami.web.entity.User;
import com.kami.web.entity.UserPosition;
import com.kami.web.mapper.UserMapper;
import com.kami.web.mapper.UserPositionMapper;
import com.kami.web.service.UserService;

/**
 * Created by kami on 2020/05/27.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper userMapper;
    
    @Autowired
    UserPositionMapper userPositionMapper;

    @Override
    public List<User> getUser(int age){
        return userMapper.getUser(age);
    }
    
    @Override
    public UserPosition selectByPrimaryKey(int age){
    	return userPositionMapper.selectByPrimaryKey(age);
    }
    
    @Override
    public List<UserPosition> getUserPosition(){
    	return userPositionMapper.getUserPosition();
    }

	@Override
	public List<UserPosition> getVicinity(double radius, double lon, double lat) {
		// 目标坐标1000m内最大、最小经度
		double lonMax = lon + 1000;
		double lonMin = lon - 1000;
		// 目标坐标1000m内最大、最小纬度
		double latMax = lat + 1000;
		double latMin = lat - 1000;
		
		// 查询该范围内位置
		List<UserPosition> userPoListAll = userPositionMapper.getVicinity(lonMax, lonMin, latMax, latMin);
		
		// 判断是否超过1000m
		List<UserPosition> userPoList = new ArrayList<UserPosition>（）；
		for (UserPosition user : userPoListAll) {
			double loni= user.getLongitude();
			double lati= user.getLatitude();
			// 目标坐标与获取坐标之间距离是否大于1000m
			(lon - loni)
		}
		
		return userPoList;
	}
}