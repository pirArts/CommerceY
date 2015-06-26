package com.baymax.baymax.service.identity;

import com.baymax.baymax.model.User;

/**
 * Created with IntelliJ IDEA.
 * User: EricQiu
 * Date: 5/15/15
 * Time: 3:43 PM
 */
public interface UserService {
    public int insertUser(User user);
    public User getUserByDeviceId(String deviceId);
}
