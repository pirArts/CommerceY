package com.baymax.baymax.utils.wechat;

/*
{
   "access_token":"ACCESS_TOKEN",
   "expires_in":7200,
   "refresh_token":"REFRESH_TOKEN",
   "openid":"OPENID",
   "scope":"SCOPE"
}
*/

public class AccessTokenResult{
	private String access_token;
	private String expires_in;
	private String refresh_token;
	private String openid;
	private String scope;
	
    public String getOpenid(){
        return openid;
    }
    
    public String getAcessToken(){
        return access_token;
    }
    
	@Override
    public String toString() {
        return "Open ID is " + openid;
    }
}