var DishView = function (container, model) {

	this.backToSelectDishBtn = container.find("#backToSelectDishView");

	//Register an observer to the model
	model.addObserver(this);
	
	//This function gets called when there is a change at the model
	this.update = function(arg){
	}

}