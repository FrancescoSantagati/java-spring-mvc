var jsonPrenotazioni = {
    data: null,
    totale: 0,
    prenotazione: []
};

var prenotazioneCorrente = {
    pizza : null,
    quantita : 1,
    prezzoUnitario : 0,
    prezzoTotale : 0
}

$('#inputPizza').on('change', function() {
    prenotazioneCorrente.pizza = $(this).find(":selected").text();
    prenotazioneCorrente.prezzoUnitario = this.value;
    $('#inputQuantita').val(1);
    prenotazioneCorrente.quantita = 1;
    aggiornaCosto();
});

$('#inputQuantita').on('change', function() {
    if($(this).val() < 1) {
        showAlert("La quantità non può essere minore di 1");
        $(this).val(1);
        return;
    }
    prenotazioneCorrente.quantita = $(this).val();
    aggiornaCosto();
});

$(function() {
    var datepicker = $("#inputData");
    datepicker.datetimepicker({
        onSelect: function() {
            jsonPrenotazioni.data = this.value;
        }
    });
    datepicker.datetimepicker("option", "showAnim", "slide");
    datepicker.datetimepicker("option", "dateFormat", "dd/mm/yy");
});

$("#prenotaInsert").click(function() {
    if(prenotazioneCorrente.pizza == null || prenotazioneCorrente.pizza.charAt(0) == '-') {
        showAlert("Devi scegliere una pizza!");
        return;
    }
    insertPizza();
});

$("#prenotaReset").click(function() {
    location.reload();
});

$("#prenotaSubmit").click(function() {
    if(jsonPrenotazioni.totale == 0 || jsonPrenotazioni.prenotazione.length == 0) {
        showAlert("Non hai ordinato nessuna pizza!");
        return;
    }
    else if(jsonPrenotazioni.data == null) {
        showAlert("Inserisci la data di consegna!");
        return;
    }

    $.ajax({
        type: "POST",
        url: SERVER + "/pizzeria/user/inviaPrenotazione",
        data: JSON.stringify(jsonPrenotazioni),
        processData: false,
        contentType: "application/json",
        success: function(data) {

            var url = SERVER + "/pizzeria/user/prenotazioni";
            $(location).attr('href',url);
            //showAlert("Abbiamo ricevuto la sua prenotazione! Buona giornata");
        },
        error: function(data) {
            showAlert("Errore nell'invio della prenotazione. Si prega di riprovare più tardi");
        }
    });
});

$(".prenota-carrello-cancella").css('cursor', 'pointer').click(function() {
    var parent = $(this).closest('.prenota-carrello-row');
    var array_id = parent.children('.prenota-carrello-id').val();

    jsonPrenotazioni.prenotazione.splice(array_id, 1);
    parent.remove();
});

function insertPizza () {
    $("#prenotaRiepilogo").find('tbody:last').append(
        '<tr class="prenota-carrello-row">' +
            '<input class="prenota-carrello-id" type="hidden" value=' + jsonPrenotazioni.prenotazione.length + ' />' +
            '<td class=\"prenota-carrello-quantita\">' + prenotazioneCorrente.quantita + '</td>' +
            '<td class=\"prenota-carrello-nome\">' + prenotazioneCorrente.pizza + '</td>' +
            '<td class=\"prenota-carrello-costo\">' + prenotazioneCorrente.prezzoTotale + ' €</td>' +
        '</tr>'
    );
    jsonPrenotazioni.prenotazione.push({
        pizza: prenotazioneCorrente.pizza,
        quantita: prenotazioneCorrente.quantita,
        costo: prenotazioneCorrente.prezzoTotale
    });
    aggiornaTotale();
}

function aggiornaCosto () {
    prenotazioneCorrente.prezzoTotale = prenotazioneCorrente.prezzoUnitario * prenotazioneCorrente.quantita;
    var totalString = prenotazioneCorrente.prezzoTotale.toString();
    totalString = totalString.replace(".", ",");
    $('#labelCosto').text(totalString + " €");
}

function aggiornaTotale () {
    jsonPrenotazioni.totale = 0;
    for (var i = 0; i < jsonPrenotazioni.prenotazione.length; i++) {
        jsonPrenotazioni.totale = jsonPrenotazioni.totale + jsonPrenotazioni.prenotazione[i].costo;
    }
    var totalString = jsonPrenotazioni.totale.toString();
    totalString = totalString.replace(".", ",");
    $('#labelTotale').text(totalString + " €");
}