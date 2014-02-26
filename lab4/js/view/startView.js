var StartView = function (container,model) {

	this.createDinnerBtn = container.find("#createDinner");

}
//Register an observer to the model
	model.addObserver(this);
	
	//This function gets called when there is a change at the model
	this.update = function(arg){
	}