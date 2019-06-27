$(document).ready(function(){
	  var table = document.getElementById("res");  
	  var today = new Date();
	  var dd = String(today.getDate()).padStart(2, '0');
	  var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
	  var yyyy = today.getFullYear();

	  today =yyyy+'-'+mm+'-'+dd;
	  alert(today);
	 
	  
	$.ajax({
		url:"http://localhost:8762/reservation-service/reservation/findRes/jkljklj",
		type:"GET",
	  
		success: function(data){
		
			for(var i=0;i<data.length;i++){
	    	
		    	
	              var kk = data[i];
	              if(data[i].datumOdlaska<=today){
			
			    	var row = table.insertRow(i+1);
			    	var cell1 = row.insertCell(0);
			    	var cell2 = row.insertCell(1);
			        var cell3 = row.insertCell(2);
			
			    	// Add some text to the new cells:
			    	
			    	cell1.innerHTML = kk.datumDolaska;
			    	cell2.innerHTML = kk.datumOdlaska;
			    	if(kk.ocena==null){
			     	cell3.innerHTML = "<div class=\"my-rating-6\"></div>";
			    	}
			    	else
			    	cell3.innerHTML = "OVAJ SMESTAJ STE OCENILI OCENOM:  "+kk.ocena;
			    	
			   	 $(".my-rating-6").starRating({
					  totalStars: 5,
					  emptyColor: 'lightgray',
					  hoverColor: 'salmon',
					  activeColor: 'cornflowerblue',
					  initialRating: 4,
					  strokeWidth: 0,
					  useGradient: false,
					  callback: function(currentRating, $el){
					
						  $.ajax({
							  url:"http://localhost:8762/reservation-service/reservation/review/"+kk.idRezervacije+"/"+currentRating,
							  type:"POST",
							  success:function(){alert("Uspesno");document.location.reload();},
							  error:function(){}
						  });
					   
					  
					  }
					});
				  
	              }	
		    	}
			
		    	
			
		},error:function(){alert("greska");}
	});

});

