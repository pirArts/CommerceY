package com.baymax.baymax.servlet.wechat;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;  
import java.io.InputStream;  
import java.io.InputStreamReader;  

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baymax.baymax.servlet.BaseServlet;
import com.baymax.baymax.utils.common.ServletUtil;
import com.baymax.baymax.utils.wechat.SignUtil;
import com.baymax.baymax.utils.wechat.WechatProcess;

public class WeChatServlet extends BaseServlet{
    private final static Logger logger = LoggerFactory.getLogger(WeChatServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {

        String signature = req.getParameter("signature");


        String timestamp = req.getParameter("timestamp");
        

        String nonce = req.getParameter("nonce");
        

        String echostr = req.getParameter("echostr"); 

        if(!SignUtil.checkSignature(signature, timestamp, nonce)){
            echostr = "InValid";
        }
        
        ServletUtil.writeResponse(resp, 200, echostr);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");    
        resp.setCharacterEncoding("UTF-8");  
        StringBuffer sb = new StringBuffer();  
        InputStream is = req.getInputStream();  
        InputStreamReader isr = new InputStreamReader(is, "UTF-8");  

        BufferedReader br = new BufferedReader(isr);  
            
        String s = "";  
        while ((s = br.readLine()) != null) {  
            sb.append(s);  
        }  
        
        String xml = sb.toString();

        String result = WechatProcess.processWechatMag(xml);

        logger.debug(result);
        
        ServletUtil.writeResponse(resp, 200, result);
    }
}
