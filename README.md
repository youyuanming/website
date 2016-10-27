# website
-----------------------------------
spring boot+shiro+redis+jpa
###
使用spring boot 框架 权限控制使用的是shrio并使用redis控制session 数据持久化工具用的是JPA ，日后还会添加web前后分离框架，前端通过json生成页面


###
初始化sql脚本
###
`CREATE TABLE db.user_info (
  id INT NOT NULL AUTO_INCREMENT,
  user_name VARCHAR(45) NOT NULL COMMENT '用户名',
  password VARCHAR(45) NOT NULL COMMENT '密码',
  is_delete CHAR(1) NOT NULL DEFAULT 0 COMMENT '是否删除0否 1是',
  mobile_phone VARCHAR(20) NULL COMMENT '移动电话',
  PRIMARY KEY (id),
  UNIQUE INDEX user_name_UNIQUE (user_name ASC))
DEFAULT CHARACTER SET = utf8;`

###
INSERT INTO `db`.`user_info` (`user_name`, `password`) VALUES ('admin', 'admin');
