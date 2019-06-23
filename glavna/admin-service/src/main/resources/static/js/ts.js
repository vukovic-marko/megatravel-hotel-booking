$(document).ready(function(){
	var tab = document.getElementById("tabelasmestaja")
	$.ajax({
		url: "http://localhost:8762/admin-service/admin/tipSmestaja",
    	type:"GET",
    	 success: function (data) {
           
    		 for(var i=0;i<data.length;i++){
    		        var kk = data[i];
    			
    				    	var row = tab.insertRow(i+1);
    				    	var cell1 = row.insertCell(0);
    				    	var cell2 = row.insertCell(1);
    				    	
    				    	
    				    	// Add some text to the new cells:
    				    	
    				    	cell1.innerHTML = kk.naziv;
    				    
    				    	cell2.innerHTML = "<button onclick=\"return ukloniSmestaj()\" id =\""+kk.idTipa+"\" type=\"button\" class=\"btn btn-danger\">Ukloni</button>"
    				    
    		 }
    		 
 	    	},error:function(){
 	    		alert("Nije dobro")
 	    	}
	});
	
});
function addNewType(){
	var ime = document.getElementById("imeS").value;
	var ts = JSON.stringify({
		"naziv":ime
		
	});
	$.ajax({
		async: false,
		url: "http://localhost:8762/admin-service/admin/tipSmestaja",
        type: "POST",
        contentType: "application/json",
        data: ts,
        success: function (data) {
        alert("Uspesno");
        },
        error: function (jqxhr, textStatus, errorThrown) {
            
        }
	});
	window.location.reload();
}

function ukloniSmestaj(){
	var button = event.target;
	
	$.ajax({
		async: false,
		url:"http://localhost:8762/admin-service/admin/tipSmestaja/"+button.id+"",
		type: "DELETE",	
		contentType: "application/json",
		success: function (){
			alert("Uspesno");
			window.location.reload();
		},
	    error: function (){
	    	alert("Ne moze se obrisati. Povezan je sa nekom od soba!");
	    }
	
	});
	
}