package com.website.api;

import com.alibaba.fastjson.JSONObject;
import com.website.config.security.SessionClient;
import com.website.entity.dto.User;
import com.website.entity.dto.UserSession;
import com.website.entity.po.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by user on 16/10/25.
 */
@Slf4j
@Controller
@RequestMapping("/test")
public class TestApi {
    @Autowired
    private SessionClient sessionClient;

    @RequestMapping("/login")
    @ResponseBody
    public String login(){
        UserSession userSession = new UserSession();
        String clientId = DigestUtils.md5DigestAsHex("".getBytes());
        userSession.setClientId(clientId);
        userSession.setUser(new User());
        sessionClient.createSession(userSession);
        UserSession t = sessionClient.getSession(clientId);
        return JSONObject.toJSONString(t);
    }

    @RequestMapping("/index")
    @ResponseBody
    public String index(HttpServletRequest request){
        return "index:ok";
    }


}
