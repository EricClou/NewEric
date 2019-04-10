package com.mmall.controller.backend;

import com.mmall.common.Const;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;
import com.mmall.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;


//告诉DispatcherServlet相关的容器， 这是一个Controller， 管理好这个bean哦
@Controller

//类级别的RequestMapping，告诉DispatcherServlet由这个类负责处理的URL。
//HandlerMapping依靠这个标签来工作

@RequestMapping("/manage/user")
public class UserManageController {

    @Autowired
    private IUserService iUserService;


    //方法级别的RequestMapping， 限制并缩小了URL路径匹配，同类级别的标签协同工作，最终确定拦截到的URL由那个方法处理
    @RequestMapping(value = "login.do", method = RequestMethod.POST)
    //该注解用于将Controller的方法返回的对象，通过适当的HttpMessageConverter转换为指定格式后
    //写入到Response对象的body数据区。返回的数据不是html标签的页面，而是其他某种格式的数据时（如json、xml等）使用；
    @ResponseBody

    /**
     * 后台管理用户登陆，这里必须由管理员账号才能登陆，因此具有用户等级验证操作，防止纵向越权
     */
    public ServerResponse <User> login ( String username, String password, HttpSession session ) {
        ServerResponse <User> response = iUserService.login(username, password);
        if (response.isSuccess()) {
            User user = response.getData();
            //这里进行用户等级验证，目的是为了防止纵向越权。
            if (user.getRole() == Const.Role.ROLE_ADMIN) {
                //说明登录的是管理员
                session.setAttribute(Const.CURRENT_USER, user);
                return response;
            } else {
                return ServerResponse.createByErrorMessage("不是管理员,无法登录");
            }
        }
        return response;
    }

}
