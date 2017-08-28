package com.redis.controller;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.redis.model.User;

@Controller
public class TestController {
	
	@RequestMapping("/getUser")
	@ResponseBody
//	@Cacheable(value="user-key", key="#userId")
	@Cacheable(value="user-key", condition="#userId <50")
	public User getUser(
			@RequestParam(value = "userId" , required = true) Long userId
			) {
	    User user = new User();
	    user.setId(userId + "");
	    user.setName("dp");
	    System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");  
	    return user;
	}

}
