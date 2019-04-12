package com.mmall.service.serviceImpl;

import com.mmall.commons.ResponseCode;
import com.mmall.commons.ServerResponse;
import com.mmall.dao.UserMapper;
import com.mmall.pojo.User;
import com.mmall.service.IUserService;
import com.mmall.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("iUserService")
public class UserServiceImpl implements IUserService {

    //自动注入
    @Autowired
    public UserMapper userMapper;


    @Override
    public ServerResponse <User> login ( String username, String password ) {
        int count = 0;
        count = userMapper.checkUsername(username);
        if (count == 0) {
            return ServerResponse.createByErrorMessage("该用户名不存在");
        }
        String passwordNew = MD5Utils.MD5EncodeUtf8(password);
        User user = userMapper.selectLogin(username, passwordNew);
        if (user == null) {
            return ServerResponse.createByErrorMessage("输入密码错误");
        }

        user.setPassword(org.apache.commons.lang3.StringUtils.EMPTY);
        return ServerResponse.createBySuccess("登陆成功", user);

    }

    @Override
    public ServerResponse register ( User user ) {
        //先验证用户名和邮箱是否被注册过
        ServerResponse response = checkValid(user.getUsername(), user.getEmail());
        if (response.getStatus() == ResponseCode.ERROR.getCode()) return response;

        //密码需要加密
        user.setPassword(MD5Utils.MD5EncodeUtf8(user.getPassword()));

        int count = userMapper.insert(user);

        if (count == 0) return ServerResponse.createByErrorMessage("操作失败");
        return ServerResponse.createBySuccess("注册成功");

    }

    @Override
    public ServerResponse checkValid ( String username, String email ) {
        if (userMapper.checkUsername(username) == 1) return ServerResponse.createByErrorMessage("该用户名已经被注册");
        if (userMapper.checkEmil(email) == 1) return ServerResponse.createByErrorMessage("该邮箱已被注册");
        return ServerResponse.createBySuccess();

    }
}
