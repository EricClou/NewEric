package com.mmall.service;

import com.mmall.commons.ServerResponse;
import com.mmall.pojo.User;

public interface IUserService {

    public ServerResponse<User> login( String username, String password);

    public ServerResponse register(User user);

    public ServerResponse checkValid(String username,String emil);
}
