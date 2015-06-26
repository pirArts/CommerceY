package com.baymax.baymax.service.impl;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.baymax.baymax.dao.UserDAO;
import com.baymax.baymax.model.User;
import com.baymax.baymax.service.identity.UserService;
 
 
@Service
public class UserServiceImpl implements UserService{
 
    @Autowired
    private UserDAO userDAO;
     
    @Override
    public int insertUser(User user) {
        // TODO Auto-generated method stub
        return userDAO.insertUser(user);
    }
 
 	@Override
 	public User getUserByDeviceId(String deviceId){
 		return userDAO.getUserByDeviceId(deviceId);
 	}
}