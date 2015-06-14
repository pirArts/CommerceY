package com.baymax.baymax.utils.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created with IntelliJ IDEA.
 * User: EricQiu
 * Date: 5/25/15
 * Time: 12:00 PM
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "UserJsonObject")
public class UserJasonObject {
    @XmlElement(name = "id")
    private Long id;

    @XmlElement(name = "deviceId")
    private String deviceId;

    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "password")
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
