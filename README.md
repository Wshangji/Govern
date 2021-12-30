# Govern
## 简介

Govern智能家居管理系统（Demo）版，web 服务端采用spring boot，前端使用Vue框架，前后端分离，移动端使用uniapp跨平台解决方案

## 项目架构说明

传感器获取数据（以DHT22为例），通过上位机（树莓派4b）使用python脚本发送数据至云端数据库中（MySQL8.0），web后端提供访问接口，供前端调用，实现前后端分离，uniapp跨平台开发方式，实现各移动端进行交互操作，用户操作指令通过后端发送到下位机（树莓派4b），实现相应的指令操作

## 技术栈说明

### 后端技术：

- spring boot
- spring security
- JWT
- Swagger2
- Mybatis plus

### 前端技术：

- vue
- Element UI
- axio
- vue-router
- vuex

### 硬件平台：

- 树莓派4b
- Am2302(DHT22)

### 移动端平台：

- uniapp
- Ant Design Mobile

### 数据库模型图：

[![TRIe8H.jpg](https://s4.ax1x.com/2021/12/30/TRIe8H.jpg)](https://imgtu.com/i/TRIe8H)

------

更新日志：

- 2021/12/25 初始化spring boot项目脚手架，初始化vue项目脚手架
- 2021/12/26 设计数据库表结构，创建数据库，解决前后端跨域问题，配置树莓派环境
- 2021/12/27 引入Security，实现登录角色权限管理，开发vue登录注册页面
- 2021/12/28 出现严重bug，项目回滚并且更新架构，开发树莓派数据获取功能
- 2021/12/29 继承swagger2接口文档系统，实现vue管理主界面
- 2021/12/30 由于国内vuetify参考文档较少，更换前端UI为Element UI

