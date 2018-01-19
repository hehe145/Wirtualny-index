<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Patryk
  Date: 15.01.2018
  Time: 19:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Zmiana hasła</title>
    <jsp:include page="shared/linki.jsp"></jsp:include>
</head>
<body>

<div class="vertical-center">
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
                    Podaj pesel: <br />
                    <form:input path="pesel" required="true" placeholder="Podaj swój pesel" cssClass="form-control"></form:input>
                </div>
                <div class="form-group">
                    Podaj swój email: <br />
                    <form:input path="email" required="true" placeholder="Podaj swój email" cssClass="form-control" type="email"></form:input>
                </div>
                <div class="form-group">
                    <input type="submit" class="btn btn-block btn-success" value="Przypomnij"/>
                </div>
            </form:form>
            <a href="/login" class="glyphicon glyphicon-hand-left"> Wstecz </a>
        </div>
    </div>
</div>

</body>
</html>
