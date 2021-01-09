package com.czy.echat.controller;


import com.czy.echat.enums.LoginTypeEnum;
import com.czy.echat.model.*;
import com.czy.echat.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 *登录和注册的控制器
 */
@Controller
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserService userService; //用户service类
    @Autowired
    private SimpMessagingTemplate messagingTemplate; //消息模板
    @Autowired
    private ParticipantRepository participantRepository; //在线用户存储

    private static final String SUBSCRIBE_LOGIN_URI = "/topic/login"; //订阅的登录地址

    /**
     * 反馈前端ajax登录的消息
     * @param user
     * @return
     */
    @RequestMapping(value = "/reply/login", method = RequestMethod.POST)
    @ResponseBody
    public ReplyLoginMessage replayLoginMessage(@RequestBody User user){
        if (user.getName() == null || user.getName().trim().equals("")
                || user.getPassword() == null || user.getPassword().equals("")){
            return new ReplyLoginMessage(false, ReplyLoginMessage.USER_NAME_OR_PASSWORD_NULL);
        }
        boolean isExist = userService.isExistUser(user.getName());
        if (!isExist){
            return new ReplyLoginMessage(false, ReplyLoginMessage.USER_NAME_NOT_EXIST);
        }
        User res = userService.validateUserPassword(user.getName(), user.getPassword());
        if (res == null){
            return new ReplyLoginMessage(false, ReplyLoginMessage.USER_PASSWORD_WRONG);
        }
        return new ReplyLoginMessage(true);
    }

    /**
     * 反馈前端ajax注册的消息
     * @param user
     * @return
     */
    @RequestMapping(value = "/reply/regist", method = RequestMethod.POST)
    @ResponseBody
    public ReplyRegistMessage replyRegistMessage(@RequestBody User user){
        boolean isExist = userService.isExistUser(user.getName());
        if (isExist){
            return new ReplyRegistMessage(false, ReplyRegistMessage.USER_NAME_EXIST);
        }
        if (user.getPassword() != null){
            userService.insertUser(user.getName(), user.getPassword());
        }
        return new ReplyRegistMessage(true);
    }

    /**
     * 登录进入聊天室
     * @param user
     * @param request
     * @return
     */
    @RequestMapping(value = "/chat", method = RequestMethod.POST)
    public String loginIntoChatRoom(User user, HttpServletRequest request, Model model){
        user = userService.validateUserPassword(user.getName(), user.getPassword());
        if (user == null){
            return "login";
        }
        user.setLoginDate(new Date());
        user.setPassword(null);  //设空防止泄露给其他用户
        model.addAttribute("userName",user.getName());
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        //保存登陆信息
        LoginInfoDo loginInfo = LoginInfoDo.builder().userId(user.getId()).userName(user.getName()).
                status(LoginTypeEnum.LOGIN.getCode()).createTime(new Date()).build();
        userService.addUserLoginInfo(loginInfo);

        messagingTemplate.convertAndSend(SUBSCRIBE_LOGIN_URI, user);
        participantRepository.add(user.getName(), user);
        logger.info(user.getLoginDate() + ", " + user.getName() + " login.");
        return "chatroom";
    }

    /**
     * 登录页面
     * @return
     */
    @RequestMapping(value = {"/", "/index", ""}, method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    /**
     * 返回当前在线人数
     * @return
     */
    @SubscribeMapping("/chat/participants")
    public Long getActiveUserNumber(){
        return Long.valueOf(participantRepository.getActiveSessions().values().size());
    }
}
