package com.website.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.website.biz.UserBiz;
import com.website.entity.po.UserInfo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class HelloController {
	
	@Autowired
	private UserBiz userBiz;
	
	@RequestMapping("/home/{username}")
    public String home(@PathVariable("username") String username) {
    	System.out.println("my name is "+username);
        return "home";
    }
	
    @RequestMapping("/")
    public String index( ) {
        return "index";
    }

    @RequestMapping("/hello")
    public Object hello() {
    	log.info("测试hello");
    	Subject subject = SecurityUtils.getSubject();
    	if(subject.isAuthenticated()){
    		UserInfo user = userBiz.findUserInfo(1L);
    		return user;
    	}else{
    		return "no login";
    	}
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(String username,String password) {
		UsernamePasswordToken upt = new UsernamePasswordToken(username, password);
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(upt);
		} catch (AuthenticationException e) {
			e.printStackTrace();
			//rediect.addFlashAttribute("errorText", "您的账号或密码输入错误!");
		}
		return "login success";
    }

    @RequestMapping("/layout")
    public String layout() {
    	Subject subject = SecurityUtils.getSubject();
    	try {
			subject.logout();
		} catch (Exception e) {
			e.printStackTrace();
		}
        return "layout";
    }
}
