<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="../common/import.jsp"/>
</head>
<body>

<jsp:include page="../common/header.jsp"/>
<div id="wrapper">
    <div id="main-page">

        <%--MAIN PAGE CONTENT--%>
        <div class="page-title">Prenotazione pizze</div>

        <div class="content-padding border-bottom-dashed">
            <div class="page-subtitle">Ordina</div>
            <div id="prenotaBox">
                <%--FORM--%>
                <form id="prenota-form" class="form form-inline form-multiline" role="form">
                    <%--PIZZA--%>
                    <div class="form-group prenota-el">
                        <label for="inputPizza">Pizza</label>
                        <select id="inputPizza" class="form-control">
                            <option value="">-- SCEGLI LA PIZZA --</option>
                            <c:forEach items="${pizze}" var="pizza">
                                <option value="${pizza.prezzo}" title="${pizza.ingredienti}">${pizza.nome}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <%--QUANTITA--%>
                    <div class="form-group prenota-el">
                        <label for="inputQuantita">Quantità</label>
                        <input id="inputQuantita" class="form-control" type="number" value="1">
                    </div>
                    <%--TOTALE--%>
                    <div class="form-group prenota-el">
                        <label for="labelCosto">Costo</label>
                        <div id="labelCosto" class="form-control">0 €</div>
                    </div>

                    <div class="form-group prenota-el">
                        <button id="prenotaInsert" type="button" class="btn btn-primary form-control">Aggiungi</button>
                    </div>
                </form>
            </div>
        </div>

        <div class="content-padding">
            <div class="page-subtitle">Riepilogo</div>
            <div id="prenotaCarrello">
                <form id="prenota-carrello-form" class="form" role="form">
                    <%--DATA--%>
                    <div class="form-group prenota-el">
                        <label for="inputData">Data di consegna</label>
                        <input id="inputData" class="form-control" type="text">
                    </div>
                    <%--TOTALE--%>
                    <div class="form-group prenota-el">
                        <label for="labelTotale">Importo totale</label>
                        <div id="labelTotale" class="form-control">0 €</div>
                    </div>
                    <div class="form-group prenota-el">
                        <button id="prenotaReset" type="button" class="btn btn-warning form-control">Reset</button>
                    </div>
                    <div class="form-group prenota-el">
                        <button id="prenotaSubmit" type="button" class="btn btn-danger form-control">Invia</button>
                    </div>
                </form>

                <%--CARRELLO--%>
                <div id="prenotaRiepilogoContainer">
                    <table id="prenotaRiepilogo">
                        <tbody>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="../common/column.jsp"/>
</div>
<jsp:include page="../common/footer.jsp"/>
</body>
</html>