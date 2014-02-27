var SelectDishView = function (container, model) {

	this.numberOfGuests = container.find("#numberOfGuests");
	this.totalPrice = container.find("#totalPrice");
	this.selectedMenu = container.find("#selectedMenu");
	this.menuChoices = container.find("#dishShower");
	this.searchKey = container.find("#search");
	this.courseType = container.find("#courseType");

	/*****************************************  
	      Observer implementation    
	*****************************************/
	
	//Register an observer to the model
	model.addObserver(this);
	
	//This function gets called when there is a change at the model
	this.update = function(arg){
		this.numberOfGuests.html(model.getNumberOfGuests());
		this.totalPrice.html(model.getTotalMenuPrice());

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
        this.search();
	}

	this.search = function() {
		this.menuChoices.html("");

        var menuarray = model.getAllDishes(this.courseType.value, "").prevObject;
        menuarray = $.map(menuarray, function(value, index) { return [value]; }); //turns it from a jquery object into an array

        var bucket = [];
        searchval = this.searchKey[0].value.toLowerCase();

        menuarray.forEach(function (dish) {
        	var bool = false;
        	dish.ingredients.forEach(function (ingredient) {
                if(ingredient.name.toLowerCase().indexOf(searchval) != -1){
	        		bool = true;
	        	}
            });
        	if(dish.name.toLowerCase().indexOf(searchval) != -1){
        		bool = true;
        	}
        	if(bool) {
        		bucket.push(dish);
        	}
        });

        menuarray = bucket;
        console.log(menuarray);

		var el = "<div class=\"row\">";
		var i;
		for(i=0; i<menuarray.length; i++) {
			var dish = menuarray[i];

			var price = 0;
            dish.ingredients.forEach(function (ingredient) {
                price += ingredient.price;
            });
            price *= model.getNumberOfGuests();

            el += "<div class=\"col-md-3\" style=\"margin: 20px; border: 2px solid #CCC;\">";
            el += "<img class=\"img-responsive center-block\" style=\"margin: 15px;\" src=\"images/"+dish.image+"\">";
            el += "<h5>"+dish.name+"</h5>";
            el += "<h6 class=\"pull-right\">"+price+" SEK</h6>";
            el += "</div>\n";

            console.log((i-1)%3);
            if((i+1)%3==0) {
            	el += "</div><div class=\"row\">";
            }
		}

		el += "</div>";

        this.menuChoices.html(el);
	}
	
	//Set the inital values of the components
	this.update();
}
