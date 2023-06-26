document.addEventListener("DOMContentLoaded", function(event) {

    // faccio una richiesta API di tipo GET a http://cicacademy2023.ddns.net/esercizi/get
    var request = new XMLHttpRequest();
    request.open("GET", "http://cicacademy2023.ddns.net/esercizi/get", false);
    request.send(null);

    
    if(request.status === 200){
        // se la richiesta è andata a buon fine

        let jsonStr = request.response;

        let jsonObj = JSON.parse(jsonStr);

        let specializzazione = jsonObj.data.specializzazione;
        let contesto = jsonObj.data.ambito.contesto;

        document.getElementById("spec").innerHTML = specializzazione;
        document.getElementById("cont").innerHTML = contesto;
    }
    else{
        document.getElementById("spec").innerHTML = "Richiesta verso l'endpoint non andata a buon fine!";
    }


});


