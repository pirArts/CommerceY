package com.baymax.baymax.db.model;

/**
 * Created with IntelliJ IDEA.
 * User: EricQiu
 * Date: 5/25/15
 * Time: 11:28 AM
 */
public class User extends BaseModel {
    private Long id;
    private String deviceId;
    private String name;
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
