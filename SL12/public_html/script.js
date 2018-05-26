/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
window.onload = load;
function load() {
    let xhttp = new XMLHttpRequest();
    let partenza = document.getElementById("partenza");
    let destinazione = document.getElementById("destinazione");
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            let response = JSON.parse(this.responseText);
            let chiavi = Object.keys(JSON.parse(this.responseText).results);
            chiavi.sort();
            for (let i of chiavi) {
                let option = document.createElement("option");
                option.text = i;
                partenza.add(option);
            }
            for (let i of chiavi) {
                let option = document.createElement("option");
                option.text = i;
                destinazione.add(option);
            }
        }
    };
    xhttp.open("GET", "https://free.currencyconverterapi.com/api/v5/currencies", true);
    xhttp.send();
}

function change() {
    let xhttp = new XMLHttpRequest();
    let partenza = document.getElementById("partenza").value;
    let destinazione = document.getElementById("destinazione").value;
    let soldi = document.getElementById("soldi").value;
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            let response = JSON.parse(this.responseText)[partenza + "_" + destinazione];
            response = parseFloat(response);
            document.getElementById("risultato").innerHTML = soldi + " " + partenza + " = " + (response * parseInt(soldi)).toFixed(2) + " " + destinazione;
        }
    };
    xhttp.open("GET", "https://free.currencyconverterapi.com/api/v5/convert?q=" + partenza + "_" + destinazione + "&compact=ultra", true);
    xhttp.send();
}
