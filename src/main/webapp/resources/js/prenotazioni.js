$(".prenotazione-conferma-off").css('cursor', 'pointer').click(function() {

    var parent = $(this).closest('.prenotazione-tile');
    var id = parent.children('.prenotazione-id').val();

    $.ajax({
        type: "POST",
        url: SERVER + "/pizzeria/user/confermaPrenotazione",
        data: {id: id},
        dataType: "json",
//        processData: false,
//        contentType: "application/json",
        success: function(data) {
            location.reload();
        },
        error: function(data) {
            showAlert("Errore. Si prega di riprovare più tardi");
        }
    });
});

$(".prenotazione-cancella").css('cursor', 'pointer').click(function() {

    var parent = $(this).closest('.prenotazione-tile');
    var id = parent.children('.prenotazione-id').val();

    $.ajax({
        type: "POST",
        url: SERVER + "/pizzeria/user/cancellaPrenotazione",
        data: {id: id},
        dataType: "json",
//        processData: false,
//        contentType: "application/json",
        success: function(data) {
            location.reload();
        },
        error: function(data) {
            showAlert("Errore. Si prega di riprovare più tardi");
        }
    });
});