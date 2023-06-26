// --- Funzione esercizio 1 ---
function changeParagraphContent(){

    let paragrafo = document.getElementById("my_p");

    paragrafo.innerHTML = "mondo";
    
}



// --- Funzione esercizio 2 ---
function changeTableContent(){

    let righeTabella = document.getElementsByTagName("tr"); // poichè ho 3 tag <tr>, righeTabella sarà un array di 3 elementi tr

    for(let i=0; i<righeTabella.length; i++){
        let colonneRiga_i = righeTabella[i].getElementsByTagName("td"); // dalla riga i prendo gli elementi td. Poichè ogni riga ha 3 <td>, 
                                                                        // colonneRiga_i sarà un array di 3 elementi td
        colonneRiga_i[i].innerHTML = "a";
    }
}



// --- Funzione esercizio 3 ---
function changeAttributeOfImg(){

    document.getElementById("meme").setAttribute("src", "https://upload.wikimedia.org/wikipedia/commons/6/62/Turin_monte_cappuccini.jpg");

}



// --- Funzione esercizio 6 ---
function go(){

    let imgArray = ["https://upload.wikimedia.org/wikipedia/commons/7/75/Whatsapp_logo_svg.png",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1b/Facebook_icon.svg/2048px-Facebook_icon.svg.png",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/9/95/Instagram_logo_2022.svg/2048px-Instagram_logo_2022.svg.png",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/6/6f/Logo_of_Twitter.svg/1200px-Logo_of_Twitter.svg.png",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/b/be/Facebook_Messenger_logo_2020.svg/768px-Facebook_Messenger_logo_2020.svg.png",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f2/Pinterest_Shiny_Icon.svg/2048px-Pinterest_Shiny_Icon.svg.png",
                    "https://upload.wikimedia.org/wikipedia/en/thumb/b/bd/Reddit_Logo_Icon.svg/150px-Reddit_Logo_Icon.svg.png",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/8/82/Telegram_logo.svg/1200px-Telegram_logo.svg.png",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e9/Linkedin_icon.svg/2048px-Linkedin_icon.svg.png"];

    for(let i=0; i<imgArray.length; i++){
        document.getElementById("img_" + i).src = imgArray[i];
    }
}



