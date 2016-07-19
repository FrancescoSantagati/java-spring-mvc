<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="common/import.jsp"/>
</head>
<body>
<jsp:include page="common/header.jsp"/>
<div id="wrapper">
    <div id="main-page">

        <%--MAIN PAGE CONTENT--%>
        <div id="login-container">
            <div id="login-form-title">Accedi con le tue credenziali</div>

            <form role="form" class="form-horizontal" action="<c:url value='/j_spring_security_check' />" method='POST'>
                <div class="form-group">
                    <label for="inputEmail3" class="col-sm-2 control-label">Username</label>
                    <div class="col-sm-10">
                        <input type="text" name="username" class="form-control" id="inputEmail3" placeholder="Username">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
                    <div class="col-sm-10">
                        <input type="password" name="password" class="form-control" id="inputPassword3" placeholder="Password">
                    </div>
                </div>
                <button type="submit" class="btn btn-default">Login</button>

                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            </form>

            <c:if test="${not empty error}">
                <div class="error">${error}</div>
            </c:if>
            <c:if test="${not empty msg}">
                <div class="msg">${msg}</div>
            </c:if>

        </div>

    </div>
    <jsp:include page="common/column.jsp"/>
</div>
<jsp:include page="common/footer.jsp"/>
</body>
</html>