var DinnerPreparationView = function (container, model) {

    this.numberOfGuests = container.find("#preparationNumberOfGuests");
    this.menu = container.find("#preparationMenu");

    /*****************************************  
          Observer implementation    
    *****************************************/
    
    //Register an observer to the model
    model.addObserver(this);
    
    //This function gets called when there is a change at the model
    this.update = function(arg){
        this.numberOfGuests.html(model.getNumberOfGuests());

        this.menu.html("");

        var menuarray = model.getFullMenu();
        var el = "";
        menuarray.forEach(function (dish) {
            el += "<div class=\"row\" style=\"margin: 20px; border: 2px solid #CCC;\">";

            el += "<div class=\"col-md-2\">";
            el += "<img class=\"img-responsive center-block\" style=\"margin: 15px;\" src=\"images/"+dish.image+"\">";
            el += "</div>";

            el += "<div class=\"col-md-4\">";
            el += "<h2>"+dish.name+"</h2>";

            el += "<ul>"
            dish.ingredients.forEach(function (ingredient) {
                el += "<li>"+(ingredient.quantity*model.getNumberOfGuests())+(ingredient.unit!="" ? " "+ingredient.unit+" of " : " ")+ingredient.name+"</li>";
            });
            el += "</ul>"

            el += "</div>";

            el += "<div class=\"col-md-6\">";
            el += "<h2>Preparation</h2>";
            el += "<p>"+dish.description+"</p>";
            el += "</div>";

            el += "</div>\n";
        });

        this.menu.html(el);
    }
    
    //Set the inital values of the components
    this.update();
}
