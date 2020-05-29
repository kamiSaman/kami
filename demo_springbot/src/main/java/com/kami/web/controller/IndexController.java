package com.kami.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kami.web.entity.User;
import com.kami.web.entity.UserPosition;
import com.kami.web.service.UserService;

/**
 * Created by kami on 2020/05/27.
 */
@RestController
public class IndexController {
	
	@Autowired
    UserService userService;
	
	@RequestMapping("/show")
    public List<User> getUser(int age){
        return userService.getUser(age);
    }
    
    @GetMapping("/selectPo")
    public UserPosition selectByPrimaryKey(int age){
        return userService.selectByPrimaryKey(age);
    }
    
    @GetMapping("/selectAllPo")
    public List<UserPosition> getUserPosition(){
        return userService.getUserPosition();
    }

    @RequestMapping("/index")
    public Map<String, String> Index(){
        Map<String, String> map = new HashMap<String, String>();
        map.put("北京","北方城市");
        map.put("深圳","南方城市");
        return map;
    }
    
    /**
     * 查找附近1000m的人
     * @author kami
     * @param radius 半径
     * @param lon 经度
     * @param lat 纬度
     * @return List<UserPosition>
     */
    @GetMapping("/Vicinity")
    public List<UserPosition> getVicinity(double radius,double lon,double lat){
    	List<UserPosition> userPoList = userService.getVicinity(radius, lon, lat);
    	return userPoList;
    }
}