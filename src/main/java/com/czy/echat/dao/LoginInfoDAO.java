package com.czy.echat.dao;


import com.czy.echat.model.LoginInfoDo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface LoginInfoDAO {
    @Insert({"INSERT INTO login_info(user_id, user_name, status, create_time)  VALUES (#{userId}, #{userName}, #{status}, #{createTime})"})
    int addLoginInfo(LoginInfoDo loginInfoDo);
}
