package com.kami.web.mapper;

import java.util.List;

import com.kami.web.entity.UserPosition;

public interface UserPositionMapper {
	public int deleteByPrimaryKey(Integer id);

	public int insert(UserPosition record);

	public int insertSelective(UserPosition record);

	public UserPosition selectByPrimaryKey(Integer id);

	public int updateByPrimaryKeySelective(UserPosition record);

	public int updateByPrimaryKey(UserPosition record);
    
	public List<UserPosition> getUserPosition();

	/**
     * 查找附近1000m的人
     * @author kami
     * @param radius 半径
     * @param lon 经度
     * @param lat 纬度
     * @return List<UserPosition>
     */
	public List<UserPosition> getVicinity(double lonMax, double lonMin, double latMax, double latMin);
}