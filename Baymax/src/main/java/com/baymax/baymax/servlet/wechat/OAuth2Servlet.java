package com.baymax.baymax.servlet.wechat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

import com.google.gson.Gson;
import com.baymax.baymax.servlet.BaseServlet;
import com.baymax.baymax.utils.common.HttpUtil;
import com.baymax.baymax.utils.common.ServletUtil;
import com.baymax.baymax.utils.wechat.AccessTokenResult;

public class OAuth2Servlet extends BaseServlet {

	private final static Logger logger = LoggerFactory.getLogger(OAuth2Servlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {

        String code = req.getParameter("code");

        String result = "Code InValid!";
        if(code != null){
            String url = "https://api.weixin.qq.com/sns/oauth2/access_token";

            HashMap<String, String> paramPair = new HashMap<String, String>();
            paramPair.put("appid", "wx8062c57197dba340");
            paramPair.put("secret", "44cc15d7342ab6ef375c51df9fb7b5f1");
            paramPair.put("code", code);
            paramPair.put("grant_type", "authorization_code");

            result = HttpUtil.GetContentFromUrl(url, paramPair);
            
            Gson gson = new Gson();
            AccessTokenResult atr = gson.fromJson(result, AccessTokenResult.class);
            
            logger.debug(atr.getOpenid());
            
            if(atr.getOpenid() != null){
                
                String userInfoUrl = "https://api.weixin.qq.com/sns/userinfo";
                HashMap<String, String> params = new HashMap<String, String>();
                params.put("access_token", atr.getAcessToken());
                params.put("openid", atr.getOpenid());
                params.put("lang", "zh_CN");
                
                result = HttpUtil.GetContentFromUrl(userInfoUrl, params);
            }
        }

        logger.debug(result);

        ServletUtil.writeResponse(resp, 200, result);
    }
}
