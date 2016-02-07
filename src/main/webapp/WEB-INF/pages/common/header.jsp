<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="header"  class="vertical-align">
    <%--HEADER--%>
    <div id="header-logo-container">
        <a style="margin-right: 2%;" href="<c:url value="/pizzeria/" />"><img id="header-logo-image" src="<c:url value="/resources/img/logo-white.png" />" alt="logo"/></a>
        <a id="header-logo-title" href="<c:url value="/pizzeria/" />" >PIZZERIA</a>
        <a id="header-logo-description" href="<c:url value="/pizzeria/" />" >[IUM Project]</a>
    </div>
</div>

<!-- Error Modal -->
<div id="error-modal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="error-modal-dialog">
        <div class="error-modal-content">
            <div class="error-modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <div class="modal-title" id="error-modal-message">Pizzeria</div>
            </div>
            <%--<div class="modal-body-custom">&lt;%&ndash;MESSAGE HERE!&ndash;%&gt;</div>--%>
            <%--<div class="modal-footer">--%>
                <%--<button type="button" class="btn btn-default" data-dismiss="modal">Chiudi</button>--%>
            <%--</div>--%>
        </div>
    </div>
</div>