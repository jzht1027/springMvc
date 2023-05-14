<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/5/7 0007
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>添加用户</title>
</head>
<body>
<h1>添加用户</h1>

<form action="${pageContext.request.contextPath}/user" method="post">
    <p>
        name:<input type="text" name="name" value="${user.name}">${errorInfo.name}<br/>
    </p>
    <p>
        balance:<input type="text" name="balance" value="${user.balance}">${errorInfo.balance}<br/>
    </p>
    <p>
        birthday:<input type="text" name="birthday" value="${user.birthday}">${errorInfo.birthday}<br/>
    </p>
    <p>
        age:<input type="text" name="age" value="${user.age}">${errorInfo.age}<br/>
    </p>
    <p>
        salary:<input type="text" name="salary" >${errorInfo.salary}<br/>
    </p>
    <p>
        taskCount:<input type="text" name="taskCount" value="${user.taskCount}">${errorInfo.taskCount}<br/>
    </p>
    <p>
        hobbies:
        <input type="checkbox" name="hobbies" value="Singing">唱歌
        <input type="checkbox" name="hobbies" value="dancing">跳舞
    </p>
    <p>
        <input type="submit" value="提交">
    </p>
</form>

<%--@elvariable id="user" type="com.entity.User"--%>
<form:form action="${pageContext.request.contextPath}/form" method="post" modelAttribute="user">
    <p>
        name:<form:input path="name"></form:input><form:errors path="name"></form:errors>
    </p>
    <p>
        balance:<form:input path="balance"></form:input><form:errors path="balance"></form:errors>
    </p>
    <p>
        birthday:<form:input path="birthday"></form:input><form:errors path="birthday"></form:errors>
    </p>
    <p>
        age:<form:input path="age"></form:input><form:errors path="age"></form:errors>
    </p>
    <p>
        salary:<form:input path="salary"></form:input><form:errors path="salary"></form:errors>
    </p>
    <p>
        taskCount:<form:input path="taskCount"></form:input><form:errors path="taskCount"></form:errors>
    </p>
    <p>
        <!-- 动态获取数据源-->
        hobbies:
        <form:checkbox path="hobbies" value="Singing"></form:checkbox>
        <form:label path="hobbies">唱歌</form:label>
        <form:checkbox path="hobbies" value="dancing"></form:checkbox>
        <form:label path="hobbies">跳舞</form:label>
    <hr>
<%--        <form:checkboxes path="hobbies" items="${list}"></form:checkboxes>--%>
    <hr>
        <form:checkboxes path="hobbies" items="${map}"></form:checkboxes>
    <hr>

        <select>
            <option value="beijing">北京</option>
            <option value="shijiazhuang">石家庄</option>
        </select>
    </p>
    <p>
        <form:button>提交</form:button>
    </p>
</form:form>
</body>
</html>
