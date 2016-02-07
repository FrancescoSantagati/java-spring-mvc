var SERVER = "http://localhost:8080";

function formSubmit() {
    document.getElementById("logoutForm").submit();
}

function showAlert(message) {
    var dialog = $('#error-modal');
    dialog.find('#error-modal-message').text(message);
    dialog.modal('show');
}