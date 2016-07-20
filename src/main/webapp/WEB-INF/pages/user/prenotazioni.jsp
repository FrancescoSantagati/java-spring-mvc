<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <jsp:include page="../common/import.jsp"/>
</head>
<body>
<jsp:include page="../common/header.jsp"/>
<div id="wrapper">
    <div id="main-page">

        <%--MAIN PAGE CONTENT--%>
        <div class="page-title">
            Le mie prenotazioni
        </div>


        <div id="prenotazione-container">
            <c:forEach items="${prenotazioni}" var="prenotazione">
                <div class="prenotazione-tile">
                    <input type="hidden" class="prenotazione-id" value="${prenotazione.id}"/>
                    <c:forEach items="${prenotazione.pizzeList}" var="pizzaEl">
                        <div class="prenotazione-pizza-el">
                            <div class="prenotazione-type-quantita">${pizzaEl.quantita}</div>
                            <div class="prenotazione-type-pizza">${pizzaEl.pizza}</div>
                        </div>
                    </c:forEach>
                    <div class="prenotazione-data">${prenotazione.data_consegna}</div>

                    <div class="prenotazione-actions">
                        <c:if test="${prenotazione.flag_confirm == 0}">
                            <img class="prenotazione-conferma-off" title="Conferma di avvenuta consegna" src="<c:url value="/resources/img/checkmark-off.png" />" alt="conferma"/>
                        </c:if>
                        <c:if test="${prenotazione.flag_confirm == 1}">
                            <img class="prenotazione-conferma-on" title="Hai confermato la consegna" src="<c:url value="/resources/img/checkmark-on.png" />" alt="confermata"/>
                        </c:if>
                        <img class="prenotazione-cancella" title="Cancella la prenotazione" src="<c:url value="/resources/img/delete.png" />" alt="cancella"/>
                    </div>
                </div>
            </c:forEach>
        </div>

    </div>
    <jsp:include page="../common/column.jsp"/>
</div>
<jsp:include page="../common/footer.jsp"/>
</body>
</html>