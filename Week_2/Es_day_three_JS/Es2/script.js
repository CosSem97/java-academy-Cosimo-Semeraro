
document.getElementById("submit").addEventListener("click", function(event) {

    event.preventDefault();

    // prendo i dati del form
    let nome = document.getElementById("nome").value;
    let cognome = document.getElementById("cognome").value;
    let eta = document.getElementById("eta").value;

    // se l'utente non ha inserito tutti i dati stampo un messaggio di warning
    if(nome === "" || cognome === "" || eta ===""){
        document.getElementById("warning").innerHTML = "Inserisci tutti i campi!";
    }
    else{
        // se l'utente ha inserito tutti i dati

        // prima di spostarmi nella pagina2, per passare i dati alla pagina2 li metto nella memoria localStorage
        localStorage.setItem("nome", nome);
        localStorage.setItem("cognome", cognome);
        localStorage.setItem("eta", eta);

        // mi sposto nella pagina 2
        window.location.href = "pagina2.html";

    }

});

