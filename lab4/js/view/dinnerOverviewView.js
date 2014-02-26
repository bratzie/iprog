var DinnerOverviewView = function (container, model) {

    this.numberOfGuests = container.find("#overviewNumberOfGuests");
    this.totalPrice = container.find("#overviewTotalPrice");
    this.menu = container.find("#overviewMenu");
    
    //Set the inital values of the components
    this.numberOfGuests.html(model.getNumberOfGuests());
    this.totalPrice.html(model.getTotalMenuPrice());

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
        console.log(menu);

        menu.forEach(function (entry) {
            var el = "<div class=\"col-md-3\">";
            el += entry.name;
            el += "</div>";
            this.menu.append(el);
        });
    }
}
