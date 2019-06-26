$(document).ready(function(){

	
	var tab = document.getElementById("tabelaKom")
	$.ajax({
		url: "http://localhost:8762/admin-service/admin/komentar",
    	type:"GET",
    	 success: function (data) {
           
    		 for(var i=0;i<data.length;i++){
    		        var kk = data[i];
    			
    				    	var row = tab.insertRow(i+1);
    				    	var cell1 = row.insertCell(0);
    				    	var cell2 = row.insertCell(1);
    				    	
    				    	
    				    	// Add some text to the new cells:
    				    	if(kk.odobreno==false){
    				    	cell1.innerHTML = kk.sadrzaj;
    				    
    				    	cell2.innerHTML = "<button onclick=\"return odobri()\" id =\""+kk.idKomentara+"\" type=\"button\" class=\"btn btn-primary\">Odobri</button>"
    				    	}
    		 }
    		 
 	    	},error:function(){
 	    		alert("Nije dobro")
 	    	}
	});
	
});
function odobri(){
	 var button = event.target;
	   
	    $.ajax({
	    	url: "http://localhost:8762/admin-service/admin/komentar/"+button.id,
	    	type:"POST",
	    	 success: function () {
	 	    	alert("Success");
              window.location.reload();
	 	    	},error:function(){
	 	    		alert("Nije dobro")
	 	    	}
	 	    
	    	
	    	
	    });
}