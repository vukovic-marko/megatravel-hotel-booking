$(document).ready(function(){
	var badge = $(".badge-light");
	$.ajax({
		url: "http://localhost:8762/admin-service/admin/komentar",
    	type:"GET",
    	 success: function (data) {
    		 var b=0;
    		 for(var i=0;i<data.length;i++){
    			 var kk =data[i];
    			 if(kk.odobreno==false)
    				 b++
    		 }
        badge.text(b);
    		 
 	    	},error:function(){
 	    		
 	    	}
	});
	
	const left = document.querySelector('.left');
	const right = document.querySelector('.right');
	const container = document.querySelector('.container-custom');

	left.addEventListener('mouseenter', () => {
	  container.classList.add('hover-left');
	});

	left.addEventListener('mouseleave', () => {
	  container.classList.remove('hover-left');
	});

	right.addEventListener('mouseenter', () => {
	  container.classList.add('hover-right');
	});

	right.addEventListener('mouseleave', () => {
	  container.classList.remove('hover-right');
	});
	
	
});

function addAgent(){
	 var x = document.getElementById("addingAgent");
	  
	    x.style.display = "none";
	
}
function agentFocus(){
	
	document.getElementById('aAdd').scrollIntoView();
}
function typeFocus(){
	
	document.getElementById('typeAdd').scrollIntoView();
}
function catFocus(){
	
	document.getElementById('catAdd').scrollIntoView();
}
