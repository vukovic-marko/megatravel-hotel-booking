var listaUsluga = [];
var expanded = false;
$(document).ready(function() {
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
})

function prikaziUsluge() {
	var boxes = document.createElement('div');
	var glavniDiv = document.getElementById('glavniDiv');
	glavniDiv.setAttribute('class','checkboxes');
	boxes.setAttribute('id','checkboxes');
	for (i = 0; i < listaUsluga.length; i++) {
		var labelaNaziv = document.createElement('label');
		var input = document.createElement('input');
		input.setAttribute('type','checkbox');
		input.setAttribute('id',listaUsluga[i].id);
		input.setAttribute('name','usluga');
		labelaNaziv.innerHTML = listaUsluga[i].naziv;
		input.setAttribute('value',listaUsluga[i].naziv);
		boxes.append(input);
		boxes.append(labelaNaziv);	
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

	/*var danDolaska = startDate.getDate();
	var mesecDolaska = startDate.getMonth() + 1;
	var godinaDolaska = startDate.getFullYear();
	var datumDolaskaZaFront = "";
	if (mesecDolaska < 10 && danDolaska < 10) {
		datumDolaskaZaFront += godinaDolaska + "/0" + mesecDolaska + "/0"
				+ danDolaska;
	} else if (mesecDolaska < 10 && danDolaska >= 10) {
		datumDolaskaZaFront += godinaDolaska + "/0" + mesecDolaska + "/"
				+ danDolaska;
	} else if (mesecDolaska >= 10 && danDolaska < 10) {
		datumDolaskaZaFront += godinaDolaska + "/" + mesecDolaska + "/0"
				+ danDolaska;
	} else {
		datumDolaskaZaFront += godinaDolaska + "/" + mesecDolaska + "/"
				+ danDolaska;
	}*/

	/*var danOdlaska = endDate.getDate();
	var mesecOdlaska = endDate.getMonth() + 1;
	var godnaOdlaska = endDate.getFullYear();
	var datumOdlaskaZaFront = "";
	if (mesecOdlaska < 10 && danOdlaska < 10) {
		datumOdlaskaZaFront += godnaOdlaska + "/0" + mesecOdlaska + "/0"
				+ danOdlaska;
	} else if (mesecOdlaska < 10 && danOdlaska >= 10) {
		datumOdlaskaZaFront += godnaOdlaska + "/0" + mesecOdlaska + "/"
				+ danOdlaska;
	} else if (mesecOdlaska >= 10 && danOdlaska < 10) {
		datumOdlaskaZaFront += godnaOdlaska + "/" + mesecOdlaska + "/0"
				+ danOdlaska;
	} else {
		datumOdlaskaZaFront += godnaOdlaska + "/" + mesecOdlaska + "/"
				+ danOdlaska;
	}*/
    if(dodatneUsluge==null){
		var ponuda = JSON.stringify({
			"datumPolaska" : startDate,
			"datumOdlaska" : endDate,
			"brojOsoba" : numOfPers,
			"mesto" : place
		});
    }
    else {
    	var ponuda = JSON.stringify({
			"datumPolaska" : startDate,
			"datumOdlaska" : endDate,
			"brojOsoba" : numOfPers,
			"mesto" : place,
			"nazivDodatneUsluge" : dodatneUsluge
		});
    }

	$.ajax({
		async : false,
		url : "http://localhost:8762/search-service/search/getAllRooms",
		type : "POST",
		dataType : "json",
		contentType : "application/json",
		data : ponuda,
		success : function(data) {

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
