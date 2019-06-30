var listaUsluga = [];
var listaTipovaSmestaja = [];
var listaKategorija = [];
var expanded = false;
var expanded2 = false;
var expanded3 = false;
$(document).ready(function() {
	
	// funkcija kojom se prikazuje odgovarajuci sadrzaj za korisnika
	// u zavisnosti od toga da li je ulogovan ili ne
	podesiStranicu();
	
	var fromTimeInput = $('#date_added');
	var toTimeInput = $('#date_modified');
	var fromTime = fromTimeInput.val();
	var toTime = toTimeInput.val();

	fromTimeInput.datepicker({
		keyboardNavigation : false,
		forceParse : false,
		calendarWeeks : true,
		autoclose : true,
		endDate : toTime
	});
	toTimeInput.datepicker({
		keyboardNavigation : false,
		forceParse : false,
		calendarWeeks : true,
		autoclose : true,
		startDate : fromTime
	});
	fromTimeInput.on("changeDate", function(e) {
		toTimeInput.datepicker('setStartDate', e.date);
	});
	toTimeInput.on("changeDate", function(e) {
		fromTimeInput.datepicker('setEndDate', e.date);
	});
	// ajax poziv za iscitavanje svih dodatnih usluga
	$.ajax({
		async : false,
		url : "http://localhost:8762/search-service/search/getAllDodatneUsluge",
		type : "GET",
		dataType : "json",
		success : function(data) {
				listaUsluga = data;
		}
	});
	
	$.ajax({
		async : false,
		url : "http://localhost:8762/search-service/search/getAllTipoviSmestaja",
		type : "GET",
		dataType : "json",
		success : function(data) {
			listaTipovaSmestaja = data;
		}
	});
	
	$.ajax({
		async : false,
		url : "http://localhost:8762/search-service/search/getAllKategorije",
		type : "GET",
		dataType : "json",
		success : function(data) {
			listaKategorija = data;
		}
	});
	
	// logovanje
	$('#logovanje').click(function () {
		var user = {};
		user.username = $('#emailKorisnika').val();
		user.password = $('#lozinkaKorisnika').val();
		console.log(user);
		
		$.ajax({
			url: 'http://localhost:8762/auth',
			type: 'post',
			contentType : 'application/json',
			data: JSON.stringify(user),
			success: function (data,status,xhr) {
				var token = xhr.getResponseHeader("Authorization");
				localStorage.setItem('token', token);
				window.location.replace('');
			},
			statusCode : {
				401 : function() {
					alert('Ne postoji nalog sa unetim podacima!');
				}
			},error :function(){}
		});
	});
})

function prikaziTipoveSmestaja() {
	var boxes = document.createElement('div');
	var glavniDiv = document.getElementById('glavniDivZaTipSmestaja');
	boxes.setAttribute('id','checkboxes2');
	for (i = 0; i < listaTipovaSmestaja.length; i++) {
		var labelaNaziv = document.createElement('label');
		var input = document.createElement('input');
		input.setAttribute('type','checkbox');
		input.setAttribute('id',listaTipovaSmestaja[i].id);
		input.setAttribute('name','tipovi');
		labelaNaziv.innerHTML = listaTipovaSmestaja[i].naziv;
		input.setAttribute('value',listaTipovaSmestaja[i].naziv);
		boxes.append(input);
		boxes.append(labelaNaziv);	
		var br = document.createElement('br');
		boxes.append(br);
	}
	glavniDiv.append(boxes);
	var checkboxes = document.getElementById("checkboxes2");
	  if (!expanded2) {
	    checkboxes.style.display = "block";
	    expanded2 = true;
	  } else {
	    checkboxes.style.display = "none";
	    expanded2 = false;
	  }
}

function prikaziUsluge(){
	var boxes = document.createElement('div');
	var glavniDiv = document.getElementById('glavniDiv');
	boxes.setAttribute('id','checkboxes');
	for (i = 0; i < listaUsluga.length; i++) {
		var input = document.createElement('input');
		input.setAttribute('type','checkbox');
		input.setAttribute('id',listaUsluga[i].id);
		var labelaNaziv = document.createElement('label');
		labelaNaziv.innerHTML = listaUsluga[i].naziv;
		input.setAttribute('name','usluga');
		input.setAttribute('value',listaUsluga[i].naziv);
		boxes.append(input);
		boxes.append(labelaNaziv);
		var br = document.createElement('br');
		boxes.append(br);
	}
	glavniDiv.append(boxes);
	var checkboxes = document.getElementById("checkboxes");
	  if (!expanded) {
	    checkboxes.style.display = "block";
	    expanded = true;
	  } else {
	    checkboxes.style.display = "none";
	    expanded = false;
	  }
}

function prikaziKategorijeSmestaja(){
	var boxes = document.createElement('div');
	var glavniDiv = document.getElementById('glavniDivZaKategorijuSmestaja');
	boxes.setAttribute('id','checkboxes3');
	for (i = 0; i < listaKategorija.length; i++) {
		var input = document.createElement('input');
		input.setAttribute('type','checkbox');
		input.setAttribute('id',listaKategorija[i].id);
		var labelaNaziv = document.createElement('label');
		labelaNaziv.innerHTML = listaKategorija[i].naziv;
		input.setAttribute('name','kategorija');
		input.setAttribute('value',listaKategorija[i].naziv);
		boxes.append(input);
		boxes.append(labelaNaziv);
		var br = document.createElement('br');
		boxes.append(br);
	}
	glavniDiv.append(boxes);
	var checkboxes = document.getElementById("checkboxes3");
	  if (!expanded3) {
	    checkboxes.style.display = "block";
	    expanded3 = true;
	  } else {
	    checkboxes.style.display = "none";
	    expanded3 = false;
	  }
}

function pretraziSmestajneJedinice() {

	var $fields = $('#date_added, #date_modified, #broj_osoba, #mesto');

	var sveUneseno = allFilled($fields);

	if (!sveUneseno) {
		toastr.error('Unesite sva polja');
		return;
	}

	var startDate = $('#date_added').val();
	var endDate = $('#date_modified').val();
	var numOfPers = $('#broj_osoba').val();
	var place = $('#mesto').val();
	
	var dodatneUsluge = [];
    $.each($("input[name='usluga']:checked"), function(){            
    	dodatneUsluge.push($(this).val());
    });
  
    
    var tipSmestaja;
    var selektovano = 0;
    
    $.each($("input[name='tipovi']:checked"), function(){            
    	selektovano++;
    });
    
    $.each($("input[name='tipovi']:checked"), function(){            
    	tipSmestaja = $(this).val();
    });
    
    var kategorija;
    var selektovanaKategorija = 0;
    
    $.each($("input[name='kategorija']:checked"), function(){            
    	selektovanaKategorija++;
    });
    $.each($("input[name='kategorija']:checked"), function(){            
    	kategorija = $(this).val();
    });
    
    if(selektovano > 1) {
    	toastr.warning('Odaberite samo jedan tip smestaja');
    	return;
    }
    
    if(selektovanaKategorija > 1) {
    	toastr.warning('Odaberite samo jednu kategoriju');
    	return;
    }
    
    
	var ponuda = JSON.stringify({
		"datumPolaska" : startDate,
		"datumOdlaska" : endDate,
		"brojOsoba" : numOfPers,
		"mesto" : place,
		"nazivDodatneUsluge" : dodatneUsluge,
		"tipSmestaja" : tipSmestaja,
		"kategorija" : kategorija
	});
	
	var dateP = startDate.replace(/\//g,"_");
	var dateK = endDate.replace(/\//g,"_");

	


	$.ajax({
		async : false,
		url : "http://localhost:8762/search-service/search/getAllRooms",
		type : "POST",
	
		contentType : "application/json",
		data:ponuda,
		success : function(data) {
		
		},error: function(){alert("error");}
	});
	
	
	$.ajax({
		async : false,
		url : "http://localhost:8762/search-service/search/"+numOfPers+","+place+","+dateP+","+dateK+","+tipSmestaja+","+kategorija,
		type : "GET",

		contentType : "application/json",
		
		success : function(data) {
			//window.location.href="rooms.html";
			var divT = $('#sobe');
			divT.empty();
			for(var i=0;i<data.length;i++){
				var divZaSvakiRestoran = document.createElement("div");
				var f = document.createElement("form");
				
				divZaSvakiRestoran.style=" font: 100%/1.4 Verdana, Arial, Helvetica, sans-serif;border: 2px dotted black; opacity: 0.8;background-color: lightblue;width: 400px;padding:10px; float: left; height:180px; margin:15px; margin-bottom:20px;";
				var tabelaArtikala=document.createElement("table");
				var red=document.createElement("tr");
				var pog1=document.createElement("th");
				pog1.innerHTML="Number of beds:  ";
				var sad1=document.createElement("td");
				sad1.innerHTML=data[i].brojKreveta;		
				red.append(pog1);
				red.append(sad1);
				
				var red2=document.createElement("tr");
				var pog2=document.createElement("th");
				pog2.innerHTML="Adress:  ";
				var sad2=document.createElement("td");
				sad2.innerHTML=data[i].adresa.ulicaIBroj+" "+data[i].adresa.grad+" "+data[i].adresa.drzava;
				red2.append(pog2);
				red2.append(sad2);
				
				var red3=document.createElement("tr");
				var pog3=document.createElement("th");
				pog3.innerHTML="Type:  ";
				var sad3=document.createElement("td");
				sad3.innerHTML=data[i].tipSmestaja.naziv;							
				red3.append(pog3);
				red3.append(sad3);
				
				var red4=document.createElement("tr");
				var pog4=document.createElement("th");
				var sad4=document.createElement("td");
				pog4.innerHTML="Category:  ";
				sad4.innerHTML=data[i].kategorijaSmestaja.naziv;
				red4.append(pog4);
				red4.append(sad4);
				
				var red5=document.createElement("tr");
				var pog5=document.createElement("th");
				var sad5=document.createElement("td");
				pog5.innerHTML="Grade:  ";
				if(data[i].ocena==0){
					sad5.innerHTML="Not rated yet";
				}else{
					sad5.innerHTML=data[i].ocena;
				}
				red5.append(pog5);
				red5.append(sad5);
				
				var red6=document.createElement("tr");
				var sad6=document.createElement("th");
				sad6.innerHTML="Description:  ";
				var opis = document.createElement('td');
        		var tx=document.createElement('textarea');
        		tx.setAttribute('rows', '3');
				tx.setAttribute('cols', '30');
				tx.setAttribute('readonly', 'readonly');
				tx.innerHTML= data[i].opis;
				opis.append(tx);
				red6.append(sad6);
				red6.append(opis);

				tabelaArtikala.append(red);
				tabelaArtikala.append(red2);
				tabelaArtikala.append(red3);
				tabelaArtikala.append(red4);
				tabelaArtikala.append(red5);
				tabelaArtikala.append(red6);

				
				f.append(tabelaArtikala);
				
				divZaSvakiRestoran.append(f);

				//sviResDiv.append(divZaSvakiRestoran);
				divT.append(divZaSvakiRestoran);
			}
		},
		error: function(){alert("A");}

		//}
	});
}

function allFilled() {
	var filled = true;
	$('#datumPolaska, #datumOdlaska, #broj_osoba, #mesto').each(function() {
		if ($(this).val() == '') {
			filled = false;
		}
	});
	return filled;
}
function registrujSe() {
	top.location.href = "registracija.html";
}

function ulogujSe() {
	$('#modalLogovanje').modal();
}

function podesiStranicu() {
	$('.loggedout').hide();
	$('.loggedin').hide();
	
	if (localStorage.getItem('token') != null) {
		// ulogovan
		
		$.ajax({
			url: 'http://localhost:8762/search-service/search/uloga',
			type: 'get',
			beforeSend: function(request) {
			    request.setRequestHeader("Authorization", localStorage.getItem('token'));
			},
			success: function (data) {
				if (data) {
					// ulogovan je korisnik sa ulogom 'KRAJNJI'
					
					$('.loggedin').show();
					
				} else {
					// ulogovan je korisnik sa ulogom 'AGENT' ili 'ADMIN'
					
					alert('Ovo je aplikacija namenjena krajnjim korisnicima!');
					
					localStorage.removeItem('token');
					
					$('.loggedout').show();
				}
			}
		})
		
	} else {
		// izlogovan
		
		$('.loggedin').hide();
		$('.loggedout').show();
	}
}

// logout
function izlogujSe() {
	localStorage.removeItem('token');
	window.location.replace('');
}
