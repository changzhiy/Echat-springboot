package com.czy.echat.service.impl;


import com.czy.echat.dao.LoginInfoDAO;
import com.czy.echat.dao.MessageRecordDAO;
import com.czy.echat.dao.UserDAO;
import com.czy.echat.model.LoginInfoDo;
import com.czy.echat.model.MessageRecordDo;
import com.czy.echat.model.User;
import com.czy.echat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户service实现类
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private LoginInfoDAO loginInfoDAO;
    @Autowired
    private MessageRecordDAO messageRecordDAO;


    public User validateUserPassword(String name, String password) {
        return userDAO.queryUser(name, password);
    }

    public boolean isExistUser(String name) {
        User user = userDAO.queryUserByName(name);
        return user != null;
    }

    public void insertUser(String name, String password) {
        userDAO.insertUser(name, password);
    }

    @Override
    public void addUserLoginInfo(LoginInfoDo loginInfoDo) {
        loginInfoDAO.addLoginInfo(loginInfoDo);
    }

    @Override
    public void addUserMessageRecord(MessageRecordDo messageRecordDo) {
        messageRecordDAO.addMessageRecord(messageRecordDo);
    }

    @Override
    public User getUserByName(String name) {
        return userDAO.getUserByName(name);
    }
}
