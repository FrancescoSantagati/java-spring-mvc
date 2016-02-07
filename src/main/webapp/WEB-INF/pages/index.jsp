<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <jsp:include page="common/import.jsp"/>
</head>
<body>
<jsp:include page="common/header.jsp"/>
<div id="wrapper">
    <div id="main-page">

        <%--MAIN PAGE CONTENT--%>
        <div id="welcome-title">
            Benvenuto nel sito della pizzeria!
        </div>

        <div id="welcome-description">
            Realizzato da Francesco Santagati
        </div>
        <%--<div>Message : ${message}</div>--%>

        <a href="<c:url value="/pizzeria/catalogo" />"><div id="catalogo-container">
            <img id="catalogo-icon" src="<c:url value="/resources/img/menu.png" />" alt="catalogo"/>
            <div id="catalogo-label">Catalogo</div>
        </div></a>

    </div>
    <jsp:include page="common/column.jsp"/>
</div>
<jsp:include page="common/footer.jsp"/>
</body>
</html>