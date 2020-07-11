package com.itheima.dao;

import com.itheima.domain.Account;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface IAccountDao {

    @Select(value = "select * from account")
    @Results(id = "accountMap",value = {
            @Result(id = true ,column = "id" , property = "id"),
            @Result(column = "uid" , property = "uid"),
            @Result(column = "money" , property = "money"),
            @Result(column = "uid",property = "user", one =@One(select = "com.itheima.dao.IuserDao.findById",fetchType = FetchType.LAZY))
    })
    List<Account> findAll();

    @Select(value = "select * from account where uid = #{uid}")
    @ResultMap(value = "accountMap")
    Account findById(Integer id);
}
