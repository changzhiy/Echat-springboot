#创建数据库
CREATE database echat;

use echat;
#创建用户表
CREATE TABLE user(
id INT NOT NULL PRIMARY KEY auto_increment comment'用户id',
name VARCHAR(100) comment'用户名',
password VARCHAR(100) comment'用户密码'
)ENGINE = innoDB CHARSET = utf8;

#登陆登出信息表
CREATE TABLE login_info (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NULL,
  `user_name` VARCHAR(45) NULL,
  `status` TINYINT NULL COMMENT'1.上线，2.下线',
  `create_time` DATETIME NULL,
  PRIMARY KEY (`id`)) default charset = utf8;

#聊天内容表
CREATE TABLE message_record (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NULL,
  `user_name` VARCHAR(45) NULL,
  `message_type` TINYINT NULL COMMENT'1.文本， 2.图片',
  `content` VARCHAR(256) NULL,
  `create_time` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))default charset = utf8;