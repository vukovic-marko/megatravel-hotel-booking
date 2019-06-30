var idSobe;

$(document).ready(function() {
	
	var fromTimeInput = $('#date_added');
	//var toTimeInput = $('#date_modified');
	var fromTime = fromTimeInput.val();
	//var toTime = toTimeInput.val();

	fromTimeInput.datepicker({
		keyboardNavigation : false,
		forceParse : false,
		calendarWeeks : true,
		autoclose : true
		//endDate : toTime
	});
//	toTimeInput.datepicker({
//		keyboardNavigation : false,
//		forceParse : false,
//		calendarWeeks : true,
//		autoclose : true,
//		startDate : fromTime
//	});
//	fromTimeInput.on("changeDate", function(e) {
//		toTimeInput.datepicker('setStartDate', e.date);
//	});
//	toTimeInput.on("changeDate", function(e) {
//		fromTimeInput.datepicker('setEndDate', e.date);
//	});
	
})


function myRooms(){
	var tabelaSoba = document.getElementById('tabelaSobe');
	$('#modalMojeSobe').modal();
	
	//preuzimam sve sobe koje se vode na ulogovanog agenta
	$.ajax({
		async: false,
		url: "http://localhost:8081/agent/getAllRooms",
        type: "GET",
        beforeSend: function(request) {
		    request.setRequestHeader("Authorization", localStorage.getItem('token'));
		},
        dataType: "json",
        success: function (data) {
        	for(i=0;i<data.length;i++){
        		var redUTabeli = document.createElement('tr');
        		var brojSobe = document.createElement('th');
        		var brojKreveta = document.createElement('th');
        		var opis = document.createElement('th');
        		var tx=document.createElement('textarea');
        		tx.setAttribute('rows', '3');
				tx.setAttribute('cols', '30');
				tx.setAttribute('readonly', 'readonly');
				tx.innerHTML= data[i].opis;
				opis.append(tx);
        		var tipSmestaja = document.createElement('th');
        		var adresa = document.createElement('th');
        		var dodatneUsluge = document.createElement('th');
        		var terminskiPlanCena = document.createElement('th');
        		var dugmeZaTerminskiPlanCena = document.createElement('button');
        		dugmeZaTerminskiPlanCena.innerHTML = "Dodaj terminski plan cena";
        		dugmeZaTerminskiPlanCena.setAttribute('onclick','dodajTerminskiPlanCenaZaSobu('+data[i].idSobe+')');
        		dugmeZaTerminskiPlanCena.setAttribute('class',"w3-btn w3-brown");
        		terminskiPlanCena.append(dugmeZaTerminskiPlanCena);
        		brojSobe.innerHTML = data[i].brojSobe;
        		brojKreveta.innerHTML = data[i].brojKreveta;
        		tipSmestaja.innerHTML = data[i].nazivTipaSmestaja;
        		adresa.innerHTML = data[i].adresa.grad+","+data[i].adresa.drzava+","+data[i].adresa.ulicaIBroj;
        		
        		for(j=0;j<data[i].dodatneUsluge.length;j++){
        			dodatneUsluge.innerHTML += data[i].dodatneUsluge[j];
        			var z = data[i].dodatneUsluge.length - 1;
        			if(j<z){
        				dodatneUsluge.innerHTML += ",";
        			}
        		}
        		
        		brojSobe.setAttribute('class','tabela');
        		brojKreveta.setAttribute('class','tabela');
        		opis.setAttribute('class','tabela');
        		tipSmestaja.setAttribute('class','tabela');
        		adresa.setAttribute('class','tabela');
        		dodatneUsluge.setAttribute('class','tabela');
        		
        		redUTabeli.append(brojSobe);
        		redUTabeli.append(brojKreveta);
        		redUTabeli.append(opis);
        		redUTabeli.append(tipSmestaja);
        		redUTabeli.append(adresa);
        		redUTabeli.append(dodatneUsluge);
        		redUTabeli.append(dugmeZaTerminskiPlanCena);
        		tabelaSoba.append(redUTabeli);
        	}
        }
	});
}

function dodajTerminskiPlanCenaZaSobu(id){
	$('#modalTerminskiPlanCena').modal();
	idSobe = id;
}

function dodajTerminskiPlanCena(){
	var startDate = $('#date_added').val();
	var datumNiz = startDate.split("/");
	var datumPocetkaVazenja = new Date(Number(datumNiz[2]),Number(datumNiz[0]-1),Number(datumNiz[1]));
	var datumKrajaVazenja  = new Date();
	datumKrajaVazenja.setDate(datumPocetkaVazenja.getDate() + 30);
	var cena = $('#cena').val();
	
	var terminskiPlanCena = JSON.stringify({
		"pocetakVazenja" : datumPocetkaVazenja,
		"krajVazenja" : datumKrajaVazenja,
		"idSobe" : idSobe,
		"cena" : cena
	});
	
	$.ajax({
		async: false,
		url: "http://localhost:8081/terminskiPlanCena/addTerminskiPlanCena",
        type: "POST",
        contentType: "application/json",
        dataType : "json",
        data: terminskiPlanCena,
        success: function (data) {
        	toastr.success('Uspesno dodavanje');
        }
	});
}var idSobe;

$(document).ready(function() {
	
	var fromTimeInput = $('#date_added');
	//var toTimeInput = $('#date_modified');
	var fromTime = fromTimeInput.val();
	//var toTime = toTimeInput.val();

	fromTimeInput.datepicker({
		keyboardNavigation : false,
		forceParse : false,
		calendarWeeks : true,
		autoclose : true
		//endDate : toTime
	});
//	toTimeInput.datepicker({
//		keyboardNavigation : false,
//		forceParse : false,
//		calendarWeeks : true,
//		autoclose : true,
//		startDate : fromTime
//	});
//	fromTimeInput.on("changeDate", function(e) {
//		toTimeInput.datepicker('setStartDate', e.date);
//	});
//	toTimeInput.on("changeDate", function(e) {
//		fromTimeInput.datepicker('setEndDate', e.date);
//	});
	
})


function myRooms(){
	var tabelaSoba = document.getElementById('tabelaSobe');
	$('#modalMojeSobe').modal();
	
	//preuzimam sve sobe koje se vode na ulogovanog agenta
	$.ajax({
		async: false,
		url: "http://localhost:8081/agent/getAllRooms",
        type: "GET",
        beforeSend: function(request) {
		    request.setRequestHeader("Authorization", localStorage.getItem('token'));
		},
        dataType: "json",
        success: function (data) {
        	for(i=0;i<data.length;i++){
        		var redUTabeli = document.createElement('tr');
        		var brojSobe = document.createElement('th');
        		var brojKreveta = document.createElement('th');
        		var opis = document.createElement('th');
        		var tx=document.createElement('textarea');
        		tx.setAttribute('rows', '3');
				tx.setAttribute('cols', '30');
				tx.setAttribute('readonly', 'readonly');
				tx.innerHTML= data[i].opis;
				opis.append(tx);
        		var tipSmestaja = document.createElement('th');
        		var adresa = document.createElement('th');
        		var dodatneUsluge = document.createElement('th');
        		var terminskiPlanCena = document.createElement('th');
        		var dugmeZaTerminskiPlanCena = document.createElement('button');
        		dugmeZaTerminskiPlanCena.innerHTML = "Dodaj terminski plan cena";
        		dugmeZaTerminskiPlanCena.setAttribute('onclick','dodajTerminskiPlanCenaZaSobu('+data[i].idSobe+')');
        		dugmeZaTerminskiPlanCena.setAttribute('class',"w3-btn w3-brown");
        		terminskiPlanCena.append(dugmeZaTerminskiPlanCena);
        		brojSobe.innerHTML = data[i].brojSobe;
        		brojKreveta.innerHTML = data[i].brojKreveta;
        		tipSmestaja.innerHTML = data[i].nazivTipaSmestaja;
        		adresa.innerHTML = data[i].adresa.grad+","+data[i].adresa.drzava+","+data[i].adresa.ulicaIBroj;
        		
        		for(j=0;j<data[i].dodatneUsluge.length;j++){
        			dodatneUsluge.innerHTML += data[i].dodatneUsluge[j];
        			var z = data[i].dodatneUsluge.length - 1;
        			if(j<z){
        				dodatneUsluge.innerHTML += ",";
        			}
        		}
        		
        		brojSobe.setAttribute('class','tabela');
        		brojKreveta.setAttribute('class','tabela');
        		opis.setAttribute('class','tabela');
        		tipSmestaja.setAttribute('class','tabela');
        		adresa.setAttribute('class','tabela');
        		dodatneUsluge.setAttribute('class','tabela');
        		
        		redUTabeli.append(brojSobe);
        		redUTabeli.append(brojKreveta);
        		redUTabeli.append(opis);
        		redUTabeli.append(tipSmestaja);
        		redUTabeli.append(adresa);
        		redUTabeli.append(dodatneUsluge);
        		redUTabeli.append(dugmeZaTerminskiPlanCena);
        		tabelaSoba.append(redUTabeli);
        	}
        }
	});
}

function dodajTerminskiPlanCenaZaSobu(id){
	$('#modalTerminskiPlanCena').modal();
	idSobe = id;
}

function dodajTerminskiPlanCena(){
	var startDate = $('#date_added').val();
	var datumNiz = startDate.split("/");
	var datumPocetkaVazenja = new Date(Number(datumNiz[2]),Number(datumNiz[0]-1),Number(datumNiz[1]));
	var datumKrajaVazenja  = new Date();
	datumKrajaVazenja.setDate(datumPocetkaVazenja.getDate() + 30);
	var cena = $('#cena').val();
	
	var terminskiPlanCena = JSON.stringify({
		"pocetakVazenja" : datumPocetkaVazenja,
		"krajVazenja" : datumKrajaVazenja,
		"idSobe" : idSobe,
		"cena" : cena
	});
	
	$.ajax({
		async: false,
		url: "http://localhost:8081/terminskiPlanCena/addTerminskiPlanCena",
        type: "POST",
        contentType: "application/json",
        dataType : "json",
        data: terminskiPlanCena,
        success: function (data) {
        	toastr.success('Uspesno dodavanje');
        }
	});
}