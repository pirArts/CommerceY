package com.baymax.baymax.servlet.wechat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

import com.baymax.baymax.servlet.BaseServlet;
import com.baymax.baymax.utils.common.HttpUtil;

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

            result = new HttpUtil().GetContentFromUrl(url, paramPair);
        }

        logger.debug(result);

        resp.setStatus(200);
        writeResponse(resp, result);
    }

    private void writeResponse(HttpServletResponse response, String info) throws IOException {
        PrintWriter out = response.getWriter();
        out.println(info);
        out.close();
        out = null;
    }
}
