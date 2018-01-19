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
<jsp:include page="shared/header.jsp"></jsp:include>

<div class="container">
    <div class="col-md-12">
        Witaj w Internetowej Rejestracji Kandydatów
        <hr />
        <div class="col-md-8">
           <p>Moje dane :</p>
            <p>${user.name} ${user.surname} (PESEL:) ${user.pesel}</p>
            <ul>
                <li>Zmień dane</li>
                <li>Prześlij zdjęcie</li>
            </ul>
        </div>
        <div class="col-md-4">
            Rejesteacja krok po kroku
        </div>
    </div>
</div>

<jsp:include page="shared/footer.jsp"></jsp:include>
</body>
</html>
