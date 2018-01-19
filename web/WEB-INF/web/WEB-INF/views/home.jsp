<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Dziennik elektroniczny</title>
    <c:import url="shared/linki.jsp"/>
</head>

<body>
<c:import url="shared/header.jsp">
    <c:param name="link" value="home"></c:param>
</c:import>

<div class="container">

    <c:if test="${param.reg != null}">
        <div class="alert alert-success alert-dismissable">
            <a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
            <strong>Success!</strong> Zostałeś poprawnie zarejestrowany
        </div>
    </c:if>

    <c:if test="${page.totalElements > 0}">
        <jsp:include page="shared/pagination.jsp"></jsp:include>
    </c:if>

    <div class="col-md-6 col-md-offset-2">
        <p>Miejsce składania dokumentów:</p>
        <ul>
            <li class="kierunek"><strong>kierunek informatyka -</strong> ul. 3 Maja 54, drugie piętro, pok. nr 233,
                budynek Wydziału Nauk Ścisłych,
            </li>
        </ul>

    </div>
</div>
<c:import url="shared/footer.jsp">
</c:import>
</body>
</html>
