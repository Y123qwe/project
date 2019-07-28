<%@ page import="com.yang.servlet.vo.UserInfo" %>
<%@ page import="com.yang.servlet.ELservlet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>测试EL表达式 </title>
</head>
<body>

<h1>测试EL表达式</h1><br>
<p/>
<li>普通字符串测试</li><br>
strKey: <%= request.getAttribute("strKey")  %> </br>
strKey1(EL):${requestScope.strKey} <br>
strKey2(EL):${strKey}<br>
strKey3(EL):${pageScope.strKey}<br>
<li>结构体测试</li><br>
UserInfo(EL):<br>${requestScope.userInfoKey.username}
${requestScope.userInfoKey.group.gName}

<li>数组测试</li><br>
strArray (EL)</br>
String:${requestScope.strKey[0]}<br>
String:${requestScope.strKey[1]}<br>
String:${requestScope.strKey[2]}<br>
String:${requestScope.strKey[3]}<br>
<li>自定义数组测试</li><br>
userInfo[0]:${requestScope.userInfoKey1[0]}<br>
userInfo[1]:${requestScope.userInfoKey1[1]}<br>
userInfo[2]:${requestScope.userInfoKey1[2]}<br>
userInfo[3]:${requestScope.userInfoKey1[3]}<br>
userInfo[4]:${requestScope.userInfoKey1[4]}<br>
</body>
</html>

