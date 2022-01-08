function parClicked(event) {
	event.target.innerHTML = "paragraphe cliqué";
}
function buttonClicked(event) {
	console.log("button clicked");
	
const para = Array.from(document.querySelectorAll(".c1"));
for (const par of para) { 
	
	par.innerHTML="paragraphe";
}
	
}
const para = Array.from(document.querySelectorAll(".c1"));
for (const par of para) {
	par.addEventListener("click", parClicked);
}
const btnClear = document.querySelector("#idClear");
btnClear.addEventListener("click", buttonClicked);