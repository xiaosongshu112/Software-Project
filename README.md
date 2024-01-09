# Software-Project
  这是一个使用java语言来编写的学生信息管理系统，前端使用Vue，后端使用Spring boot，前后端分离。

### 前端Vue.js

- ElementUI
- axios

### 后端SpringBoot

- 持久层: Mybatis Plus

### 数据库
 
- MySQL 8.0.35

使用命令克隆项目
````bash
git clone https://github.com/xiaosongshu112/Software-Project.git
````
`StudentSystem_back`是后端项目

`StudentSystem_front`是前端项目

`student_system.sql`是数据库配置

后端导入项目在Maven中选择Eexisting Maven Projects，之后选择StudentStStem_back路径。
项目右键打开运行方式选中Maven build，等待完成之后打开运行方式选中Spring Boot App。
后端配置完成

数据库则是将 student_system.sql 移进mysql数据库管理应用中运行脚本即启动完成

前端可在StudentSystem_front路径的cmd中配置，输入cnpm install 等待依赖安装完成，
之后输入npm run serve，当出现网址时即启动完成

最后根据前端cmd的网址在浏览器中打开即项目启动完成
