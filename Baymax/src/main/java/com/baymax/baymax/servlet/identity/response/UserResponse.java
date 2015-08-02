package com.baymax.baymax.servlet.identity.response;

/**
 * IDEA 14
 * Created by qiqidone on 15-7-22.
 */
public class UserResponse {
    private String name;
    private String deviceId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}
