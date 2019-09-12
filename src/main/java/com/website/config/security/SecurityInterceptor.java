package com.website.config.security;

import com.alibaba.fastjson.JSONObject;
import com.website.entity.dto.ClientResponse;
import com.website.entity.dto.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class SecurityInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private SessionClient sessionClient;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String clientId = request.getHeader(WebApiSecurityConfig.CLIENT_ID);
        if (!StringUtils.isEmpty(clientId)) {
            UserSession userSession = sessionClient.getSession(clientId);
            if(userSession!=null){
                sessionClient.refreshSessionTime(clientId);
                SessionUtils.createUserSession(userSession);
                return true;
            }
        }

        // 跳转登录-------controller类中的登陆方法
        /*String url = "/login";
        response.sendRedirect(url);*/
        response.getOutputStream().write(JSONObject.toJSONString(ClientResponse.fail(ClientResponse.NO_LOGIN,"没有登录")).getBytes());
        return false;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
        SessionUtils.remove();
    }
}