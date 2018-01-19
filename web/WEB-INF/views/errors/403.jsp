<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Patryk
  Date: 08.12.2017
  Time: 22:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
    <jsp:include page="../shared/linki.jsp"></jsp:include>
</head>
<body>
<c:import url="../shared/header.jsp">
    <c:param name="link" value="addForm"></c:param>
</c:import>
<div class="container">
    <div class="alert alert-danger">
        Nie posiadasz odpowiednich uprawień
    </div>
</div>
<c:import url="../shared/footer.jsp"></c:import>
</body>
</html>
