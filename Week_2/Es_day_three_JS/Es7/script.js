document.getElementById("submit").addEventListener("click", function(event) {
    
    event.preventDefault();

    let username = document.getElementById("user").value;
    
    if(username === ""){
        // se l'utente ha cliccato su submit senza aver scritto un username
        document.getElementById("warning").innerHTML = "Inserisci un username!";
    }
    else{
        // se l'utente ha inserito un username
        richiestaAPI(username);
    }

});



function richiestaAPI(username){

    // faccio una richiesta API di tipo GET a http://cicacademy2023.ddns.net/esercizi/getParam
    var request = new XMLHttpRequest();
    request.open("GET", "http://cicacademy2023.ddns.net/esercizi/getParam?username=" + username, false);
    request.send();

    
    if(request.status === 200){
        // se la richiesta è andata a buon fine

        let jsonStr = request.response;

        let jsonObj = JSON.parse(jsonStr);

        let success = jsonObj.success;
    
        if(!success){
            alert("Username errato!");
        }
        else{
            let specializzazione = jsonObj.data.specializzazione;
            let contesto = jsonObj.data.ambito.contesto;
            
            document.getElementById("spec").innerHTML = specializzazione;
            document.getElementById("cont").innerHTML = contesto;
        }
    }
    else{
        alert("Richiesta verso l'endpoint non andata a buon fine!");
    }
}

