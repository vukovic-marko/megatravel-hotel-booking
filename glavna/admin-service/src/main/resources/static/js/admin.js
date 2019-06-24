

function allUsers(){
	
	  var table = document.getElementById("users");  
	 
	$.ajax({
	
		url: "http://localhost:8762/admin-service/admin/korisnik",
	    type: "GET",
	    contentType:"application/json",
	    success: function (data) {
      
	    	for(var i=0;i<data.length;i++){
	    		
	    	
              var kk = data[i];
		if(kk.uklonjen!=true){
		    	var row = table.insertRow(i);
		    	var cell1 = row.insertCell(0);
		    	var cell2 = row.insertCell(1);
		    	var cell3 = row.insertCell(2);
		    	var cell4 = row.insertCell(3);
		    	var cell5 = row.insertCell(4);
		    	
		    	// Add some text to the new cells:
		    	
		    	cell1.innerHTML = kk.idKorisnika;
		    	cell2.innerHTML = kk.ime;
		    	cell3.innerHTML = kk.prezime;
		    	cell4.innerHTML = "<button name = \""+kk.idKorisnika+"\" onclick=\"ukloniFunction()\" id =\""+kk.username+"\" type=\"button\" class=\"btn btn-danger\">Ukloni</button>"
		    	if(kk.blokiran)
		    		cell5.innerHTML = "<button onclick=\"odblokirajFunction()\" id =\""+kk.username+"\" type=\"button\" class=\"btn btn-primary\">Odblokiraj</button>"
		    		else
		    			cell5.innerHTML = "<button onclick=\"blokirajFunction()\" id =\""+kk.username+"\" type=\"button\" class=\"btn btn-danger\">Blokiraj</button>"
				    			
		}
	    	}
	    	

	    	}
	    
	});
	

	
}

$(document).ready(function(){
	allUsers();
});

function ukloniFunction(){

	 var button = event.target;
	   
	    $.ajax({
	    	url: "http://localhost:8762/admin-service/admin/korisnik/"+button.id+"/delete/true",
	    	type:"DELETE",
	    	 success: function () {
	 	    	alert("Deleted"+button.id)

	 	    	},error:function(){
	 	    		alert("Error")
	 	    	}
	 	    
	    	
	    	
	    });
	 
}
function blokirajFunction(){
	
	 var button = event.target;
	   
	    $.ajax({
	    	url: "http://localhost:8762/admin-service/admin/korisnik/"+button.id+"/block/true",
	    	type:"POST",
	   
	    	 success: function () {
	 	    	alert("Blokiran: "+button.id)
	 	    window.location = window.location; 
	 	    	
	 	    	},error:function(){
	 	    		alert("Nije dobro")
	 	    	}
	 	    
	    	
	    });
	  
	  	
	   
	   
}
function odblokirajFunction(){
	
	
	var button = event.target;
	
	   
	    $.ajax({
	    	url: "http://localhost:8762/admin-service/admin/korisnik/"+button.id+"/block/false",
	    	type:"POST",
	  
	    	 success: function () {
	 	    	alert("Odblokiran: "+button.id)
	 	    	window.location=window.location;
	 	    	},error:function(){
	 	    		alert("Nije dobro")
	 	    	}
	 	    
	    	
	    	
	    });
	
    		       
	  
}
function goToUsers(){
	window.location = "/users.html"
}

