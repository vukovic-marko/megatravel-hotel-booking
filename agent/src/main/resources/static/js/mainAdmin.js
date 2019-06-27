var dodatneUsluge = [];
var expanded = false;
function proba(){
	$('#modalSlike').modal();
//alert('a');
}
function probas(){
	//$('#modalSlike').modal();
alert('a');
}

function dodajSliku(){
	 $('#file-input').trigger('click');
}
var i=0;


function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        var divT = $('#slike');
        //divT.style="display: inline;";
    	var div = document.createElement("div");
    	div.style=" border: 2px solid brown; width: 200px; height:305px;margin: 15px; display: block; margin-left: auto; margin-right: auto";
    	//div.style="background:red;   vertical-align: middle; ";

    	var image = document.createElement("img");
    	var btn = document.createElement('input');
    	btn.setAttribute('type','button');
    	var idb="bt"+i;
     	btn.setAttribute("id",idb);
     	btn.className="w3-btn w3-brown";
     	btn.style=" margin: 15px; display: block; margin-left: auto; margin-right: auto";
    	btn.setAttribute('value','Dissmiss');
    	var ids="sl"+i;
     	image.setAttribute("id",ids);
     	image.style=" margin: 15px; display: block; margin-left: auto; margin-right: auto ";
        reader.onload = function (e) {
         //   alert(e.target.result);

            $('#'+ids)
                .attr('src', e.target.result)
                .width(150)
                .height(200);
        };
        div.append(image);
        div.append(btn);
        var idd="div"+i;
     	div.setAttribute("id",idd);

      
        divT.append(div);

        $('#'+idb).on('click',function() { 
            $('#'+idd).remove();
            });

        i=i+1;
        reader.readAsDataURL(input.files[0]);

		var slika = JSON.stringify({
			"idslike": 1,
			"urlSlike" : reader.readAsDataURL(input.files[0]),
			"idSobe" : null,
		});
        
    	$.ajax({
    		async: false,
    		url: "http://localhost:8081/agent/makingImage",
	        type: "POST",
	        contentType: "application/json",
	        data: slika,
    	    success: function (data) {
    	    	//alert('AAA');
    	    }
    	});
    }
}



function addRoom(){
	$('#modalSoba').modal();
	$.ajax({
		async: false,
		url: "http://localhost:8081/agent/sviTipoviSmestaja",
	    type: "GET",
	    success: function (data) {
	    	var divT = $('#tipSobe');
	    	divT.empty();
	    	for(var i=0;i<data.length;i++){
	    		var myOption = document.createElement("option");
	    		myOption.text =data[i];
	    		divT.append(myOption);

	    	}
	    }
	});
	
	$.ajax({
		async: false,
		url: "http://localhost:8081/agent/getDodatneUsluge",
		dataType : "json",
	    type: "GET",
	    success: function (data) {
	    	dodatneUsluge = data;
	    }
	});
}

function prikaziUsluge(){
	var boxes = document.createElement('div');
	var glavniDiv = document.getElementById('divZaDodatneUsluge');
	boxes.setAttribute('id','checkboxes');
	for (i = 0; i < dodatneUsluge.length; i++) {
		var input = document.createElement('input');
		input.setAttribute('type','checkbox');
		input.setAttribute('id',dodatneUsluge[i].id);
		var labelaNaziv = document.createElement('label');
		labelaNaziv.innerHTML = dodatneUsluge[i].naziv;
		input.setAttribute('name','usluga');
		input.setAttribute('value',dodatneUsluge[i].id);
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

function reservations(){
	$('#modalRez').modal();
	var divT = $('#reze');
	divT.empty();
	var tabela=document.createElement("table");
	var red0=document.createElement("tr");
	var z1=document.createElement("th");
	var z2=document.createElement("th");
	var z3=document.createElement("th");
	var z4=document.createElement("th");
	var z5=document.createElement("th");
	var z6=document.createElement("th");
	var z7=document.createElement("th");

	z1.style=" border: 2px solid brown;padding:10px; ";
	z2.style=" border: 2px solid brown; padding:5px;";
	z3.style=" border: 2px solid brown;padding:5px; ";
	z4.style=" border: 2px solid brown;padding:5px; ";
	z5.style=" border: 2px solid brown;padding:5px; ";
	z6.style=" border: 2px solid brown;padding:5px; ";
	z7.style=" border: 2px solid brown;padding:5px; ";
	z1.innerHTML="Arrival date";
	z2.innerHTML="Departure date";
	z3.innerHTML="Number of persons";
	z4.innerHTML="Client username";
	z5.innerHTML="Grade";
	z6.innerHTML="Room id";
	z7.innerHTML="Realized";
	//z5.innerHTML="Ocena";

	red0.append(z1);
	red0.append(z2);
	red0.append(z3);
	red0.append(z4);
	red0.append(z5);
	red0.append(z6);
	red0.append(z7);
	tabela.append(red0);
	var username="nina";
	$.ajax({
		async: false,
		url: "http://localhost:8081/agent/mojeRez/"+username,////////
	    type: "GET",
	    success: function (v) {
	    	if(v.length>0){
	    	for(var i=0;i<v.length;i++){
	    		var red1=document.createElement("tr");
				var sad1=document.createElement("td");
				var sad2=document.createElement("td");
				var sad3=document.createElement("td");
				var sad4=document.createElement("td");
				var sad5=document.createElement("td");
				var sad6=document.createElement("td");

				var sad7=document.createElement("td");
				
				sad1.style=" border: 2px solid green ";
				sad2.style=" border: 2px solid green ";
				sad3.style=" border: 2px solid green ";
				sad4.style=" border: 2px solid green ";
				sad5.style=" border: 2px solid green ";
				sad6.style=" border: 2px solid green ";
				sad7.style=" border: 2px solid green ";
				//alert()
			     var myDate = v[i].datumDolaska;
			     var now = moment(myDate).format('l');
				sad1.innerHTML= now;
				myDate = v[i].datumOdlaska;
				now = moment(myDate).format('l');
				sad2.innerHTML=now;
				sad3.innerHTML=v[i].brojOsoba;
				//sad4.innerHTML=v[i].krajnjiKorisnik.username; //username
				if(v[i].ocena!=0){
				sad5.innerHTML=v[i].ocena;
				}
				
				red1.append(sad1);
				red1.append(sad2);
				red1.append(sad3);
				red1.append(sad4);
				red1.append(sad5);
				red1.append(sad6);
//				
//				$.ajax({
//					async: false,
//					url: "http://localhost:8081/agent/nadjiSobu",
//				    type: "GET",
//				    data: v[i].soba,
//				    success: function (data) {
//				    	sad6.innerHTML=data;
//				    	}
//				    });
				
				//sad6.innerHTML=v[i].soba.idSoba; //idsobe
				var today = new Date();
				var dd = today.getDate();

				var mm = today.getMonth()+1; 
				var yyyy = today.getFullYear();
				today = mm+'/'+dd+'/'+yyyy;
				if(now==today && (v[i].realizovana==false || v[i].realizovana=="" || v[i].realizovana==null)){
					var preuzmi = document.createElement("INPUT");
					preuzmi.setAttribute("type", "button");
					preuzmi.value="Realize";
					preuzmi.className="w3-btn w3-brown";
					preuzmi.setAttribute("onclick", "realizuj('"+v[i].idRezervacije+"')");
					preuzmi.style="padding:10px; margin:10px;";
					sad7.append(preuzmi);

				}else{
					sad7.innerHTML=v[i].realizovana;
				}
				red1.append(sad7);


				tabela.append(red1);

	    	}
	    }
	}
	});
	divT.append(tabela);

}

function realizuj(id){
	$.ajax({
		async: false,
		url: "http://localhost:8081/agent/realizacija/"+id,
	    type: "POST",
	    success: function (data) {
	    	reservations();
	    }
	    });
}

function sakriModal(){
	var adresa =document.getElementById('inpAdr').value;
	var idAdr=document.getElementById('idAdr').value;
	var nazTipa=document.getElementById('tipSobe').value;
	if(adresa=="" || adresa==null){
		document.getElementById('inpAdr').style.borderColor ="red";
		/////////////////////////////////////////////////////stavi neki lepi alert
	}else{ 
		$('#modalSoba').modal('hide');
		var brSobe=document.getElementById('brSobe').value;
		var brKreveta=document.getElementById('brKreveta').value;
		var opis=document.getElementById('opis').value;
		
		var dodatneUsluge = [];
	    $.each($("input[name='usluga']:checked"), function(){            
	    	dodatneUsluge.push($(this).val());
	    });
		var tipSmestaja=null;
		var adr=null;
		var usluge = [];
		//alert(brSobe+" "+brKreveta+" "+opis+" "+idAdr+" "+nazTipa)
//		$.ajax({
//			async: false,
//			url: "http://localhost:8081/agent/adresaId/"+idAdr,
//	        type: "GET",
//			contentType: "application/json",
//	        dataType: "json",
//		    success: function (data) {
//		    	adr=data;
//		    }
//		});
//		
		$.ajax({
			async: false,
			url: "http://localhost:8081/agent/typeRoomNaziv/"+nazTipa,
		    type: "GET",
		    dataType: "json",
		    contentType: "application/json",
		    success: function (data) {
		    	tipSmestaja=data.idTipa;
	    }
		});

		var soba = JSON.stringify({
			"broj_sobe": brSobe,
			"broj_kreveta" : brKreveta,
			"opis" : opis,
			"adresa" : idAdr,
			"tipSmestaja" : tipSmestaja,
			"dodatneUsluge" : dodatneUsluge
		});
		
		$.ajax({
			async: false,
			url: "http://localhost:8081/agent/addRoom",
	        type: "POST",
	        beforeSend: function(request) {
			    request.setRequestHeader("Authorization", localStorage.getItem('token'));
			},
	        contentType: "application/json",
	        data: soba,
	        success: function (data) {
	
	        }//,
//	        error: function (jqxhr, textStatus, errorThrown) {
//	            
//	        }
		});
	}
	
}

function getAdrese(){
	$('#modalAdrese').modal();
	$.ajax({
		async: false,
		url: "http://localhost:8081/agent/sveAdrese",
	    type: "GET",
	    success: function (data) {
	    	var divT = $('#adrese');
	    	divT.empty();
	    	var tabela=document.createElement("table");
			var red0=document.createElement("tr");
			var z1=document.createElement("th");
			var z2=document.createElement("th");
			var z3=document.createElement("th");
			z1.style=" border: 2px solid; padding: 15px ";
			z2.style=" border: 2px solid; padding: 15px ";
			z3.style=" border: 2px solid; padding: 15px ";
			z1.className="w3-text-brown";
			z2.className="w3-text-brown";
			z3.className="w3-text-brown";

			z1.innerHTML="State";
			z2.innerHTML="City";
			z3.innerHTML="Address and number";

			red0.append(z1);
			red0.append(z2);
			red0.append(z3);

			tabela.append(red0);
	    	for(var i=0;i<data.length;i++){
				
				var red1=document.createElement("tr");
				var sad1=document.createElement("td");
				var sad2=document.createElement("td");
				var sad3=document.createElement("td");
				
				sad1.style=" border: 2px solid; padding: 15px ";
				sad2.style=" border: 2px solid; padding: 15px ";
				sad3.style=" border: 2px solid; padding: 15px ";
				sad1.className="w3-text-brown";
				sad2.className="w3-text-brown";
				sad3.className="w3-text-brown";
				
				sad1.innerHTML=data[i].drzava;
				sad2.innerHTML=data[i].grad;
				sad3.innerHTML=data[i].ulicaIBroj;
				
				red1.append(sad1);
				red1.append(sad2);
				red1.append(sad3);
				red1.onmouseover = function() 
				{
				    this.style.backgroundColor = "lightblue";
				}
				red1.onmouseout = function() 
				{
				    this.style.backgroundColor = "white";
				}
				//red1.setAttribute("onclick", "izabranaAdresa('"+data[i].id"')");
				var slanje=data[i].drzava+"+"+data[i].grad+"+"+data[i].ulicaIBroj+"+"+data[i].id;
				red1.setAttribute("onclick", "izabranaAdresa('"+slanje+"')");

				tabela.append(red1);

	    	}
	    	divT.append(tabela);
	    }
	});

}

function izabranaAdresa(slanje){
	  $('#modalAdrese').modal('hide');
	 // alert(id);
	  var num= slanje.indexOf('+');
	  var drzava = slanje.substring(0, num);
	  slanje=slanje.substring(num+1, slanje.length);
	  num= slanje.indexOf('+');
	  var grad = slanje.substring(0, num);
	  slanje=slanje.substring(num+1, slanje.length);
	  num= slanje.indexOf('+');
	  var ulicaibroj = slanje.substring(0, num);
	  var id=slanje.substring(num+1, slanje.length);
	  if(ulicaibroj=="null"){
		  ulicaibroj="";
	  }
	  if(grad=="null"){
		  grad="";
	  }
	  if(drzava=="null"){
		  drzava="";
	  }
	 // alert(drzava+grad+ulicaibroj+" / "+id);
	  document.getElementById('inpAdr').value=ulicaibroj+" "+grad+" "+drzava;
	  document.getElementById('idAdr').value=id;

}

function numbersonly(myfield, e)
{
    var key;
    var keychar;

    if (window.event)
        key = window.event.keyCode;
    else if (e)
        key = e.which;
    else
        return true;

    keychar = String.fromCharCode(key);

    // control keys
    if ((key==null) || (key==0) || (key==8) || (key==9) || (key==13) || (key==27) )
        return true;

    // numbers
    else if ((("0123456789").indexOf(keychar) > -1))
        return true;

    else
        return false;
}
$(document).ready(function(){
	
	

});