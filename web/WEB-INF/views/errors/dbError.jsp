<%--
  Created by IntelliJ IDEA.
  User: Patryk
  Date: 09.12.2017
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <jsp:include page="../shared/linki.jsp"></jsp:include>
<body>
<c:import url="../shared/header.jsp">
    <c:param name="link" value="home"></c:param>
</c:import>

<div class="container">
    <div class="alert alert-danger">
       Błąd dostepu do bazy danych
    </div>
</div>
<c:import url="../shared/footer.jsp"/>
</body>
</html>
