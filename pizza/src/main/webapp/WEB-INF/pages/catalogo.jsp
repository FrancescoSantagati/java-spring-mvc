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

        <%--PAGE TITLE--%>
        <div class="page-title">Catalogo: Le nostre pizze</div>

        <div class="content-padding">
            <%--MAIN PAGE CONTENT--%>
            <table id="catalogo-pizze-table">
                <c:forEach items="${pizze}" var="pizza">
                    <tr>
                        <th class="catalogo-pizze-nome">${pizza.nome}</th>
                        <th class="catalogo-pizze-prezzo" rowspan="2">${pizza.prezzo} €</th>
                    </tr>
                    <tr>
                        <td class="catalogo-pizze-ingredienti">${pizza.ingredienti}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    <jsp:include page="common/column.jsp"/>
</div>
<jsp:include page="common/footer.jsp"/>
</body>
</html>