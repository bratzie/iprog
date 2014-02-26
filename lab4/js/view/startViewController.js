var StartViewController = function(view, model ) {

	view.createDinnerBtn.click(function(){
		
		document.getElementById("selectDishView").style.display = "block";
		document.getElementById("startView").style.display = "none";

	});
}