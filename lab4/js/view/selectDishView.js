var SelectDishView = function (container,model) {

	this.numberOfGuests = container.find("#numberOfGuests");
	this.totalPrice = container.find("#totalPrice");
	this.menu = container.find("#selectedMenu")

	/*****************************************  
	      Observer implementation    
	*****************************************/
	
	//Register an observer to the model
	model.addObserver(this);
	
	//This function gets called when there is a change at the model
	this.update = function(arg){
		this.numberOfGuests.html(model.getNumberOfGuests());
		this.totalPrice.html(model.getTotalMenuPrice());

		this.menu.html("");

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

        this.menu.html(el);
	}
	
	//Set the inital values of the components
	this.update();
}
