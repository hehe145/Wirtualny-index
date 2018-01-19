<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Patryk
  Date: 16.01.2018
  Time: 12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Moje konto</title>
    <jsp:include page="shared/linki.jsp"></jsp:include>
</head>
<body>
<c:import url="shared/header.jsp">
    <c:param name="link" value="mojeKonto"></c:param>
</c:import>

<div class="container">
    <div class="col-md-12">

        <c:if test="${param.directionOk != null}">
            <div class="alert alert-success alert-dismissable fade in">
                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                <strong>Success!</strong>Gratulacje zostałeś zarejestrowany na studia
            </div>
        </c:if>
        <c:if test="${param.saved != null}">
            <div class="alert alert-danger alert-dismissable fade in">
                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                <strong>Danger!</strong>Jesteś już zarejestrowany na ten kierunek
            </div>
        </c:if>

        Witaj w Internetowej Rejestracji Kandydatów
        <hr/>
        <div class="col-md-8">
            <strong><p>Moje dane :</p></strong>
            <p>${user.name} ${user.surname} (PESEL:) ${user.pesel}</p>
            <p><strong>Obsluga hasła: </strong></p>
            <p>
            <p><a href="/dziennik/haslo">Zmień hasło</a></p></p>
            <p>Zarejestrowany jesteś na:</p>
            <p>
                <c:choose>
                <c:when test="${user.directions != null}">
            <ul>
                <c:forEach items="${user.directions}" var="it">
                    <li>${it.name} ${it.directionTypes.name}</li>
                </c:forEach>
            </ul>
            </c:when>
            <c:otherwise>
                <p>
                    Aktulanie nie jesteś zapisany na żaden kierunk
                </p>
            </c:otherwise>
            </c:choose>
            </p>
            <p>
                <c:choose>
                    <c:when test="${not empty user.photoName}">
                        <img src="/images/${user.photoName}" class="img-rounded" alt="${user.photoName}" width="304"
                             height="236">
                    </c:when>
                    <c:otherwise>
                        Brak zdjęcia
                    </c:otherwise>
                </c:choose>
            </p>

        </div>
        <div class="col-md-4">
            <div class="topRejestracja">
                Rejestracja krok po kroku
            </div>
            <ol>
                <li ${ empty user.photoName ? 'class="error"' : 'class="ok"'}   >
                    <a href="/dziennik/addPhoto">Dodaj zdjęcie</a>
                </li>
                <li ${ empty user.directions ? 'class="error"' : 'class="ok"'}   >
                    <a href="/dziennik/directions">Wybierz kierunek studiów</a>
                </li>
            </ol>
            <div class="bootomRejestracja">
                Wypełnij wszystkie dane
            </div>
        </div>
    </div>
</div>

<jsp:include page="shared/footer.jsp"></jsp:include>
</body>
</html>
