<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <jsp:include page="../common/import.jsp"/>
</head>
<body>
<!-- Modal -->
<div id="modal-add" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title" id="myModalLabel">Aggiungi una nuova pizza</h4>
            </div>
            <div class="modal-body">
                <form role="form">
                    <input id="modal-add-id" type="hidden"/>
                    <div class="form-group">
                        <label for="modal-add-pizza">Pizza</label>
                        <input type="text" class="form-control" id="modal-add-pizza" placeholder="Nome pizza">
                    </div>
                    <div class="form-group">
                        <label for="modal-add-ingredienti">Ingredienti</label>
                        <input type="text" class="form-control" id="modal-add-ingredienti" placeholder="Ingredienti">
                    </div>
                    <div class="form-group">
                        <label for="modal-add-prezzo">Prezzo</label>
                        <input type="number" step="0.01" class="form-control" id="modal-add-prezzo" placeholder="Prezzo">
                    </div>
                </form>
                <div id="model-validation"></div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Chiudi</button>
                <button id="modal-add-button" type="button" class="btn btn-primary">Salva</button>
            </div>
        </div>
    </div>
</div>

<jsp:include page="../common/header.jsp"/>
<div id="wrapper">
    <div id="main-page">

        <%--MAIN PAGE CONTENT--%>
        <div class="page-title">Amministrazione Catalogo</div>

        <div class="content-padding">
            <button id="admin-catalogo-pizze-add"
                    type="button" class="btn btn-primary form-control">

                Aggiungi
            </button>

            <table id="admin-catalogo-pizze-table">
                <c:forEach items="${pizze}" var="pizza">
                    <tr class="admin-catalogo-pizze-row">
                        <input class="admin-catalogo-pizze-id" type="hidden" value="${pizza.id}" />
                        <td class="admin-catalogo-pizze-nome">${pizza.nome}</td>
                        <td class="admin-catalogo-pizze-prezzo">${pizza.prezzo} €</td>
                        <td class="admin-catalogo-pizze-ingredienti">${pizza.ingredienti}</td>
                        <td>
                            <img class="admin-catalogo-pizze-update" title="Modifica" src="<c:url value="/resources/img/edit.png" />" alt="modifica"/>
                        </td>
                        <td>
                            <img class="admin-catalogo-pizze-delete" title="Elimina" src="<c:url value="/resources/img/delete.png" />" alt="cancella"/>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>

    </div>
    <jsp:include page="../common/column.jsp"/>
</div>
<jsp:include page="../common/footer.jsp"/>
</body>
</html>