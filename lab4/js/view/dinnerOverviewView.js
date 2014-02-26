var DinnerOverviewView = function (container, model) {

    this.numberOfGuests = container.find("#overviewNumberOfGuests");
    this.totalPrice = container.find("#overviewTotalPrice");
    this.menu = $('#overviewMenu');

    /*****************************************  
          Observer implementation    
    *****************************************/
    
    //Register an observer to the model
    model.addObserver(this);
    
    //This function gets called when there is a change at the model
    this.update = function(arg){
        this.numberOfGuests.html(model.getNumberOfGuests());
        this.totalPrice.html(model.getTotalMenuPrice());

        var menu = model.getFullMenu();

        menu.forEach(function (dish) {
            var price = 0;
            dish.ingredients.forEach(function (ingredient) {
                price += ingredient.price;
            });

            var el = "<div class=\"col-md-3\" style=\"margin: 20px 0; border: 2px solid #CCC;\">";
            el += "<img class=\"img-responsive center-block\" style=\"margin: 15px;\" src=\"images/"+dish.image+"\">";
            el += "<h5>"+dish.name+"</h5>";
            el += "<h6 class=\"pull-right\">"+price+" SEK</h6>";
            el += "</div>";
            $('#overviewMenu').append(el);
        });
    }
    
    //Set the inital values of the components
    this.update();
}
