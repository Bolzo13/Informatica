/* 
 // * To change this license header, choose License Headers in Project Properties.
 // * To change this template file, choose Tools | Templates
 // * and open the template in the editor.
*/
function verificaCap(){
	
	let cap=document.forms[0].elements[4].value;
	if(cap.length!==5){
		alert("Cap Errato!!!");
	}
}

function isANumber(){
	let campo=document.forms[0].elements[0].value;
	for(let i=0;i<campo.length;i++){
		if(!(isNaN(campo.charAt(i)))&&campo.charAt(i)!==' '){
			alert("Il campo contiene un numero!!!");
			break;
		}
	}
}

function isVuoto(){
	let cognomenome=document.forms[0].elements[0].value;
	let uomo=document.getElementById("maschio").checked;
	let donna=document.getElementById("femmina").checked;
	let ateneo=document.forms[0].elements[3].value;
	let lavoratore=document.forms[0].elements[5].checked;
	if(cognomenome==="" || (uomo===false && donna===false) || ateneo===""){
		alert("Compila tutti i campi");
	}
	if(lavoratore && document.forms[0].elements[6].value===""){
		alert("Compilare Lavoro Svolto");
	}
}