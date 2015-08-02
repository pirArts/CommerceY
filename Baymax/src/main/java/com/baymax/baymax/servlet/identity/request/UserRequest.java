package com.baymax.baymax.servlet.identity.request;

/**
 * IDEA 14
 * Created by qiqidone on 15-7-22.
 */
public class UserRequest {
    private String name;
    private String pass;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String toString(){
        return name + "," + pass;
    }
}
