<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Patryk
  Date: 20.01.2018
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Zarejestrowani</title>
    <jsp:include page="shared/linki.jsp"></jsp:include>
</head>
<body>
<c:import url="shared/header.jsp">
    <c:param name="link" value="registrated"></c:param>
</c:import>

<div class="container">
    <c:choose>
        <c:when test="${not empty users}">
            <table class="table">
                <thead class="thead-dark">
                <tr>
                    <th scope="col">Imie</th>
                    <th scope="col">Nazwisko</th>
                    <th scope="col">Adres</th>
                    <th scope="col">Kierunek</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${users}" var="us">
                    <c:if test="${not empty us.directions}">
                        <tr>
                            <td>${us.name} </td>
                            <td>${us.surname}</td>
                            <td>${us.ulica} ${us.nrDomu} ${us.miejscowosc}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${not empty us.directions}">
                                        <c:forEach items="${us.directions}" var="di">
                                            <ul>
                                                <li>${di.name} ${di.directionTypes.name}</li>
                                            </ul>
                                        </c:forEach>
                                    </c:when>
                                    <c:otherwise>
                                        Obecnie nie jesteś zarejestrowany
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td>
                                <a href="/dziennik/deleteUser/${us.id}" class="btn btn-info" data-toggle="tooltip"
                                   title="Kliknij aby skasować">x</a>
                            </td>
                        </tr>
                    </c:if>
                </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            Nikogo nie ma
        </c:otherwise>
    </c:choose>
</div>

<c:import url="shared/footer.jsp"></c:import>
</body>
</html>
