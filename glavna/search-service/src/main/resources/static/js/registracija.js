function buttonRegisterClick(){
	var ime = $('#imeReg').val();
	var prezime = $('#przReg').val();
	var email = $('#emailReg').val();
	var password = $('#passReg').val();
	
	var osoba = JSON.stringify({
		"ime" : ime,
		"prezime" : prezime,
		"username" : email,
		"password" : password
	});
	
	$.ajax({
		url:"http://localhost:8762/admin-service/korisnik/register",
		type:"POST",
		contentType: "application/json",
		data: osoba,
		success: function(){
			top.location.href = "pretraga.html";
		}
	});
}