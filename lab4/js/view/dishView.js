var DishView = function (container, model) {

	this.backToSelectDishBtn = container.find("#backToSelectDishView");
	this.numberOfGuests = container.find("#noGuests2");
	this.totalPrice = container.find("#totalPrice");
	this.selectedMenu = container.find("#selectedMenu");
	this.pendingCost = container.find("#pendingCost");
	this.dishText = container.find("#dishText");
	this.preparationText = container.find("#preparationText");
	this.ingredientsList = container.find("#ingredientsList");

	/*****************************************  
	      Observer implementation    
	*****************************************/

	//Register an observer to the model
	model.addObserver(this);
	
	//This function gets called when there is a change at the model
	this.update = function(arg){
		// update left column
        this.numberOfGuests.val(model.getNumberOfGuests())
		this.totalPrice.html(model.getTotalMenuPrice());

		this.selectedMenu.html("");
        var menuarray = model.getFullMenu();
        var el = "";
        if(menuarray.length === 0) {
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
    	// reset html
    	this.dishText.html("");
    	this.preparationText.html("");
    	this.ingredientsList.html("");

    	// get the current dish
    	currentDishInfo = model.getDish(model.getCurrentDish());

    	// construct html for image and name of dish
    	var e = "";
    	e += "<div>";
        e += "<h2>"+currentDishInfo.name+"</h2>";
        e += "<img class=\"img-responsive center-block\" style=\"margin: 5px; width: 70%; height: 70%;\" src=\"images/"+currentDishInfo.image+"\">";
        e += "</div>\n";
    	this.dishText.html(e);

    	// add description of the dish
    	this.preparationText.html("<p>"+currentDishInfo.description+"</p>");

    	// add ingredients of the dish
    	var el = "";
    	el += "<div>";
        el += "<h2>"+currentDishInfo.name+" for "+model.getNumberOfGuests()+" guests</h2>";
        el += "<hl />";
        
        el += "<ul>";
        currentDishInfo.ingredients.forEach(function (ingredient) {
            el += "<li>"+(ingredient.quantity*model.getNumberOfGuests())+(ingredient.unit!="" ? " "+ingredient.unit+" of " : " ")+ingredient.name+"</li>";
        });
        el += "</ul>";

        el += "</div>";
    	this.ingredientsList.html(el);
    }

    this.updatePendingPrice = function() {
		var price = 0;
    	var currentDishPending = model.getDish(model.getCurrentDish());
    	currentDishPending.ingredients.forEach(function (ingredient) {
			price += ingredient.price;
		});
		price *= model.getNumberOfGuests();

		this.pendingCost.html("<b>"+price+"</b>");

    }

	this.update();
}