var DishViewController = function(view, model ) {

	$('#backToSelectDishView').click(function () {
		goToView('selectDishView');
	});

	$('#noGuests2').change(function() {
		model.setNumberOfGuests($('#noGuests2').val());
	});

	$('#addDish').click(function () {
		model.addDishToMenu(model.getCurrentDish());
		goToView('selectDishView');
	});

	$('#confirmDinner2').click(function () {
		goToView('dinnerOverviewView');
	});
}