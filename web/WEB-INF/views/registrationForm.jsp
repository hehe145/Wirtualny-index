<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Patryk
  Date: 10.12.2017
  Time: 12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rejestracja</title>
    <jsp:include page="shared/linki.jsp"></jsp:include>
</head>
<body>
<c:import url="shared/header.jsp">
    <c:param name="link" value="reg"></c:param>
</c:import>

<div class="container">

    <c:if test="${param.badPassword != null}">
        <div class="alert alert-danger">
            Podane hasła są błędne lub taki użytkownik istnieje w bazie
        </div>
    </c:if>

    <div class="row">
        <div class="col-md-offset-3 col-md-5">
            <div class="text-center"><h1>Proszę, zarejestruj się</h1></div>

            <form:form modelAttribute="user" method="post">
                <div class="form-group">
                    <form:errors path="name" class="error"></form:errors> <br/>
                    Imię: <form:input path="name" cssClass="form-control"></form:input>
                </div>
                <div class="form-group">
                    <form:errors path="surname" class="error"></form:errors> <br/>
                    Nazwisko: <form:input path="surname" cssClass="form-control"></form:input>
                </div>
                <div class="form-group">
                    <form:errors path="dateOfBirth" class="error"></form:errors> <br/>
                    Podaj datę urodzenia
                    <form:input path="dateOfBirth" cssClass="form-control" type="date"></form:input>
                </div>
                <div class="form-group">
                    <form:errors path="pesel" class="error"></form:errors> <br/>
                    Podaj pesel:
                    <form:input path="pesel" cssClass="form-control"></form:input>
                </div>
                <div class="form-group">
                    <form:errors path="phoneNumber" class="error"></form:errors><br/>
                    Podaj numer telefonu
                    <form:input path="phoneNumber" cssClass="form-control"></form:input>
                </div>
                <div class="form-group">
                    <form:errors path="password" class="error"></form:errors><br/>
                    Podaj hasło
                    <form:input path="password" type="password" cssClass="form-control"></form:input>
                </div>
                <div class="form-group">
                    <form:errors path="passwordConfirm" class="error"></form:errors><br/>
                    Powtórz hasło
                    <form:input path="passwordConfirm" type="password" cssClass="form-control"></form:input>
                </div>
                <div class="form-group">
                    <form:errors path="country.id" class="error"></form:errors> <br/>
                    Wybierz kraj zamieszkania:
                    <form:select path="country.id" cssClass="form-control">
                        <form:option value="-1">--Wybierz kraj--</form:option>
                        <form:options items="${country}" itemLabel="countryName" itemValue="id"/>
                    </form:select>
                </div>
                <div class="form-group">
                    <form:errors path="email" class="error"></form:errors> <br/>
                    Podaj email:
                    <form:input path="email" type="email" cssClass="form-control" />
                </div>
                <div class="form-group">
                    <form:errors path="ulica" class="error"></form:errors> <br/>
                    Podaj Ulice:
                    <form:input path="ulica"  cssClass="form-control" />
                </div>
                <div class="form-group">
                    <form:errors path="nrDomu" class="error"></form:errors> <br/>
                    Podaj nr domu lokalu:
                    <form:input path="nrDomu"  cssClass="form-control" />
                </div>
                <div class="form-group">
                    <form:errors path="miejscowosc" class="error"></form:errors> <br/>
                    Podaj miejscowość:
                    <form:input path="miejscowosc"  cssClass="form-control" />
                </div>
                <input type="submit" class="btn btn-block btn-success" value="Zarejestruj"/>
            </form:form>

        </div>
    </div>
</div>
<c:import url="shared/footer.jsp"></c:import>
</body>
</html>
