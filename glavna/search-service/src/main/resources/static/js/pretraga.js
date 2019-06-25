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
			}
		})
	})
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
		url : "http://localhost:8762/search-service/search/"+numOfPers+","+place+","+place+","+place+","+dateP+","+dateK+","+tipSmestaja+","+kategorija+","+dodatneUsluge,
		type : "GET",
		dataType : "json",
		contentType : "application/json",
		
		success : function(data) {
			toasrt["success"]('Uspesnoooo');
		}
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
