$(document).ready(function() {
	$('#formaagentreg').submit(function (e) {
		e.preventDefault();
		
		var username = document.getElementById("username").value;

		$.ajax({
			url: "http://localhost:8762/admin-service/admin/register/"+username,
		    type:"GET",
		    
		   contentType: 'application/json; charset=utf-8',
		    success: function (data){
		    	if(data==false)
		    	upisiAgenta();
		    	else if(data==true)
		    		alert("POSTOJI");
		    	else 
		    		alert(data);
		    },
		    error: function(){
		    	alert("pukao ovde ");
		    }
		});
	});
});

function upisiAgenta(){
	var ime = document.getElementById("name").value;
	var prezime = document.getElementById("surname").value;
	var username = document.getElementById("username").value;
	var pass = document.getElementById("pwd").value;	
	var agent = JSON.stringify({
		
		"ime" : ime,
		"prezime" : prezime,
		"username" :username,
	    "password" : pass	    
	});
	$.ajax({
		url: "http://localhost:8762/admin-service/admin/register",
		type: "POST",
		data:agent,
		contentType: 'application/json',
		success: function(){
			alert("Uspesno dodat");
			window.location.reload();
		},
		error : function(){
			alert("Neuspesno dodat");			
		}
	});
}