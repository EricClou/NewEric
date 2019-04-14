package com.mmall.controller.portal;


import com.mmall.commons.Const;
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
            session.setAttribute(Const.CURRENT_USER, response.getData());
        }
        return response;
    }


    @RequestMapping(value = "/logout.do")
    @ResponseBody
    public ServerResponse <String> logout ( HttpSession session ) {
        session.removeAttribute(Const.CURRENT_USER);
        return ServerResponse.createBySuccess("退出登陆");
    }

    @RequestMapping(value = "/register.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse <String> register ( User user ) {
        return iUserService.register(user);
    }


    //显示地写在外面是为了ajax动态显示
    @RequestMapping(value = "/check_valid.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse <String> checkValid ( String username, String email ) {
        return iUserService.checkValid(username, email);
    }

    @RequestMapping(value = "/get_user_info.do")
    @ResponseBody
    public ServerResponse <User> getUserInfo ( HttpSession session ) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null)
            return ServerResponse.createByErrorMessage("用户未登录,无法获取当前用户的信息");

        return ServerResponse.createBySuccess(user);
    }

    @RequestMapping(value = "/update_user_info.do")
    @ResponseBody
    public ServerResponse <User> updateUserInfo ( HttpSession session, User user ) {
        User currentUser = (User) session.getAttribute(Const.CURRENT_USER);
        if (currentUser == null)
            return ServerResponse.createByErrorMessage("用户未登录,无法更新当前用户的信息");

        //这两句非常重要，因为我们必须把其放入新的user里面，从页面填空上获得的类是不包含这两项的，但是更新又必须用到
        user.setId(currentUser.getId());
        user.setUsername(currentUser.getUsername());
        
        ServerResponse <User> response = iUserService.updateUserInfo(user);
        if (response.isSuccess()) {
            response.getData().setUsername(currentUser.getUsername());
            session.setAttribute(Const.CURRENT_USER, response.getData());
        }
        return response;
    }

    @RequestMapping(value = "/reset_password.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse <String> resetPassword ( HttpSession session, String oldPassword, String newPassword ) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);


        if (user == null)
            return ServerResponse.createByErrorMessage("用户未登录,无法进行此操作");

        return iUserService.updatePassword(user.getUsername(), oldPassword, newPassword);
    }
}
