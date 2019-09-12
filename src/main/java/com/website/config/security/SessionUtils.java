package com.website.config.security;

import com.website.entity.dto.UserSession;

public class SessionUtils {

    private static ThreadLocal<UserSession> userSessionThreadLocal = new ThreadLocal<>();

    public static void createUserSession(UserSession userSession){
        userSessionThreadLocal.set(userSession);
    }

    public static UserSession getUserSession(UserSession userSession){
        return userSessionThreadLocal.get();
    }

    public static void remove(){
        userSessionThreadLocal.remove();
    }
}
