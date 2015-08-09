package com.baymax.baymax.dao;

import com.baymax.baymax.model.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: EricQiu
 * Date: 5/15/15
 * Time: 3:42 PM
 */
public interface UserDAO {
	public int insertUser(User user);
	public List<User> getUser(User user);
	public User getUserByDeviceId(String deviceId);
}
