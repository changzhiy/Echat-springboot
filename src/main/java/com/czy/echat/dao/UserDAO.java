package com.czy.echat.dao;


import com.czy.echat.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 用户dao接口
 */
@Mapper
public interface UserDAO {
    /**
     * 以用户名和密码查询用户
     * @param name
     * @param password
     * @return 存在返回该用户对象，不存在返回null
     */
    @Select({"SELECT id, name, password FROM user WHERE name = #{name} AND password = #{password}"})
    User queryUser(@Param("name") String name, @Param("password") String password);

    /**
     * 以用户名查询用户
     * @param name
     * @return 存在该用户名返回用户对象，否则返回null
     */
    @Select({"SELECT id, name, password FROM user WHERE name = #{name}"})
    User queryUserByName(@Param("name") String name);

    /**
     * 插入一位用户
     * @param name
     * @param password
     */
    @Insert({"INSERT INTO user(name, password) VALUES(#{name}, #{password})"})
    void insertUser(@Param("name") String name,@Param("password") String password);

    /**
     * 根据用户名获取用户信息
     * @param name
     * @return
     */
    @Select({"SELECT * FROM user where name = #{name} limit 1"})
    User getUserByName(@Param("name") String name);

}
