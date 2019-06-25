function myRooms(){
	var tabelaSoba = document.getElementById('tabelaSobe');
	$('#modalMojeSobe').modal();
	
	//preuzimam sve sobe koje se vode na ulogovanog agenta
	$.ajax({
		async: false,
		url: "http://localhost:8081/agent/getAllRooms",
        type: "GET",
        dataType: "json",
        success: function (data) {
        	for(i=0;i<data.length;i++){
        		var redUTabeli = document.createElemenet('tr');
        		var brojSobe = document.createElement('th');
        		var brojKreveta = document.createElement('th');
        		var opis = document.createElement('th');
        		var tipSmestaja = document.createElement('th');
        		var adresa = document.createElement('th');
        		var dodatneUsluge = document.createElement('th');
        		brojSobe.innerHTML = data[i].brojSobe;
        		brojKrevetea.innerHTML = data[i].brojKreveta;
        		opis.innerHTML = data[i].opis;
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
        		tabelaSoba.append(redUTabeli);
        	}
        }
	});
}