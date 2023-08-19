# online-judge-backend
1. `内容简介` 这是基于 SpringBoot的OJ项目后端(支持Java与MySql判题) 
2. `环境准备` JDK17(也许8也行) + MySQL8.0 + Redis
3. `项目文档` https://github.com/Luyabs/online-judge-backend/blob/master/%E9%A1%B9%E7%9B%AE%E6%96%87%E6%A1%A3.pdf
4. `启动须知` 启动前需要在src/main/resources添加配置文件application-dev.yaml，并对下面用中文描述的内容做修改：
```yaml
server:
  port: 8080

spring:
  datasource:
    primary:
      url: jdbc:mysql://你的MYSQL IP地址/用到的数据库名
      username: 用户名
      password: 密码
    secondary: # 用于OJ 不得和primary使用同一张表
      url: jdbc:mysql://你的MYSQL IP地址/用到的数据库名 
      username: 用户名(你需要确保这个用户只有这个数据库的管理权限)
      password: 密码
  redis:
    host: 你的Redis IP地址
    port: 你的Redis 服务端口
    database: 0
    password: 你的Redis 密码


sa-token:
  # jwt秘钥 随便填一串字符串
  jwt-secret-key: waa65123acbas4bn54634kqaf8706j

```
### [请阅读我们的项目文档以获取更多信息](https://github.com/Luyabs/online-judge-backend/blob/master/%E9%A1%B9%E7%9B%AE%E6%96%87%E6%A1%A3.pdf)
