<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div id="column">

    <%--MENU SEMPRE VISIBILE--%>
    <div id="unregistered-menu" class="column-menu">
        <div class="menu-title">MENU</div>
        <%--BUTTONS--%>
        <div class="menu_button_container">
            <div class="menu-button">
                <a href="<c:url value="/pizzeria/catalogo" />">Catalogo</a>
            </div>
        </div>
    </div>


    <c:if test="${pageContext.request.userPrincipal.name == null}">
        <div id="user-menu-login-button">
            <a href="<c:url value="/pizzeria/login" />">Accedi</a>
        </div>
    </c:if>

    <%--AREA PERSONALE--%>
    <sec:authorize access="hasRole('ROLE_USER')">
        <div id="registered-menu" class="column-menu">

            <div class="menu-title">AREA PERSONALE</div>

            <%--WELCOME--%>
            <div id="user-welcome">Ciao, ${pageContext.request.userPrincipal.name}!</div>

            <%--BUTTONS--%>
            <div class="menu_button_container">
                <div class="menu-button">
                    <a href="<c:url value="/pizzeria/user/prenota" />">Prenota una pizza</a>
                </div>

                <div class="menu-button">
                    <a href="<c:url value="/pizzeria/user/prenotazioni" />">Le mie prenotazioni</a>
                </div>

                <%--LOGOUT--%>
                <c:url value="/j_spring_security_logout" var="logoutUrl" />
                <form style="display: none;" action="${logoutUrl}" method="post" id="logoutForm">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                </form>

                <div class="menu-button">
                    <a href="javascript:formSubmit()">Esci</a>
                </div>
            </div>
        </div>
    </sec:authorize>

    <%--MENU ADMINISTRATOR--%>
    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <div id="admin-menu" class="column-menu">
            <div class="menu-title">AMMINISTRAZIONE</div>

            <%--BUTTONS--%>
            <div class="menu_button_container">
                <div class="menu-button">
                    <a href="<c:url value="/pizzeria/admin/catalogo" />">Catalogo</a>
                </div>
                <div class="menu-button">
                    <a href="<c:url value="/pizzeria/admin/prenotazioni" />">Prenotazioni</a>
                </div>
            </div>

        </div>
    </sec:authorize>

</div>