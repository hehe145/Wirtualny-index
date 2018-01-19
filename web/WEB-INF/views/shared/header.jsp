<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
    <nav class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
            <!-- Grupowanie "marki" i przycisku rozwijania mobilnego menu -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>

            </div>

            <!-- Grupowanie elementów menu w celu lepszego wyświetlania na urządzeniach moblinych -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li ${param.link eq 'home' ? 'class="active"' : ''}>
                        <a href="<c:url value="/"></c:url> ">Home</a></li>

                    <sec:authorize access="!isAuthenticated()">
                        <li ${param.link eq 'reg' ? 'class="active"' : ''}>
                            <a href="<c:url value="/dziennik/reg" />"> Rejstracja </a>
                        </li>
                    </sec:authorize>

                    <sec:authorize access="isAuthenticated()">
                       <li ${param.link eq 'mojeKonto' ? 'class="active"' : ''}>
                           <a href="<c:url value="/dziennik/mojeKonto" /> ">Moje konto</a>
                       </li>
                    </sec:authorize>
                </ul>

                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                        <sec:authorize access="!isAuthenticated()">
                    <li ${param.link eq 'loguj' ? 'class="active"' : ''}><a
                            href="<c:url value="/login"/>">Zaloguj</a></li>
                    </sec:authorize>
                    <sec:authorize access="isAuthenticated()">
                        <sec:authentication var="principal" property="principal"/>
                        <li><a href="#"><strong> Witaj, ${principal.username} </strong> </a></li>

                        <li>
                            <a onclick="document.getElementById('logout').submit()">Wyloguj się</a>
                            <form action="/logout" id="logout" method="post" style="display: none;">
                                <sec:csrfInput/>
                            </form>
                        </li>
                    </sec:authorize>
                    </li>
                </ul>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>
</div>