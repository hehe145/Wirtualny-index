<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: Patryk
  Date: 18.01.2018
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wybierz kierunek studiów</title>
    <jsp:include page="shared/linki.jsp"></jsp:include>
</head>
<body>
<c:import url="shared/header.jsp">
    <c:param name="link" value="mojeKonto"></c:param>
</c:import>

<div class="container">
    <div class="col-md-12">
        <c:choose>
            <c:when test="${ not empty direction }">
                <strong>Informatyka - lista dostepnych kierunków</strong>
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>Kierunek studiów</th>
                        <th>Poziom kształcenia</th>
                        <th>Forma studiów</th>
                    </tr>
                    </thead>

                    <thead>
                    <c:forEach items="${direction}" var="it">
                    <tr>
                        <td><a href="kierunek/${it.id}" data-toggle="tooltip" title="Kliknij aby się zarejestrować!"> ${it.name}, ${it.directionTypes.name}</a> </td>
                        <td>I stopień</td>
                        <td>${it.directionTypes.name}</td>
                    </tr>
                    </c:forEach>
                    </tbody>

                </table>
                <c:if test="${direction.get(0).name == 'Informatyka'}">
                    <jsp:include page="shared/informatyka.jsp" />
                </c:if>
            </c:when>
        </c:choose>
    </div>
</div>

<c:import url="shared/footer.jsp"></c:import>
</body>
</html>
