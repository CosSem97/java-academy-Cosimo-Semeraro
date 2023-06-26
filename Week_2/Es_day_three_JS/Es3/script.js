document.addEventListener("DOMContentLoaded", function(event) {

    let jsonStr = '{"success":true, "data":{"specializzazione":"Design", "ambito":{"contesto":"Enterprise"}}}';

    let jsonObj = JSON.parse(jsonStr);

    let specializzazione = jsonObj.data.specializzazione;
    let contesto = jsonObj.data.ambito.contesto;

    document.getElementById("spec").innerHTML = specializzazione;
    document.getElementById("cont").innerHTML = contesto;
});


