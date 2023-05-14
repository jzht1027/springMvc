<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/5/7 0007
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>展示页</title>
</head>

<p>
    name:${user.name}
</p>
<p>
    balance:<spring:eval expression="user.balance"></spring:eval>
</p>
<p>
<%--    显示格式化
jstl标签库 fmt:formate pattern
或者 spring标签库 <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
--%>
    birthday:<spring:eval expression="user.birthday"></spring:eval>
</p>

<p>
    age:${user.age}
</p>
<p>
    salary:<spring:eval expression="user.salary"></spring:eval>
</p>
<p>
    taskCount:<spring:eval expression="user.taskCount"></spring:eval>
</p>
<p>
    hobbies:<spring:eval expression="user.hobbies"></spring:eval>
</p>

</body>
</html>
