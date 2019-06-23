$(document).ready(function(){
	var tab = document.getElementById("tabelakat")
	$.ajax({
		url: "http://localhost:8762/admin-service/admin/kategorijaSmestaja",
    	type:"GET",
    	 success: function (data) {
           
    		 for(var i=0;i<data.length;i++){
    		        var kk = data[i];
    			
    				    	var row = tab.insertRow(i+1);
    				    	var cell1 = row.insertCell(0);
    				    	var cell2 = row.insertCell(1);
    				    	
    				    	
    				    	// Add some text to the new cells:
    				    	
    				    	cell1.innerHTML = kk.naziv;
    				    
    				    	cell2.innerHTML = "<button onclick=\"ukloniKat()\" id =\""+kk.id+"\" type=\"button\" class=\"btn btn-danger\">Ukloni</button>"
    				    
    		 }
    		 
 	    	},error:function(){
 	    		alert("Nije dobro")
 	    	}
	});

});



function addNewKat(){
	var ime = document.getElementById("imeK").value;
	var kat = JSON.stringify({
		"naziv":ime
	});
	$.ajax({
		async: false,
		url:"http://localhost:8762/admin-service/admin/kategorijaSmestaja",
		type:"POST",
		data:kat,
		contentType:"application/json",
		success: function(data){
			alert("Uspesno");
			window.location.reload();
		},
		error: function(){
			alert("Nije uspesno");
		}
		
		
		
	});
}


function ukloniKat(){
	var button = event.target;
	
	$.ajax({
		async: false,
		url:"http://localhost:8762/admin-service/admin/kategorijaSmestaja/"+button.id+"",
		type: "DELETE",	
		contentType: "application/json",
		success: function (){
			alert("Uspesno");
			window.location.reload();
		},
	    error: function (){
	    	alert("Ne moze se obrisati. Povezana je sa nekom od soba!");
	    }
	
	});
	
}
