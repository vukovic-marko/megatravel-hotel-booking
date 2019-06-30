function porukeModal() {
	$.ajax({
		url: "http://localhost:8762/reservation-service/reservation/poruke",
        type: "get",
        beforeSend: function(request) {
		    request.setRequestHeader("Authorization", localStorage.getItem('token'));
		},
        success: function (data) {
        	$('#modalPorukeBody').empty();
        	$('#modalPorukeBody').append('<ul>');
        	
        	for (var i = 0; i < data.length; i++) {
        	    console.log(data[i].agentPosiljac.username);
        	    console.log(data[i].sadrzaj);
        	    
        	    $('#modalPorukeBody').append('<li>');
        	    $('#modalPorukeBody').append(data[i].agentPosiljac.username + ': ' + data[i].sadrzaj);
        	            	    
        	    $('#modalPorukeBody').append('</li>');
        	    
        	}
        	
        	$('#modalPorukeBody').append('</ul>');
        	
        	$('#sendMessageBtn').off('click');
        	$('#sendMessageBtn').on('click', function (e) {
        		e.preventDefault();
        		
        		let usernameMsg = $('#sendMessageUsername').val();
        		let contentMsg = $('#sendMessageContent').val();
        		let obj = {};
        		obj.username = usernameMsg;
        		obj.content = contentMsg;
        		
        		console.log(obj);
        		
        		$.ajax({
        			type:'post',
        			url: 'http://localhost:8762/reservation-service/reservation/sendMessage',
        			beforeSend: function(request) {
        			    request.setRequestHeader("Authorization", localStorage.getItem('token'));
        			},
        			contentType: 'application/json',
        			data: JSON.stringify(obj),
        	        success: function (data) {
        	        	console.log('uspesno poslata poruka!')
        	        }
        		})
        	});
        	
        	
        	$('#modalPorukeKorisnik').modal('show');
        	
        }
	})
}