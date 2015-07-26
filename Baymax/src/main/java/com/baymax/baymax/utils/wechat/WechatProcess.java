package com.baymax.baymax.utils.wechat;

public class WechatProcess {
    public static String processWechatMag(String xml){
 
        ReceiveXmlEntity xmlEntity = ReceiveXmlProcess.getMsgEntity(xml);
        
        String result = "NoResult";
        if(xmlEntity.getMsgType().equals("text")){  
            result = "Your openID is " + xmlEntity.getFromUserName();
        }
        else if(xmlEntity.getMsgType().equals("event")){
            if(xmlEntity.getEvent().equals("subscribe")){
                result = "Welcome to subscribe us!";
            }
            else if(xmlEntity.getEvent().equals("CLICK")){
                result = "Your OPENID is " + xmlEntity.getFromUserName() + ";" + "You click " + xmlEntity.getEventKey();
            }
        }
         
        result = new FormatXmlProcess().formatXmlAnswer(xmlEntity.getFromUserName(), xmlEntity.getToUserName(), result);
        
        return result;
    }  
}  