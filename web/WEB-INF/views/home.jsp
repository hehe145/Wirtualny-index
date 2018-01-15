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
</div>

<div class="container">

</div>
<c:import url="shared/footer.jsp">
</c:import>
</body>
</html>
