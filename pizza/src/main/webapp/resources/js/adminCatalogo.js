$("#admin-catalogo-pizze-add").click(function() {
//    EMPTY MODAL FIELDS
    $("#modal-add-id").val(0);
    $("#modal-add-pizza").val('');
    $("#modal-add-ingredienti").val('');
    $("#modal-add-prezzo").val('');
    $('#modal-add').modal('show');
});

$(".admin-catalogo-pizze-update").css('cursor', 'pointer').click(function() {
//    FILL MODAL FIELDS
    var parent = $(this).closest('.admin-catalogo-pizze-row');

    var id = parent.children('.admin-catalogo-pizze-id').val();
    var pizza = parent.children('.admin-catalogo-pizze-nome').text();
    var ingredienti = parent.children('.admin-catalogo-pizze-ingredienti').text();
    var prezzo = parseFloat(parent.children('.admin-catalogo-pizze-prezzo').text().replace(" €", ""));

    console.log(id + " - "+ pizza + " - "+ ingredienti + " - "+ prezzo);

    $("#modal-add-id").val(id);
    $("#modal-add-pizza").val(pizza);
    $("#modal-add-ingredienti").val(ingredienti);
    $("#modal-add-prezzo").val(prezzo);
    $('#modal-add').modal('show');
});

$(".admin-catalogo-pizze-delete").css('cursor', 'pointer').click(function() {
    var parent = $(this).closest('.admin-catalogo-pizze-row');
    var id = parent.children('.admin-catalogo-pizze-id').val();

    $.ajax({
        type: "POST",
        url: SERVER + "/pizzeria/admin/cancellaPizza",
        data: {
            id: id
        },
        dataType: "json",
        success: function(data) {
            location.reload();
        },
        error: function(data) {
            showAlert("Problema di connessione con il server");
        }
    });
});

$("#modal-add-button").click(function() {

    var id = $("#modal-add-id").val();
    var nome = $("#modal-add-pizza").val().trim();
    var ingredienti = $("#modal-add-ingredienti").val().trim();
    var prezzo = $("#modal-add-prezzo").val().trim();

    if(nome == '' || ingredienti == '' || prezzo == '') {
        $("#model-validation").show().text("Riempi correttamente i campi del form");
        return;
    }

    console.log(id + " - "+ nome + " - "+ ingredienti + " - "+ prezzo);

    var pizzaJson = {
        id: id,
        nome: nome,
        ingredienti: ingredienti,
        prezzo: prezzo
    };

    $.ajax({
        type: "POST",
        url: SERVER + "/pizzeria/admin/inserisciPizza",
        data: JSON.stringify(pizzaJson),
        processData: false,
        contentType: "application/json",
        success: function(data) {
            $('#modal-add').modal('hide');
            location.reload();
        },
        error: function(data) {
            $("#model-validation").show().text("Problema di connessione con il server");
        }
    });
});