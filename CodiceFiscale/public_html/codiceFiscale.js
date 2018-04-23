/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
let data;
const FINAL_CHECK ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";

function codiceFiscale() {
	let nome = document.forms[0].elements[0].value;
	let cognome = document.forms[0].elements[1].value;
	data = document.forms[0].elements[2].value;
	let sesso = document.getElementById("maschio").checked;
	let comune = document.forms[0].elements[5].value;
	let cf=trovaConsonanti(cognome) + trovaConsonanti(nome) + data.charAt(2) + data.charAt(3) + mese(data.charAt(5) + data.charAt(6)) + giorno(sesso)+findcomune(comune);
	cf+=check(cf);
	alert(cf);
}

function trovaConsonanti(stringa) {
	let cognome = "", vocali = "", consonanti = "";
	stringa = stringa.toUpperCase();
	for (let i = 0; i < stringa.length; i++) {
		if (stringa.charAt(i) === 'A' || stringa.charAt(i) === 'E' || stringa.charAt(i) === 'I' || stringa.charAt(i) === 'O' || stringa.charAt(i) === 'U')
		{
			vocali += stringa.charAt(i);
		} else {
			consonanti += stringa.charAt(i);
		}
	}
	let j = 0;
	for (let i = 0; i < 3; i++) {
		if (i < consonanti.length) {
			cognome += consonanti.charAt(i);
		} else {
			if (i <= vocali.length) {
				cognome += vocali.charAt(j);
				j++;
			} else {
				cognome += 'X';
			}
		}
	}
	return(cognome);
}

function mese(mese) {
	switch (mese) {
		case "01":
			return 'A';
			break;
		case "02":
			return 'B';
			break;
		case "03":
			return 'C';
			break;
		case "04":
			return 'D';
			break;
		case "05":
			return 'E';
			break;
		case "06":
			return 'H';
			break;
		case "07":
			return 'L';
			break;
		case "08":
			return 'M';
			break;
		case "09":
			return 'P';
			break;
		case "10":
			return 'R';
			break;
		case "11":
			return 'S';
			break;
		case "12":
			return 'T';
			break;
	}
}

function giorno(sesso){
	if(sesso){
		return data.charAt(8)+data.charAt(9);
	}else{
		return (4+ +data.charAt(8))+data.charAt(9);
	}
}

function findcomune(comune){
	return Comuni[comune];
}

const CHECK_EVEN = {
    0: 0,
    1: 1,
    2: 2,
    3: 3,
    4: 4,
    5: 5,
    6: 6,
    7: 7,
    8: 8,
    9: 9,
    A: 0,
    B: 1,
    C: 2,
    D: 3,
    E: 4,
    F: 5,
    G: 6,
    H: 7,
    I: 8,
    J: 9,
    K: 10,
    L: 11,
    M: 12,
    N: 13,
    O: 14,
    P: 15,
    Q: 16,
    R: 17,
    S: 18,
    T: 19,
    U: 20,
    V: 21,
    W: 22,
    X: 23,
    Y: 24,
    Z: 25
};
const CHECK_ODD = {
    0: 1,
    1: 0,
    2: 5,
    3: 7,
    4: 9,
    5: 13,
    6: 15,
    7: 17,
    8: 19,
    9: 21,
    A: 1,
    B: 0,
    C: 5,
    D: 7,
    E: 9,
    F: 13,
    G: 15,
    H: 17,
    I: 19,
    J: 21,
    K: 2,
    L: 4,
    M: 18,
    N: 20,
    O: 11,
    P: 3,
    Q: 6,
    R: 8,
    S: 12,
    T: 14,
    U: 16,
    V: 10,
    W: 22,
    X: 25,
    Y: 24,
    Z: 23
};
const Comuni = {
    "ANNONE VENETO" : "A302",
    "CAMPAGNA LUPIA" : "B493",
    "CAMPOLONGO MAGGIORE" : "B546",
    "CAMPONOGARA" : "B554",
    "CAORLE" : "B642",
    "CAVARZERE" : "C383",
    "JESOLO" : "C388",
    "CEGGIA" : "C422",
    "CHIOGGIA" : "C638",
    "CINTO CAOMAGGIORE" : "C714",
    "CONA" : "C938",
    "CONCORDIA SAGITTARIA" : "C950",
    "DOLO" : "D325",
    "ERACLEA" : "D415",
    "FIESSO D'ARTICO" : "D578",
    "FOSSALTA DI PIAVE" : "D740",
    "FOSSALTA DI PORTOGRUARO" : "D741",
    "FOSSO'" : "D748",
    "GRUARO" : "E215",
    "MARCON" : "E936",
    "MARTELLAGO" : "E980",
    "MEOLO" : "F130",
    "MIRA" : "F229",
    "MIRANO" : "F241",
    "MUSILE DI PIAVE" : "F826",
    "NOALE" : "F904",
    "NOVENTA DI PIAVE" : "F963",
    "PIANIGA" : "G565",
    "PORTOGRUARO" : "G914",
    "PRAMAGGIORE" : "G981",
    "QUARTO D'ALTINO" : "H117",
    "SALZANO" : "H735",
    "SAN DONA' DI PIAVE" : "H823",
    "SAN MICHELE AL TAGLIAMENTO" : "I040",
    "SANTA MARIA DI SALA" : "I242",
    "SANTO STINO DI LIVENZA" : "I373",
    "SCORZE'" : "I551",
    "SPINEA" : "I908",
    "STRA" : "I965",
    "TEGLIO VENETO" : "L085",
    "TORRE DI MOSTO" : "L267",
    "VENEZIA" : "L736",
    "VIGONOVO" : "L899",
    "CAVALLINO-TREPORTI" : "M308",
};

function check(code){
    let char = 0;
    for(let i = 0 ; i < 15; i++)
        char += i % 2 === 0 ? CHECK_ODD[code.charAt(i)] : CHECK_EVEN[code.charAt(i)];
    return FINAL_CHECK.charAt(char % 26);

}