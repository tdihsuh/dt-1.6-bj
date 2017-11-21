# 数据部接口服务

## 数据版本追溯
*   migrate里面有版本追溯的相关类


## 内置功能

*   swagger
*   轻量登录协议
*   mybatis-com.cycredit.migrate
*   mybatis-genatre
*   spring-test+junit4

## 技术选型

1、后端

* 核心框架：Spring Framework 4.3.8
* 视图框架：Spring MVC 4.3.8

## 开关注意

1.数据库版本追溯(Migrate)开关
* com.cycredit.base.init.MigrateLoader是否加载

2.Api文档(Swagger)开关
* com.cycredit.base.init.ApplicationSwaggerConfig是否加载

3.
## 打包
* mvn install -Dmaven.test.skip=true 