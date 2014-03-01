var DishView = function (container, model) {

	this.backToSelectDishBtn = container.find("#backToSelectDishView");
	this.numberOfGuests = container.find("#numberOfGuests");
	this.totalPrice = container.find("#totalPrice");
	this.selectedMenu = container.find("#selectedMenu");
	this.pendingCost = container.find("#pendingCost");
	this.dishText = container.find("dish");
	this.preparationText = container.find("#preparationText");
	this.ingredientsList = container.find("#ingredientsList");

	var currentDish = 1;

	/*****************************************  
	      Observer implementation    
	*****************************************/

	//Register an observer to the model
	model.addObserver(this);
	
	//This function gets called when there is a change at the model
	this.update = function(arg){
		// update left column
		this.numberOfGuests.html(model.getNumberOfGuests());
		this.totalPrice.html(model.getTotalMenuPrice());
		this.currentDish = model.getCurrentDish();

		this.selectedMenu.html("");
        var menuarray = model.getFullMenu();
        var el = "";
        if(menuarray.length === 0) {
        	el += "<div class=\"menuItem row\">";
            el += "<div class=\"col-md-6\">Pending</div>";
            el += "<div class=\"col-md-4 col-md-offset-2\" style=\"text-align: right;\">0</div>";
            el += "</div>\n";
        }
        else {
        	menuarray.forEach(function (dish) {
        		var price = 0;
        		dish.ingredients.forEach(function (ingredient) {
        			price += ingredient.price;
        		});
        		price *= model.getNumberOfGuests();

        		el += "<div class=\"menuItem row\">";
        		el += "<div class=\"col-md-6\">"+dish.name+"</div>";
        		el += "<div class=\"col-md-4 col-md-offset-2\" style=\"text-align: right;\">"+price+"</div>";
        		el += "</div>\n";
        	});
        }

        this.selectedMenu.html(el);

        this.updatePendingPrice();
		this.dishInfo();
	}

    this.dishInfo = function () {
    	this.dishText.html("");
    	this.preparationText.html("");

    	currentDishInfo = model.getDish(currentDish);

    	var el = "";
    	el += "<div>";
        el += "<h2>"+currentDishInfo.name+"</h2>";
        el += "<img class=\"img-responsive center-block\" style=\"margin: 15px;\" src=\"images/"+currentDishInfo.image+"\">";
        el += "</div>\n";
    	this.dishText.html(el);

    	this.preparationText.html("<p>"+currentDishInfo.description+"</p>");

    }

    this.updatePendingPrice = function() {
		var price = 0;
    	var currentDishPending = model.getDish(currentDish);
    	currentDishPending.ingredients.forEach(function (ingredient) {
			price += ingredient.price;
		});
		price *= model.getNumberOfGuests();

		this.pendingCost.html(price);

    }

	this.update();
}