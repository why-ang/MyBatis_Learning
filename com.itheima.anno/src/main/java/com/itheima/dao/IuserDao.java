package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import javax.annotation.Resources;
import java.io.InputStream;
import java.util.List;

public interface IuserDao {
    @Select(value = "select * from user")
    @Results(id = "userMap",value = {
            @Result(id = true ,column = "id" , property = "userid"),
            @Result(column = "username" , property = "username"),
            @Result(column = "address" , property = "useraddress"),
            @Result(column = "birthday" , property = "userbirthday"),
            @Result(column = "sex" , property = "usersex"),
            @Result(column = "id",property = "accounts",many = @Many(select = "com.itheima.dao.IAccountDao.findById",fetchType = FetchType.LAZY))
    })
    List<User> findAll();

    @Select(value = "select * from user where id = #{id}")
    @ResultMap(value = "userMap")
    User findById(Integer id);


    @Update(value = "update user set username = #{username} ,address = #{address},sex = #{sex},birthday = #{birthday} where id = #{id}")
    void updataUser(User user);



}
