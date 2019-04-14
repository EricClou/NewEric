package com.mmall.service.serviceImpl;

import com.mmall.commons.ResponseCode;
import com.mmall.commons.ServerResponse;
import com.mmall.dao.UserMapper;
import com.mmall.pojo.User;
import com.mmall.service.IUserService;
import com.mmall.utils.MD5Utils;
import org.apache.commons.lang3.StringUtils;
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


        //设定用户等级
        user.setRole(0);

        //密码需要加密
        user.setPassword(MD5Utils.MD5EncodeUtf8(user.getPassword()));

        int resultCount = userMapper.insert(user);

        if (resultCount == 0) return ServerResponse.createByErrorMessage("操作失败");
        return ServerResponse.createBySuccess("注册成功");

    }

    @Override
    public ServerResponse checkValid ( String username, String email ) {
        if (userMapper.checkUsername(username) > 0) return ServerResponse.createByErrorMessage("该用户名已经被注册");
        if (userMapper.checkEmailByUsername(email, username) > 0) return ServerResponse.createByErrorMessage("该邮箱已被注册");
        return ServerResponse.createBySuccess();

    }


    @Override
    public ServerResponse <String> updatePassword ( String username, String oldPassword, String newPassword ) {


        //验证旧密码是为了防止电脑主人离开时，他人操作修改密码
        String oldMD5Password = MD5Utils.MD5EncodeUtf8(oldPassword);
        String newMD5Password = MD5Utils.MD5EncodeUtf8(newPassword);

        int resultCount = userMapper.updatePassword(username, oldMD5Password, newMD5Password);
        if (resultCount == 0) return ServerResponse.createByErrorMessage("更新密码失败");
        return ServerResponse.createBySuccessMessage("更新密码成功");

    }


    @Override
    public ServerResponse <User> updateUserInfo ( User user ) {

        int resultCount = userMapper.checkEmailByUsername(user.getEmail(), user.getUsername());
        if (resultCount > 0) {
            return ServerResponse.createByErrorMessage("email已经存在，请更换");
        }
        User updateUser = new User();
        updateUser.setId(user.getId());
        updateUser.setEmail(user.getEmail());
        updateUser.setPhone(user.getPhone());
        updateUser.setQuestion(user.getQuestion());
        updateUser.setAnswer(user.getAnswer());

        int updateCount = userMapper.updateByPrimaryKeySelective(user);
        if (updateCount == 0) return ServerResponse.createByErrorMessage("更新信息失败");
        return ServerResponse.createBySuccess("更新信息成功", updateUser);
    }

//    @Override
//    public ServerResponse <String> checkAnswer ( String username, String question, String answer ) {
//        int resultCount = userMapper.checkAnswer(username, question, answer);
//        if (resultCount > 0) return ServerResponse.createBySuccessMessage("")
//    }


    @Override
    public ServerResponse <String> selectionQuestion ( Integer userId ) {
        String question = userMapper.selectionQuestion(userId);
        if ( StringUtils.isBlank(question)) return ServerResponse.createByError();
        return ServerResponse.createBySuccessMessage(question);


    }
}
