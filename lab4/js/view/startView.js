var StartView = function (container,model) {

	this.createDinnerBtn = container.find("#createDinner");

	//creating the layout of the view
	var div = $("<div>");
	div.html("Homelette");
	container.append(div);

}