var DishViewController = function(view, model ) {

	$('#backToSelectDishView').click(function () {
		goToView('selectDishView');
	});

	$('#noGuests').change(function() {
		model.setNumberOfGuests($('#noGuests').val());
	});

	$('#addDish').click(function () {
		model.addDishToMenu(model.getCurrentDish());
		goToView('selectDishView');
	});

	$('#confirmDinner2').click(function () {
		goToView('dinnerOverviewView');
	});
}