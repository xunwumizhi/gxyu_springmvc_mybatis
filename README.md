# gxyu_springmvc_mybatis
a SSM web project developed in Myeclipse2015. 
包含学习SSM框架的基本知识点

一、环境配置说明：
    JDK 1.8
    spring 4.0
    mybatis 3.2
    Tomcat 7.0
    暂未使用maven来管理jar包，jar包放在WEB-INF\lib中，myeclipse自动将该目录下jar文件build path到web APP library
    
    
二、功能介绍
    商品查询，修改，删除
    数据校验
    参数绑定的格式转换
    异常处理
    图片上传
    json数据交互
    restful支持
    拦截器认证用户登录
    
    
三、组织结构
持久层：mapper开发dao，po
业务层：service定义接口，service.imp
表现层：controller控制器；controller.converter前后端交互，参数格式转换；controller.validation数据校验，定义检验组规则
全局：exception异常控制，interceptor拦截器
