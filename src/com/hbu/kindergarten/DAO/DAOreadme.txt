DAO层的作用是访问数据库 响应的增删改查操作
data.properties是数据的连接信息
返回值是一个model对象(查询) 或者 boolean(增删改)
命名规则是"表名"+"DAO" 表名首字母大写
比如user表对应的就是UserDAO
注意一个DAO只能对一个表进行增删改查（有关联关系除外）

