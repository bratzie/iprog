var DinnerOverviewView = function (container, model) {

    this.numberOfGuests = container.find("#overviewNumberOfGuests");
    this.totalPrice = container.find("#overviewTotalPrice");
    this.menu = container.find("#overviewMenu");

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
        menuarray.forEach(function (dish) {
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
        });

        this.menu.html(el);
    }
    
    //Set the inital values of the components
    this.update();
}
