var dishViewController = function(view, model ) {

	view.backToSelectDishBtn.click(function(){
		
		goToView('selectDishView');

	});

	$('#confirmDinner2').click(function () {
		goToView('dinnerOverviewView');
	});
}
}