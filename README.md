# gxyu_springmvc_mybatis
a SSM web project developed in Myeclipse2015. 
包含学习SSM框架的基本知识点

一、环境配置说明：<br>
JDK 1.8<br>
spring 4.0<br>
mybatis 3.2<br>
Tomcat 7.0<br>
mysql 5.0<br>
暂未使用maven来管理jar包，jar包放在WEB-INF\lib中，myeclipse自动将该目录下jar文件build path到web APP library<br>
    
<br>
二、功能介绍<br>
商品查询，修改，删除<br>
数据校验<br>
参数绑定的格式转换<br>
异常处理<br>
图片上传<br>
json数据交互<br>
restful支持<br>
拦截器认证用户登录<br>
    
<br>
三、组织结构<br>
持久层：mapper开发dao，po<br>
业务层：service定义接口，service.imp<br>
表现层：controller控制器；controller.converter前后端交互，参数格式转换；controller.validation数据校验，定义检验组规则<br>
全局：exception异常控制，interceptor拦截器<br>
