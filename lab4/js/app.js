$(function() {
	//The global variable so we can access it from other controller and views
	window.stage = "starter";
	
	//We instantiate our model
	var model = new DinnerModel();
	
	//And create the needed controllers and views
	//var exampleView = new ExampleView($("#exampleView"),model);
   	//var exampleViewController = new ExampleViewController(exampleView,model);
   	var startView = new StartView($("#startView"),model);
   	var startViewController = new StartViewController(startView,model);
   	var selectDishView = new SelectDishView($("#selectDishView"),model);
   	var selectDishViewController = new SelectDishViewController(selectDishView,model);


});

function goToSelectDishView(){
		document.getElementById("selectDishView").style.display = "block";
		document.getElementById("startView").style.display = "none";
}
