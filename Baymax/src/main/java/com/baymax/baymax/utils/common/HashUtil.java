package com.baymax.baymax.utils.common;

import com.baymax.baymax.utils.exception.IdentityException;
import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * IDEA 14
 * Created by qiqidone on 15-7-19.
 */
public class HashUtil {
    public static String getMD5(String pwd) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA");//SHA 或者 MD5
            BASE64Encoder base = new BASE64Encoder ();
            String pwdAfter = base.encode(md.digest(pwd.getBytes()));
            return pwdAfter;
        } catch (NoSuchAlgorithmException e) {
            throw new IdentityException(e.getMessage());
        }
    }
}
