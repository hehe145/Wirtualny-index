<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Patryk
  Date: 18.01.2018
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Zmiana hasła</title>
    <jsp:include page="shared/linki.jsp"></jsp:include>
</head>
<body>
<c:import url="shared/header.jsp">
    <c:param name="link" value="mojeKonto"></c:param>
</c:import>

<div class="container">
    <div class="col-md-5 col-md-offset-3">
        <div class="text-center">
            <h1>Zmiana hasła</h1>
        </div>
        <c:if test="${param.badUser != null}">
            <div class="alert alert-danger fade in">
                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                <strong>Error!</strong> Taki użytkownik nie istnieje
            </div>
        </c:if>
        <form:form method="post" modelAttribute="user">
            <div class="form-group">
                Podaj nowe hasło
                <form:input type="password" path="password" cssClass="form-control" required="true"></form:input>
            </div>
            <div class="form-group">
                Powtórz hasło
                <form:input type="password" path="passwordConfirm" cssClass="form-control" required="true"></form:input>
            </div>
            <div class="form-group">
                <input type="submit" class="btn btn-block btn-success" value="Zmień"/>
            </div>
        </form:form>
        <a href="/login" class="glyphicon glyphicon-hand-left"> Wstecz </a>
    </div>
</div>

<c:import url="shared/footer.jsp"></c:import>
</body>
</html>
