

function logujSe(){
	var user = {};
	user.username = $('#login').val();
	user.password = $('#password').val();
	console.log(user);
	
	$.ajax({
		url: 'http://localhost:8762/auth',
		type: 'post',
		contentType : 'application/json',
		data: JSON.stringify(user),
		success: function (data,status,xhr) {
			alert('A');
			var token = xhr.getResponseHeader("Authorization");
			console.log(token);
			localStorage.setItem('token', token);
			podesiStranicu();
		},
		statusCode : {
			401 : function() {
				alert('Ne postoji nalog sa unetim podacima!');
			}
		},
		error :function(){alert('B');}
	});
}
function podesiStranicu() {

	if (localStorage.getItem('token') != null) {
		// ulogovan
		$.ajax({
			url: 'http://localhost:8762/hotel-service/hotel/uloga',
			type: 'get',
			beforeSend: function(request) {
			    request.setRequestHeader("Authorization", localStorage.getItem('token'));
			},
			success: function (data) {
				if (data) {
					// ulogovan je korisnik sa ulogom 'KRAJNJI'
					window.location.href="./mainAgent.html";
					
				} else {
					// ulogovan je korisnik sa ulogom 'AGENT' ili 'ADMIN'
					
					alert('Ovo je aplikacija agentima!');
					
					//localStorage.removeItem('token');

				}
			}
		})
	}
}