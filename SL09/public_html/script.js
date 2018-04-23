/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function check() {
	let cognome = document.forms[0].elements[0].value;
	let nome = document.forms[0].elements[1].value;
	let matricola = document.forms[0].elements[2].value;
	let regione = document.forms[0].elements[3].value;
	let email = document.forms[0].elements[4].value;
	let telefono = document.forms[0].elements[5].value;
	
	if( cognome==="" || nome==="" || isNaN(+matricola) || (email==="" && telefono==="") || regione===""){
		alert("Ou compila sto modulo!");
	} else{
		alert("Bea more");
	}
}
