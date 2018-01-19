<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<%@page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../shared/linki.jsp"></jsp:include>
</head>
<body>
<c:import url="../shared/header.jsp">
    <c:param name="link" value="home"></c:param>
</c:import>

<div class="container">
    <div class="alert alert-danger">
        Zrobiłeś BadRequest
    </div>
</div>
<c:import url="../shared/footer.jsp"/>
</html>
