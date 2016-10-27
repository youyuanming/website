# website
-----------------------------------
## 项目简介
1. 项目使用是基于spring boot进行快速构建
2. 权限管理集成了框架shiro,项目中已经配置好登录验证和权限验证的功能,自定义权限请看代码
3. 项目中session可使用redis替带管理,项目中已经配置好,只要放开代码redis注释即可
4. 项目中使用的mybatis
5. 前端框架页面使用了adminATL,具体使用文档可看官网说明
6. 项目功能和使用说明会持续更新


###
初始化sql脚本
###
```sql
CREATE TABLE db.user_info (
  id INT NOT NULL AUTO_INCREMENT,
  user_name VARCHAR(45) NOT NULL COMMENT '用户名',
  password VARCHAR(45) NOT NULL COMMENT '密码',
  is_delete CHAR(1) NOT NULL DEFAULT 0 COMMENT '是否删除0否 1是',
  mobile_phone VARCHAR(20) NULL COMMENT '移动电话',
  PRIMARY KEY (id),
  UNIQUE INDEX user_name_UNIQUE (user_name ASC))
DEFAULT CHARACTER SET = utf8;
```

###
```sql
INSERT INTO db.user_info (user_name, password) VALUES ('admin', 'admin');
```