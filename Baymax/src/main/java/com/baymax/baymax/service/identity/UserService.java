package com.baymax.baymax.service.identity;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.baymax.baymax.dao.UserDAO;
import com.baymax.baymax.model.User;
 
@Service
public class UserService{
 
    @Autowired
    private UserDAO userDAO;
    
    public int insertUser(User user) {
        // TODO Auto-generated method stub
        return userDAO.insertUser(user);
    }
 
 	public User getUserByDeviceId(String deviceId){
 		return userDAO.getUserByDeviceId(deviceId);
 	}
}