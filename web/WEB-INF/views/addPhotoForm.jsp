<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Patryk
  Date: 18.01.2018
  Time: 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dodaj zdjęcie</title>
    <jsp:include page="shared/linki.jsp"></jsp:include>
</head>
<body>
<c:import url="shared/header.jsp">
    <c:param name="link" value="mojeKonto"></c:param>
</c:import>

<div class="container">
    <c:if test="${param.photoEmpty != null}">
        <div class="alert alert-danger alert-dismissable fade in">
            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
            <strong>Uwaga!</strong> Nie wybrałeś zdjęcia
        </div>
    </c:if>
    <span>
        <div class="col-md-2">
            Wybierz zdjęcie
        </div>
        <div class="col-md-5">
            <form:form modelAttribute="photo">
                <form:input path="photoName" type="file" cssClass="form-control"></form:input>

                <input type="submit" class="btn btn-block btn-success" value="Wyślij" />
            </form:form>
        </div>
    </span>

    <div class="col-md-12">
        <strong> Uwagi techniczne: </strong>
        <ul>
            <li>Zdjęcia powinny być dobrej jakości (wyraźne, o prawidłowej jasności, kontraście i kolorystyce).</li>
            <li>Preferowane jest zdjęcie w formacie JPG o wymiarach 400 x 500 pikseli, co pozwala na wydrukowanie
                zdjęcia w rozmiarze 2 cm * 2,5
            </li>
        </ul>
    </div>

</div>


<c:import url="shared/footer.jsp"></c:import>
</body>
</html>
