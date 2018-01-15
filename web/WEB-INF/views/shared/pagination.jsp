<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url var="prevPageUrl" value="/?page=${page.number - 1}&size=${page.size}"/>
<c:url var="nextPageUrl" value="/?page=${page.number + 1}&size=${page.size}"/>
<c:url var="firstPage" value="/?page=${0}&size=${page.size}"/>
<c:url var="lastPage" value="/?page=${page.totalPages-1}&size=${page.size}"/>

<ul class="pagination">
    <li ${page.first ? 'class="disabled"' : ''}>
        <a href="${page.first ? '#' : firstPage }">
            First
        </a>
    </li>
    <li ${page.first?'class="disabled"':''}>
        <a href="${page.first?'#':prevPageUrl}">
            <span>&laquo;</span>
        </a>
    </li>

    <c:forEach var="pageIdx" begin="${0}" end="${page.totalPages-1}">
        <c:url var="pageUrl" value="/?page=${pageIdx}&size=${page.size}"/>
        <li ${pageIdx == page.number?'class="active"':''}>
            <a href="${pageUrl}">${pageIdx+1}</a>
        </li>
    </c:forEach>

    <li ${page.last?'class="disabled"':''}>
        <a href="${page.last?'#':nextPageUrl}">
            <span>&raquo;</span>
        </a>
    </li>
    <li ${page.last ? 'class="disabled"' : ''}>
        <a href="${page.last ? '#' : lastPage }">
            Last
        </a>
    </li>
</ul>
<ul class="pagination pagination" style="float: right">
    <c:set var="pageSizes" value="${[3,6,20]}"/>
    <c:forEach var="size" items="${pageSizes}">
        <c:url var="pageUrl" value="/?page=${0}&size=${size}"/>
        <li ${page.size eq size?'class="active"':''}><a href="${pageUrl}"><span>${size}</span></a></li>
    </c:forEach>
</ul>
