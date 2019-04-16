package com.mmall.controller.backend;


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
@RequestMapping("/managerUserController")
public class ManagerUserController {

    @Autowired
    public IUserService iUserService;

    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse <User> login ( String username, String password, HttpSession session ) {
        ServerResponse <User> response = iUserService.login(username, password);

        //在判断是否为管理员之前要先判断数据库中是否有该账户，不然直接执行取出data操作会报错
        if (response.isSuccess() != true) return response;

        User user = response.getData();
        if (user.getRole() != 1) {
            return ServerResponse.createByErrorMessage("当前登陆的账号不是管理员账号，请换个账号登陆。");
        }
        if (response.isSuccess()) {
            session.setAttribute(Const.CURRENT_USER, response.getData());
        }
        return response;
    }
}
