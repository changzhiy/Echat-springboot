$(function () {
    /**
     * 登录按钮点击事件
     */
    $("#loginBtn").click(function () {
        console.log("into click loginBtn");
        var replyUrl = $("#replayLoginUrl").val().trim();
        var username = $("#u").val().trim();
        var password = $("#p").val().trim();
        if (username.length == 0 || password.length == 0) {
            sweetAlert("哎呦…出错了…", "用户名或密码为空，请填写！", "error");
            return;
        }
        /**
         * 返回data类型
         * {successed ： true | false} 登录是否成功
         * {errStatus : 1 |　2 | 3} 当successed为false会有errStatus错误状态信息
         * 其中 1：该用户名还没有注册
         *     2：密码错误
         *     3：用户名或者密码为空（防止第三方插件登录）
         */
        $.ajax({
            type: "POST",
            url: replyUrl,
            data: JSON.stringify({'name': username, 'password': password}),
            dataType: "json",
            contentType: "application/json",
            success: function (data) {
                console.log(data);
                var successed = data.successed;
                if (successed) {
                    $("#login_form").submit();
                } else {
                    var errStatus = data.errStatus;
                    if (errStatus == 1) {
                        sweetAlert("哎呦…出错了…", "该用户名尚未注册，请前往注册~", "error");
                        return;
                    } else if (errStatus == 2) {
                        sweetAlert("哎呦…出错了…", "密码错误！请重新填写~", "error");
                        $("#p").focus();
                    } else if (errStatus == 3) {
                        sweetAlert("哎呦…出错了…", "用户名或密码未填写~", "error");
                        returne
                    } else {
                        sweetAlert("哎呦…出错了…", "服务器出现未知错误~", "error");
                        return;
                    }
                }
            }
        });
    });


    /**
     * 用户名输入框失去焦点事件，ajax判断是否该名称已经被注册
     */
    $("#user").blur(function () {
        var userName = $("#user").val().trim();
        var sendData = JSON.stringify({'name': userName});
        if (userName.length != 0) {
            /**
             * 返回data类型
             * {successed ： true | false} 注册是否成功
             * {errStatus : 1  } 用户名已经被注册

             */
            $.ajax({
                type: "POST",
                url: $("#replyRegistUrl").val().trim(),
                data: sendData,
                dataType: "json",
                contentType: "application/json",
                success: function (data) {
                    console.log(data);
                    if (data.successed) {
                        $('#user').css({
                            border: "1px solid #D7D7D7",
                            boxShadow: "none"
                        });
                        $("#userCue").html("欢迎注册EastChat！");
                    }else if(data.errStatus == 1){
                        $('#user').focus().css({
                            border: "1px solid red",
                            boxShadow: "0 0 2px red"
                        });
                        $('#userCue').html("<font color='red'><b>该用户名已经被注册！</b></font>");
                    }
                }
            })
        }
        $('#user').css({
            border: "1px solid #D7D7D7",
            boxShadow: "none"
        });
        $("#userCue").html("欢迎注册EastChat！");
    });

    /**
     * 注册按钮点击事件
     */
    $("#reg").click(function () {
        var userName = $("#user").val().trim();
        var pwd1 = $("#passwd").val().trim();
        var pwd2 = $("#passwd2").val().trim();
        if (userName.length == 0 || pwd1.length == 0 || pwd2.length == 0){
            sweetAlert("哎呦…出错了…", "您还有些内容未填写~", "error");
            return;
        }else if (pwd1 != pwd2){
            sweetAlert("哎呦…出错了…", "两次密码输入不一致，请重新填写~", "error");
        }else {
            var sendData = JSON.stringify({'name' : userName, 'password' : pwd1});
            $.ajax({
                type: "POST",
                url: $("#replyRegistUrl").val().trim(),
                data: sendData,
                dataType: "json",
                contentType: "application/json",
                success : function (data) {
                    if (data.successed){
                        sweetAlert("注册成功啦！", "快去登录~加入聊天吧~", "success");
                    }else {
                        sweetAlert("哎呦…出错了…", "注册失败，请再次尝试~", "error");
                    }
                }
            });
        }

    });
    $('#switch_qlogin').click(function () {
        $('#switch_login').removeClass("switch_btn_focus").addClass('switch_btn');
        $('#switch_qlogin').removeClass("switch_btn").addClass('switch_btn_focus');
        $('#switch_bottom').animate({left: '0px', width: '70px'});
        $('#qlogin').css('display', 'none');
        $('#web_qr_login').css('display', 'block');

    });
    $('#switch_login').click(function () {

        $('#switch_login').removeClass("switch_btn").addClass('switch_btn_focus');
        $('#switch_qlogin').removeClass("switch_btn_focus").addClass('switch_btn');
        $('#switch_bottom').animate({left: '154px', width: '70px'});

        $('#qlogin').css('display', 'block');
        $('#web_qr_login').css('display', 'none');
    });
    if (getParam("a") == '0') {
        $('#switch_login').trigger('click');
    }

});

function logintab() {
    scrollTo(0);
    $('#switch_qlogin').removeClass("switch_btn_focus").addClass('switch_btn');
    $('#switch_login').removeClass("switch_btn").addClass('switch_btn_focus');
    $('#switch_bottom').animate({left: '154px', width: '96px'});
    $('#qlogin').css('display', 'none');
    $('#web_qr_login').css('display', 'block');

}


//根据参数名获得该参数 pname等于想要的参数名 
function getParam(pname) {
    var params = location.search.substr(1); // 获取参数 平且去掉？ 
    var ArrParam = params.split('&');
    if (ArrParam.length == 1) {
        //只有一个参数的情况 
        return params.split('=')[1];
    }
    else {
        //多个参数参数的情况
        for (var i = 0; i < ArrParam.length; i++) {
            if (ArrParam[i].split('=')[0] == pname) {
                return ArrParam[i].split('=')[1];
            }
        }
    }
}


