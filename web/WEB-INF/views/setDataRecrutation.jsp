<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Patryk
  Date: 20.01.2018
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ustal liczbe dni rekrutacji</title>
    <jsp:include page="shared/linki.jsp"></jsp:include>
</head>
<body>

<div class="vertical-center">
    <div class="container">
        <form:form modelAttribute="data" action="/dziennik/setRecrutationDays">
            <form:label path="date">Ustal ilość dni rekrutacji</form:label> <br />
            <form:input path="date" cssClass="form-control" type="date"/> <br />
            <input type="submit" class="btn btn-block btn-success"  value="Dodaj"/>
        </form:form>
    </div>
</div>

</body>
</html>
