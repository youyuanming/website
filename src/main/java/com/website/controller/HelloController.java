package com.website.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@Controller
public class HelloController {
	

	/**
	 * 登录系统首页
	 * @return
	 */
    @RequestMapping("/index")
    public String index() {
    	//获得用户信息
    	Subject subject = SecurityUtils.getSubject();
		//判断是否登录
		if(subject.isAuthenticated()){
    		return "index";
    	}else{
    		return "login";
    	}
    }

	/**
	 * 登录系统
	 * @param username
	 * @param password
	 * @param model
	 * @return
	 */
    @RequestMapping(value = "/login", method = {RequestMethod.GET,RequestMethod.POST})
    public String login(String username,String password,Model model) {
		try {
			if(StringUtils.isEmpty(username)||StringUtils.isEmpty(password)){
				//model.addAttribute("errorText","请输入用户名和密码!");
				return "login";
			}
			UsernamePasswordToken upt = new UsernamePasswordToken(username, password);
			Subject subject = SecurityUtils.getSubject();
			subject.login(upt);
			subject.hasRole(upt.getUsername());
		} catch (AuthenticationException e) {
			e.printStackTrace();
			model.addAttribute("errorText","您的账号或密码输入错误!");
			//rediect.addFlashAttribute("errorText", "您的账号或密码输入错误!");
			return "login";
		}
		return "redirect:/index";
    }

	/**
	 * 退出系统
	 * @return
	 */
	@RequestMapping("/layout")
    public String layout() {
    	Subject subject = SecurityUtils.getSubject();
    	try {
			subject.logout();
		} catch (Exception e) {
			e.printStackTrace();
		}
        return "redirect:/login";
    }
}
