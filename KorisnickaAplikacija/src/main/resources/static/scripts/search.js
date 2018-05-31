function buttonSearchClick() {
	destination = $('#searchDestination').val();
	dateFrom = $('#searchDateFrom').val();
	dateTo = $('#searchDateTo').val();
	numberOfPersons = $('#searchNumberOfPersons').val();
	searchAccommodationType = $('#searchAccommodationType').val();
	category = $('#searchCategory').val();
	searchServices = $('#searchServices').val();
	
	var data = JSON.stringify({
		"destination": destination,
		"dateFrom": dateFrom,
		"dateTo": dateTo,
		"numberOfPersons": numberOfPersons,
		"searchAccommodationType": searchAccommodationType,
		"category": category,
		"searchServices": searchServices,
	});
	
}
