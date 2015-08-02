package com.baymax.baymax.servlet.identity;

import com.baymax.baymax.service.identity.UserService;
import com.baymax.baymax.servlet.BaseServlet;
import com.baymax.baymax.servlet.identity.request.UserRequest;
import com.baymax.baymax.servlet.identity.response.UserResponse;
import com.baymax.baymax.utils.common.HashUtil;
import com.baymax.baymax.utils.exception.IdentityException;
import com.baymax.baymax.utils.marshaller.JsonMarshaller;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * Created with IntelliJ IDEA.
 * User: EricQiu
 * Date: 5/15/15
 * Time: 4:23 PM
 */
public class PostUserServlet extends BaseServlet {

    @Autowired
    private UserService userService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String payload = getBody(req);
        UserRequest userRequest = (UserRequest) JsonMarshaller.fromJson(payload, UserRequest.class);
        UserResponse userResponse = userService.authenticate(userRequest);

        HttpSession session = req.getSession();
        session.setAttribute("name", userResponse.getName());
        session.setAttribute("deviceId", userResponse.getDeviceId());
        writeResponse(resp, JsonMarshaller.toJson(userResponse));
    }
}
