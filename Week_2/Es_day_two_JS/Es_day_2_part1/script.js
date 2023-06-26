// --- Funzione esercizio 1 ---
function add(x, y){
    console.log("Esercizio 1, soluzione: " + (x+y));
}



// --- Funzione esercizio 2 ---
function sub(x, y){
    console.log("Esercizio 2, soluzione: " + (x-y));
}



// --- Funzione esercizio 3 ---
function mul(x, y){
    console.log("Esercizio 3, soluzione: " + (x*y));
}



// --- Funzione esercizio 4 ---
function div(x, y){
    console.log("Esercizio 4, soluzione: " + (x/y));
}



// --- Funzione esercizio 5 ---
function resto(x, y){
    console.log("Esercizio 5, soluzione: " + (x%y));
}



// --- Funzione esercizio 6 ---
function media(array){
    var somma = 0;

    for(let i=0; i<array.length; i++){
        somma += array[i];
    }
    
    let media = somma/array.length;
    console.log("Esercizio 6, soluzione: " + media);
}



// --- Funzione esercizio 7 ---
function parita(x){
    if(x%2 == 0)
        console.log("Esercizio 7, soluzione: " + "pari");
    else
        console.log("Esercizio 7, soluzione: " + "dispari");
}



// --- Funzione esercizio 8 ---
function compare(x, y){
    if(x === y)
        console.log("Esercizio 8, soluzione: " + "x uguale y");
    else if(x < y)
        console.log("Esercizio 8, soluzione: " + "x minore y");
    else
        console.log("Esercizio 8, soluzione: " + "x maggiore y");
}



// --- Funzione esercizio 9 ---
function emptyStr(str){
    if(str == "")
        console.log("Esercizio 9, soluzione: " + "stringa vuota");
    else
        console.log("Esercizio 9, soluzione: " + "stringa piena");
}



// --- Funzione esercizio 10 ---
function hasSubStr(str, subStr){
    if(str.includes(subStr))
        console.log("Esercizio 10, soluzione: " + "sottostringa presente");
    else
        console.log("Esercizio 10, soluzione: " + "sottostringa non presente");
}



// --- Funzione esercizio 11 ---
function whichLetter(letter){
    
    let isVocale = letter == 'a' || letter == 'A' || letter == 'e' || letter == 'E' || letter == 'i' || letter == 'I' || letter == 'o' || letter == 'O' || letter == 'u' || letter == 'U';
    
    if(isVocale)
        console.log("Esercizio 11, soluzione: " + "vocale");
    else
        console.log("Esercizio 11, soluzione: " + "consonante");
}



// --- Funzione esercizio 12 ---
function divisibilePer3o5(x){
    let msg;

    if(x%3 == 0){
        if(x%5 == 0){
            msg = "divisibile per 3 e per 5";
        }
        else{
            msg = "divisibile per 3";
        }
    }
    else if(x%5 == 0){
        msg = "divisibile per 5";
    }
    else{
        msg = "non divisibile nè per 3 e nè per 5";
    }
    
    console.log("Esercizio 12, soluzione: " + msg);
}



// --- Funzione esercizio 13 ---
function createArray(str){
    let array = str.split(',');
    console.log("Esercizio 13, soluzione: " + array);
}



// --- Funzione esercizio 14 ---
function searchInArray(array, num){
    if(array == null || array == undefined)
        console.log("Esercizio 14, soluzione: " + "array vuoto");
    else{
        for(let i=0; i<array.length; i++){
            if(array[i] === num){
                console.log("Esercizio 14, soluzione: " + "trovato");
                return;
            }
        }

        console.log("Esercizio 14, soluzione: " + "non trovato");
    }
        
}



// --- Funzione esercizio 15 ---
function joinArray(array1, array2){
    let newArray = array1.concat(array2);
        console.log("Esercizio 15, soluzione: " + newArray);
}



// --- Funzione esercizio 16 ---
function subArray(array){

    if(array == null || array == undefined){
        console.log("Esercizio 16, soluzione: " + "array vuoto");
        return;
    }

    let newArray = [];
    
    for(let i=0; i<array.length; i++){
        if(array[i]%2 == 0){
            newArray.push(array[i]);
        }
    }

    console.log("Esercizio 16, soluzione: " + newArray);
}



// --- Funzione esercizio 17 ---
function getElementsGt5(array){
    if(array == null || array == undefined){
        console.log("Esercizio 17, soluzione: " + "array vuoto");
        return;
    }

    let newArray = [];
    
    newArray = array.filter(num => num>5)

    console.log("Esercizio 17, soluzione: " + newArray);
}



// --- Funzione esercizio 18 ---
function createObject(nome, cognome, eta, via){
    let persona = {
        nome: nome,
        cognome: cognome,
        eta: eta,
        via: via
    };
    
    console.log("Esercizio 18, soluzione: " + persona.nome + ", " + persona.cognome + ", " + persona.eta + " anni, " + persona.via);
}



// --- Funzione esercizio 19 ---
function getObjectName(persona){
    if(persona == null){
        console.log("Esercizio 19, soluzione: " + "oggetto vuoto");
        return;
    }
        console.log("Esercizio 19, soluzione: " + "nome: " + persona.nome);
}



// --- Funzioni esercizio 20 ---
function setObjectName(persona){
    console.log("Esercizio 20, soluzione: " + "nome prima della modifica: " + persona.nome);

    persona.nome = "Gino";

    console.log("Esercizio 20, soluzione: " + "nome dopo la modifica: " + persona.nome);
}

function setObjectEta(persona){
    console.log("Esercizio 20, soluzione: " + "età prima della modifica: " + persona.eta);

    persona.eta++;

    console.log("Esercizio 20, soluzione: " + "età dopo la modifica: " + persona.eta);
}



// --- Funzioni esercizio 21 ---
function add2(x, y){
    console.log("Esercizio 21, soluzione: " + my_add(x, y)); // my_add è la sotto funzione
}



// sotto funzione
function my_add(x, y){
    return x+y;
}



// --- Funzioni esercizio 22 ---
function double(x){
    console.log("Esercizio 22, soluzione: " + my_double(x));
}



// sotto funzione
function my_double(x){
    return x*2;
}



// --- Funzioni esercizio 23 ---
function strLen(str){
    console.log("Esercizio 23, soluzione: " + my_strLen(str));
}



// sotto funzione
function my_strLen(str){
    return str.length;
}



// --- Funzioni esercizio 24 ---
function indexOfChar(str, c){
    console.log("Esercizio 24, soluzione: " + my_indexOfChar(str, c));
}



// sotto funzione
function my_indexOfChar(str, c){
    return str.indexOf(c);
}



// --- Funzioni esercizio 25 ---
function max(x, y){
    console.log("Esercizio 25, soluzione: " + my_max(x, y));
}



// sotto funzione
function my_max(x, y){
    return Math.max(x, y);
}



// --- Funzioni esercizio 26 ---
function reverseStr(str){
    console.log("Esercizio 26, soluzione: " + my_reverseStr(str));
}



// sotto funzione
function my_reverseStr(str){
    return str.split("").reverse().join(""); // str --> array dei caratteri --> inverto l'array --> unisco i caratteri in stringa
}



// --- Funzioni esercizio 27 ---
function sumArray(array){
    if(array == null || array == undefined){
        console.log("Esercizio 27, soluzione: " + "array vuoto");
        return;
    }
    console.log("Esercizio 27, soluzione: " + my_sumArray(array));
}



// sotto funzione
function my_sumArray(array){

    let somma = 0;

    for(let i=0; i<array.length; i++)
        somma += array[i];

    return somma;
}



// --- Funzioni esercizio 28 ---
function maxArray(array){
    if(array == null || array == undefined){
        console.log("Esercizio 28, soluzione: " + "array vuoto");
        return;
    }
    console.log("Esercizio 28, soluzione: " + my_maxArray(array));
}



// sotto funzione
function my_maxArray(array){
    
    let max = - Number.MAX_VALUE; // inizializzo max al minor valore possibile

    for(let i=0; i<array.length; i++)
        if(array[i] > max)
            max = array[i];

    return max;
}



// --- Funzioni esercizio 29 ---
function longestStr(str1, str2){
    console.log("Esercizio 29, soluzione: " + my_longestStr(str1, str2));
}



// sotto funzione
function my_longestStr(str1, str2){
    if(str1.length > str2.length)
        return str1;
    else
        return str2;
}

