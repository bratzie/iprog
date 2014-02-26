var DinnerOverviewViewController = function(view, model) {
	$('#backToDinner').click(function () {
		goToView('selectDishView');
	});
	$('#print').click(function () {
		goToView('dinnerPreparationView');
	});
}