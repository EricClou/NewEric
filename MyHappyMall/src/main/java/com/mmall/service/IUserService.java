package com.mmall.service;

import com.mmall.commons.ServerResponse;
import com.mmall.pojo.User;

public interface IUserService {

    public ServerResponse <User> login ( String username, String password );

    public ServerResponse <String> register ( User user );

    public ServerResponse <String> checkValid ( String username, String email );

    public ServerResponse <String> resetPassword ( String username, String oldPassword, String newPassword );

    public ServerResponse <User> updateUserInfo ( User user );

    public ServerResponse <String> selectQuestion ( String username );

    public ServerResponse <String> checkAnswer ( String username, String question, String answer );

    public ServerResponse <String> forgetResetPassword ( String username, String passwordNew, String forgetToken );




}
