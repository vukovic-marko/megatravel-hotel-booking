$(document).ready(function(){
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
