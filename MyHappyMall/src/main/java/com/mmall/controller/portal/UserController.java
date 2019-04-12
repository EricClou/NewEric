package com.mmall.controller.portal;


import com.mmall.commons.ServerResponse;
import com.mmall.pojo.User;
import com.mmall.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/UserController")
public class UserController {


    @Autowired
    public IUserService iUserService;

    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    //将信息注入到body区
    @ResponseBody
    public ServerResponse <User> login ( String username, String password, HttpSession session ) {
        ServerResponse response = iUserService.login(username, password);
        if (response.isSuccess()) {
            session.setAttribute("currentUser", response.getData());
        }
        return response;
    }


    @RequestMapping(value = "/logout.do")
    @ResponseBody
    public ServerResponse <String> logout ( HttpSession session ) {
        session.removeAttribute("currentUser");
        return ServerResponse.createBySuccess("退出登陆");
    }

    @RequestMapping(value = "/register.do")
    @ResponseBody
    public ServerResponse register ( User user ) {
        ServerResponse response = iUserService.register(user);
        return response;

    }
}
