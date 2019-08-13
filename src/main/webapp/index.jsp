<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<h2>Hello World!</h2>

<form action="/login/doLogin" method="post" >
    <input type="text" name="userId" placeholder="用户名"/>
    <input type="text" name="password" placeholder="密码"/>
    <input type="submit" value="登录"/>
</form>
</body>
</html>
