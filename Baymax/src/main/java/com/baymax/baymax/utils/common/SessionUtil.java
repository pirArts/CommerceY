package com.baymax.baymax.utils.common;

import javax.servlet.http.HttpSession;

/**
 * IDEA 14
 * Created by qiqidone on 15-7-19.
 */
public class SessionUtil {
    static private int expireTime = 60*60; // 1h

    static public void setSessionAttribute(HttpSession session, String key, Object val){
        session.setAttribute(key, val);
    }

    static public void updateExpireTime(HttpSession session){
        session.setMaxInactiveInterval(expireTime);
    }


    public void setExpireTime(int expireTime) {
        this.expireTime = expireTime;
    }
}
