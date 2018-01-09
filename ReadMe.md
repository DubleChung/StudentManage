### 《学生管理系统 》

#### 开发环境及工具
javaee5 jdk1.6 、MyEclipse7.5 MySQL5.0

#### 登录信息
账号：admin
密码：123456

#### 数据库 
数据库脚本位置：/数据库/student_db.sql  
请自行创建数据库 student_db  
1. 管理员信息表 t_admin  
2. 学生成绩信息表 t_score  
3. 学生信息表 t_student

#
#### 文件说明
##### /src/com/stu/core 相关帮助类包  
##### /src/com/stu/dao 数据库操作包  
##### /src/com/stu/filter 网站过滤器包  
##### /src/com/stu/model 数据Bean包  
##### /src/com/stu/service  数据服务接口包  
##### /src/com/stu/servlet  Servlet包  
##### /src/DB.properties 为数据配置文件 ,根据实际情况配置数据地址及用户名密码

##### /WebRoot/bootstrap Bootstrap目前最受欢迎的前端框架
##### /WebRoot/css 公共样式文件夹
##### /WebRoot/script javascript脚本、jquery插件文件夹
##### /WebRoot/images 公共图片文件夹
##### /WebRoot/views 页面文件夹
1. 学生成绩添加页面 /WebRoot/views/add_student_score.jsp  
2. 学生注册页面 /WebRoot/views/add_student.jsp  
3. 修改登录密码页面 /WebRoot/views/changepwd.jsp  
4. 公共页脚 /WebRoot/views/footer.jsp  
5. 页面公共引用 /WebRoot/views/include_common.jsp  
6. 管理首页面 /WebRoot/views/index.jsp  
7. 公共菜单 /WebRoot/views/left.jsp  
8. 登录页面 /WebRoot/views/login.jsp  
9. 公共消息弹出部分 /WebRoot/views/message.jsp  
10. 成绩查询页面 /WebRoot/views/search_student_score.jsp  
11. 学生查询页面 /WebRoot/views/search_student.jsp  
12. 管理页头 /WebRoot/views/top.jsp  
