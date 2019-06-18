function pretraziSmestajneJedinice(){
	
	var startDate = $('#datumPolaska').data('daterangepicker').startDate._d;
	var endDate = $('#datumOdlaska').data('daterangepicker').endDate._d;
	var numOfPers = $('#broj_osoba').val();
	var place = $('#mesto').val();
	
	var danDolaska = startDate.getDate();
	var mesecDolaska = startDate.getMonth() +1;
	var godinaDolaska = startDate.getFullYear();
	var datumDolaskaZaFront = "";
	if(mesecDolaska < 10 && danDolaska <10){
		datumDolaskaZaFront += godinaDolaska+"/0"+mesecDolaska+"/0"+danDolaska;
	}
	else if(mesecDolaska < 10 && danDolaska >= 10){
		datumDolaskaZaFront += godinaDolaska+"/0"+mesecDolaska+"/"+danDolaska;
	}
	else if(mesecDolaska >= 10 && danDolaska < 10){
		datumDolaskaZaFront += godinaDolaska+"/"+mesecDolaska+"/0"+danDolaska;
	}
	else {
		datumDolaskaZaFront += godinaDolaska+"/"+mesecDolaska+"/"+danDolaska;
	}
	
	var danOdlaska = endDate.getDate();
	var mesecOdlaska = endDate.getMonth() +1;
	var godnaOdlaska = endDate.getFullYear();
	var datumOdlaskaZaFront = "";
	if(mesecOdlaska < 10 && danOdlaska <10){
		datumOdlaskaZaFront += godnaOdlaska+"/0"+mesecOdlaska+"/0"+danOdlaska;
	}
	else if(mesecOdlaska < 10 && danOdlaska >= 10){
		datumOdlaskaZaFront += godnaOdlaska+"/0"+mesecOdlaska+"/"+danOdlaska;
	}
	else if(mesecOdlaska >= 10 && danOdlaska < 10){
		datumOdlaskaZaFront += godnaOdlaska+"/"+mesecOdlaska+"/0"+danOdlaska;
	}
	else {
		datumOdlaskaZaFront += godnaOdlaska+"/"+mesecOdlaska+"/"+danOdlaska;
	}
	
	var ponuda = JSON.stringify({
		"datumPolaska" : datumDolaskaZaFront,
		"datumOdlaska" : datumOdlaskaZaFront,
		"brojOsoba" : numOfPers,
		"mesto" : place
	});
	
	$.ajax({
		async: false,
		url: "http://localhost:8762/search-service/search/getAllRooms",
	    type: "POST",
	    dataType: "json",
	    contentType: "application/json",
	    data: ponuda,
	    success: function (data) {
	    	
	    }
	});
}