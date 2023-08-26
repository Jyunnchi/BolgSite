## 1.分析需求

1.实现用户的登录注册功能  
2.写文章，发表文章  
3.收藏文章，点赞文章，评论文章  
4.关注用户  

## 2.数据库的实现

1.用户表：用户id，用户名，密码，昵称，注册时间。  
2.关注表：关注表id，被关注的人，关注的人  
3.文章表：文章id，用户id，标题，文章内容，发表时间，点赞数，收藏数，评论数  
4.评论表：评论id，文章id，用户id，评论时间，点赞数，内容  
5.用户收藏表：收藏id，文章id，用户id，收藏时间  

## 3.遇到的问题：
1. 注册用户时，post请求报404错误，无法成功： 
    问题原因：启动类位置放错了。
    解决方法：将原本的BlogApplication启动类从blog包中取出作为单独的文件。  

2. 注册用户时，post请求报415错误，无法成功：
    问题原因：前端传入的数据格式与后端不同。后端接口没有加RequestBody，则默认传入数据为json 而不是 xx-www-form-urlencoded 格式。前端axios采用的是默认请求头，则传入的数据格式为xx-www-form-urlencoded格式。  
    解决方法：将前端表单数据转化为json对象再传入后端或在后端接口加上RequstBody

3. 注册用户时，post请求报406错误，无法成功：
    问题原因：自定义了axios请求返回类Result，但是忘记添加setter方法和getter方法，导致前端无法获取到result。  
    解决方法：给Result类添加@Data注解

4. 登录用户时，get请求报500错误，无法成功：
    问题原因：后端根据用户名在数据库中查询用户时，同用户名的记录不止一个，与返回值类型冲突。
    解决方法：在注册时增加约束，使同用户名不得重复注册。删除多余用户。

5. 登录用户时，拦截器无效：
    问题原因：启动类的bean扫描没有扫描到拦截器包。
    解决方法：在启动类上增加注解   

         @ComponentScan(basePackages={"com.wrz.*"})
6. 文章显示时要求按时间顺序倒叙排列
    解决方法：后端调用Collections.reverse()方法

7. 倒叙后页面序号和数组索引不一致
    解决方法：遍历得到数组,找到aid相同的文章
8. 根据得到的uid用post请求获取user时，无法成功
    问题原因：post传递的参数格式不正确。
    解决方法：采用键值对，param=new UrlSeachParam,然后把”uid“=uid传入。
9. 删除文章时由于有外键约束，无法成功删除：
    解决方法： set foreign_key_checks=0;执行; set foreign_key_checks=1;
10. mybatis xml实行多条sql语句
    在application.yml文件中的数据库链接url后面加上?useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true
11. 根据评论的uid无法返回对应的users
    问题原因：传递的参数不匹配，这里传递的是json对象
    解决办法：后端加上RequestBody注解
12. html使用commenter对象时报TypeError: Cannot read properties of undefined (reading 'uid')错误
    问题原因：异步请求获取数据时，由于数据时异步获取的，所以一开始是没有该数据属性
    解决办法：提前定义好有相应属性的空对象