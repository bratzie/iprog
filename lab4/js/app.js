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
   	var dinnerOverviewView = new DinnerOverviewView($("#dinnerOverviewView"),model);
   	var dinnerOverviewViewController = new DinnerOverviewViewController(dinnerOverviewView,model);
   	var dinnerPreparationView = new DinnerPreparationView($("#dinnerPreparationView"),model);
   	var dinnerPreparationViewController = new DinnerPreparationViewController(dinnerPreparationView,model);
   	var dishView = new DishView($("#dishView"),model);
   	var dishViewController = new DishViewController(dishView,model);
   });

function goToView(id){
	$('.container').css('display', 'none');
	$('#'+id).css('display', 'block');
	console.log('going to view: '+id);
}