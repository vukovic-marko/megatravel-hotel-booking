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
	    		myOption.text =data[i];
	    		divT.append(myOption);

	    	}
	    }
	});
}

function sakriModal(){
	$('#modalSoba').modal('hide');
	////////////////////////////////salji dtosobu
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

}

function proba(){
	$.ajax({
		async: false,
		url: "http://localhost:8081/agent/a",
	    type: "GET",
	    success: function () {
	    	alert('A');
	    }

	});
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