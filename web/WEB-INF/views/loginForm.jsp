<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Patryk
  Date: 09.12.2017
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <jsp:include page="shared/linki.jsp"/>
</head>

<body>

<c:import url="shared/header.jsp">
    <c:param name="link" value="loguj"></c:param>
    <c:param name="count" value="${cookies}"></c:param>
</c:import>

<div class="container">
    <div class="row">
        <div class="col-md-offset-3 col-md-5 ">
            <c:if test="${param.newPassword != null}">
                <div class="alert alert-success fade in">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <strong>Success!</strong> Twoje hasło zostało zmienione sprawdź swój emial
                </div>
            </c:if>
            <form action="/login" method="post">
                <c:if test="${param.error != null}">
                    <div class="alert alert-danger fade in">
                        <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                        <strong>Error!</strong> Błędny login lub hasło
                    </div>
                </c:if>
                PESEL:
                <input type='text' name='username' class="form-control"><br>
                Password:
                <input type='password' class="form-control" name='password'/><br>
                <security:csrfInput/>
                <input name="submit" type="submit" value="Zaloguj się" class="form-control"/>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>

            <p> Nie pamiętasz hasła: <a href="/dziennik/password">Przypomnij</a></p>
            <p> Nie masz konta: <a href="/dziennik/reg">Zarejestruj się</a></p>

        </div>
    </div>
</div>

<c:import url="shared/footer.jsp"></c:import>

</body>
</html>
