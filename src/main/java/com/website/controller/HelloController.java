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
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class HelloController {

	private static int n=1;

	@RequestMapping("/test")
	@ResponseBody
	public Map test(HttpServletRequest request) {
		System.out.println(request.getParameterMap());
		Map map = new HashMap<>();
		List list=new ArrayList<>();
		n++;
		map.put("draw",n);
		map.put("recordsTotal",1000);
		map.put("recordsFiltered",1000);
		for(int i=0;i<10;i++){
			/*List obj = new ArrayList();
			obj.add("1");
			obj.add("Airi");
			obj.add("Satou");
			obj.add("Accountant");
			obj.add("Tokyo");
			obj.add("28th Nov 08");
			obj.add("$162,700");
			list.add(obj);*/
			Map obj= new HashMap();
			/*obj.put("DT_RowId",i);
			obj.put("staffId",i);
			obj.put("name","Airi"+i);
			obj.put("position","Satou2");
			obj.put("office","2");
			obj.put("extn","2");
			obj.put("start_date","28th Nov 08");
			obj.put("salary","$162,700");
			list.add(obj);*/
			obj.put("DT_RowId",i);
			obj.put("0",i);
			obj.put("1","Airi"+i);
			obj.put("2","Satou2");
			obj.put("3","2");
			obj.put("4","2");
			obj.put("5","28th Nov 08");
			obj.put("6","$162,700");
			list.add(obj);
		}
		map.put("data",list);
		return map;
	}

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
    @RequestMapping(value = {"/","/login"})
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
			log.info("登录失败,用户名或密码错误",e.getMessage());
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
			log.info("退出系统异常",e.getMessage());
		}
        return "redirect:/login";
    }
}
