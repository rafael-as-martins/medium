package com.medium.client.utils;


public class UserContextHolder {
    private static ThreadLocal<UserContext> userContext = new ThreadLocal<>();

    public static final UserContext getContext(){
        UserContext context = userContext.get();
        if (context == null) {
            context = new UserContext();
            userContext.set(context);
        }
        return userContext.get();
    }
}
