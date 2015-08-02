package com.baymax.baymax.service.identity;
 
import com.baymax.baymax.servlet.identity.request.UserRequest;
import com.baymax.baymax.servlet.identity.response.UserResponse;
import com.baymax.baymax.utils.exception.IdentityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.baymax.baymax.dao.UserDAO;
import com.baymax.baymax.model.User;

import java.util.List;

@Service
public class UserService{
 
    @Autowired
    private UserDAO userDAO;

    public UserResponse authenticate(UserRequest userRequest){
        User user = authenticate(userRequest.getName(), userRequest.getPass());
        UserResponse response = new UserResponse();
        response.setName(user.getName());
        response.setDeviceId(user.getDeviceId());
        return response;
    }

    public User authenticate(String name, String pass) {
        User user = new User();
        user.setName(name);
        user.setPassword(pass);
        List<User> userList = userDAO.getUser(user);
        if (userList == null || userList.size() == 0) return null;
        else if (userList.size() > 1) throw new IdentityException();
        else return userList.get(0);
    }

    public int insertUser(User user) {
        // TODO Auto-generated method stub
        return userDAO.insertUser(user);
    }
 
 	public User getUserByDeviceId(String deviceId){
 		return userDAO.getUserByDeviceId(deviceId);
 	}
}