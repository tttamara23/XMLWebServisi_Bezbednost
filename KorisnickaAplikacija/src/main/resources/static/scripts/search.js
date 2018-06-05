function buttonSearchClick() {
	destination = $('#searchDestination').val();
	dateFrom = $('#searchDateFrom').val();
	dateTo = $('#searchDateTo').val();
	numberOfPersons = $('#searchNumberOfPersons').val();
	searchAccommodationType = $('#searchAccommodationType').val();
	category = $('#searchCategory').val();
	searchServices = $('#searchServices').val();
	
	if(isNaN(numberOfPersons)) {
		toastr["error"]('Number of persons must be number.');
		return;
	}
	
	var data = JSON.stringify({
		"destination": destination,
		"dateFrom": dateFrom,
		"dateTo": dateTo,
		"numberOfPersons": numberOfPersons,
		"accommodationType": searchAccommodationType,
		"category": category,
		"searchServices": searchServices,
	});
	
	//0 nije napredna
	napredna = $('#aTagShowMore').text() == 'Show advanced' ? 0 : 1;
	
	$.ajax({
		async: false,
		url: "http://localhost:1234/ponuda/search/" + napredna,
        type: "POST",
        contentType: "application/json",
        data: data,
        dataType: "json",
        crossDomain: true,
        xhrFields: {
            withCredentials: true
         },
        headers: {  'Access-Control-Allow-Origin': '*' },
        success: function (data) {
        	$('#divPonude').empty();
        	for(i=0; i<data.length; i++) {
        		newDiv = "";
        		if(i%3==0) {
        			$('#divPonude').append("<div class=\"row\">");
        		}
        		newDiv += "<div class=\"col-lg-4\"><div class=\"divPonuda divSearchInput\" style=\"padding-bottom:15%\">"
        			+ "<h1>" + data[i].lokacija + "</h1>"
        			+ "<h3><a href=\"accommodation.html?idSmestaja=" + data[i].smestajId + "\">" + data[i].smestajNaziv + "</a></h3>"
        			+"<p>" + data[i].datumOd + " - " + data[i].datumDo + "</p>"
        			
        			+"<p>" + data[i].id + "</p>"
        			
        			+ "<p> Number of beds: " + data[i].brojLezaja + "<br/> " 
        			+ "Number of available rooms: "+ data[i].brojSlobodnihPonuda +"<br/>"
        			+ "Price: "+data[i].cena+"</p>"
        			+ "<button class=\"btn btn-light buttonSearch\" onclick=\"rezervisanje(" + data[i].id + ")\">Reserve</button>"
        			+ "</div></div>";
        		if(i%3==0) {
        			$('#divPonude').append("</div>");
        		}
        		$('#divPonude').append(newDiv);
        	}
        },
        error: function (jqXHR, textStatus, errorThrown) {
            toastr["error"](jqXHR.responseText);
        }
    });
}
