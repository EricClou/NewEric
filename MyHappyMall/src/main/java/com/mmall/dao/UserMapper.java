package com.mmall.dao;

import com.mmall.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey ( Integer id );

    int insert ( User record );

    int insertSelective ( User record );

    User selectByPrimaryKey ( Integer id );

    int updateByPrimaryKeySelective ( User record );

    int updateByPrimaryKey ( User record );

    int checkUsername ( String username );

    User selectLogin ( @Param("username") String username, @Param("password") String password );


    //这里加一个username的原因是因为只检查当前这个用户以外的其他用户有没有重复的email
    //之所以要排除这个用户的邮箱重复的原因是因为在使用更新用户信息的功能的情况下，很有可能出现不更新邮箱而更新其他信息的情况
    //而在这种情况下如果检查范围放在全部数据上就会出现因为重复而导致其他信息无法更新
    int checkEmailByUsername ( @Param("email") String email, @Param("username") String username );

    int updatePassword ( @Param("username") String username, @Param("oldPassword") String oldPassword, @Param("newPassword") String newPassword );

    int checkAnswer ( @Param("username") String username, @Param("question") String question, @Param("answer") String answer );


    String selectionQuestion ( Integer userId );


}