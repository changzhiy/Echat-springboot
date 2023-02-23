package cn.gd.cz.hong.chats.service;

import cn.gd.cz.hong.chats.model.LoginInfoDo;
import cn.gd.cz.hong.chats.model.MessageRecordDo;
import cn.gd.cz.hong.chats.model.User;

/**
 * 用户service接口
 */
public interface UserService {

    /**
     * 验证用户密码
     *
     * @param name
     * @param password
     * @return 正确返回该用户对象，否则返回空
     */
    User validateUserPassword(String name, String password);

    /**
     * 该用户是否已经注册
     * @param name
     * @return
     */
    public boolean isExistUser(String name);

    /**
     * 插入一名用户
     * @param name
     * @param password
     */
    public void insertUser(String name, String password);

    public void addUserLoginInfo(LoginInfoDo loginInfoDo);

    public void addUserMessageRecord(MessageRecordDo messageRecordDo);

    public User getUserByName(String name);
}
