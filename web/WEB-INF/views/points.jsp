<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--
  Created by IntelliJ IDEA.
  User: Patryk
  Date: 20.01.2018
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form modelAttribute="points" action="/dziennik/points">
    <form:input path="JAngielski"></form:input>
    <form:input path="matematyka"></form:input>
    <input type="submit" value="Dodaj"/>
</form:form>
</body>
</html>
