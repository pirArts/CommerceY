package com.baymax.baymax.utils;
  
import java.lang.reflect.Field;  
import java.lang.reflect.Method;  
import java.util.Iterator;  
import org.dom4j.Document;  
import org.dom4j.DocumentHelper;  
import org.dom4j.Element;  

public class ReceiveXmlProcess {
    public ReceiveXmlEntity getMsgEntity(String strXml){  
        ReceiveXmlEntity msg = null;  
        try {  
            if (strXml.length() <= 0 || strXml == null)  
                return null;  
               
            Document document = DocumentHelper.parseText(strXml);  

            Element root = document.getRootElement();  
 
            Iterator<?> iter = root.elementIterator();  
              

            msg = new ReceiveXmlEntity();  

            Class<?> c = Class.forName("com.baymax.baymax.utils.ReceiveXmlEntity");  
            msg = (ReceiveXmlEntity)c.newInstance();
              
            while(iter.hasNext()){  
                Element ele = (Element)iter.next();  
 
                Field field = c.getDeclaredField(ele.getName());  

                Method method = c.getDeclaredMethod("set"+ele.getName(), field.getType());  

                method.invoke(msg, ele.getText());  
            }  
        } catch (Exception e) {  

            System.out.println("xml formate invalid: "+ strXml);  
            e.printStackTrace();  
        }  
        return msg;  
    }  
}