package com.website.config.security;

import com.website.dao.redis.CacheClient;
import com.website.entity.dto.UserSession;
import com.website.entity.po.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SessionClient {

    @Autowired
    private CacheClient cacheClient;
    //会话超时时间 3天
    private static Long SESSION_TIMEOUT = 259200l;

    /**
     * 获取用户信息
     * @param clientId
     * @return
     */
    public UserSession getSession(String clientId){
        UserSession userSession = (UserSession) cacheClient.getObject(clientId);
        return userSession;
    }

    /**
     * 创建用户信息
     * @param userSession
     * @return
     */
    public void createSession(UserSession userSession){
        cacheClient.set(userSession.getClientId(),userSession,SESSION_TIMEOUT);
    }

    /**
     * 刷新用户会话过期时间
     * @return
     */
    public void refreshSessionTime(String clientId){
        cacheClient.expire(clientId,SESSION_TIMEOUT);
    }

    /**
     * 删除用户信息
     * @param clientId
     * @return
     */
    public void deleteSession(String clientId){
        cacheClient.delete(clientId);
    }

}
