Servlet层主要是控制层
负责控制页面的跳转以及数据的传递
只能访问Service层 一个Servlet可以包含多个Service
注意使用Service的时候要单例访问 可参看UserServlet


开发：
Servlet使用注解开发 比如@WebServlet(name="login",urlPatterns="/login")
其中name是Servlet的名称 自定义，urlPatterns是访问路径 一定要注意 访问路径的命名规则 
比如添加幼儿园可以是/kindergarten/add
修改可以是/kindergarten/update

添加教师是/teacher/add
修改教师是/teacher/update

这样权限就可以设置为/kindergarten*和/teacher*




