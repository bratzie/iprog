var SelectDishViewController = function(view, model ) {
	$('#confirmDinner').click(function () {
		goToView('dinnerOverviewView');
	});

	$('#noGuests').change(function() {
		model.setNumberOfGuests($('#noGuests').val());
	});

	$('#search').keyup(function() {
		view.search();
	});

	$('#courseType').change(function() {
		view.search();
	});
}