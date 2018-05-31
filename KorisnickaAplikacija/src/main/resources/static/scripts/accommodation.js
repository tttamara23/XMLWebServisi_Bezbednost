function showMoreLocationClick(i, data) {
	loadAccommodation(i, data);
	
	$('#divPonuda' + i).slideToggle('medium', function(){
    	$('#aTag' + i).text($('#aTag' + i).text() == 'Show accommodations' ? 'Hide accommodations' : 'Show accommodations');
    });
	
	return false;
}

function loadAccommodation(i, location) {
	$.ajax({
		async: false,
		url: "http://localhost:1234/smestaj/getByLocation",
        type: "POST",
        dataType: "json",
        contentType: "text/plain",
        data: location,
        crossDomain: true,
        xhrFields: {
            withCredentials: true
         },
        headers: {  'Access-Control-Allow-Origin': '*' },
        success: function (data) {
        	$('#divPonuda' + i).empty();
        	for(j=0; j<data.length; j++) {
        		divContent = "<i class=\"glyphicon glyphicon-home\"></i>&nbsp<a onclick=\"return showAccommodationClick(" + data[j].id + ")\" class=\"aTag\" style=\"background-color: #e2e9fc; color: #1e1e77\">" + data[j].naziv + "</a><br>";
        		$('#divPonuda' + i).append(divContent);
        	}
        	$('#divPonuda' + i).append("<br>");
        },
        error: function (jqxhr, textStatus, errorThrown) {
            alert('error');
        }
    });
}

function showMoreServicesClick(i, idPonude) {
	loadServices(i, idPonude);
	
	$('#divUsluge' + i).slideToggle('medium', function(){
    	$('#aTag' + i).text($('#aTag' + i).text() == 'Show services' ? 'Hide services' : 'Show services');
    });
	
	return false;
}

function loadServices(i, idPonude) {
	$.ajax({
		async: false,
		url: "http://localhost:1234/usluga/getByPonuda/"+idPonude,
        type: "GET",
        dataType: "json",
        crossDomain: true,
        xhrFields: {
            withCredentials: true
         },
        headers: {  'Access-Control-Allow-Origin': '*' },
        success: function (data) {
        	$('#divUsluge' + i).empty();
        	for(j=0; j<data.length; j++) {
        		divContent = "<i class=\"glyphicon glyphicon-home\"></i>&nbsp<a  class=\"aTag\" style=\"background-color: #e2e9fc; color: #1e1e77\">" + data[j].naziv + "</a><br>";
        		$('#divUsluge' + i).append(divContent);
        	}
        	$('#divUsluge' + i).append("<br>");
        },
        error: function (jqxhr, textStatus, errorThrown) {
            alert('error');
        }
    });
}

function showAccommodationClick(idSmestaja) {
	top.location.href = "accommodation.html?idSmestaja="+idSmestaja;
}

function ucitajSmestaj(idSmestaja){
	$.ajax({
		async: false,
		url: "http://localhost:1234/smestaj/getSmestaj/"+idSmestaja,
        type: "GET",
        dataType: "json",       
        crossDomain: true,
        xhrFields: {
            withCredentials: true
         },
        headers: {  'Access-Control-Allow-Origin': '*' },
        success: function (data) {
        	$('.divSearchInput').empty();
        	$('#nazivSmestaja').append(data.naziv);
        	$('#opisSmestaja').append(data.opis);
        	$('#tipSmestaja').append(data.tip);
        	for(i=0; i<data.ponude.length; i++) {
        		newDiv = "";
        		if(i%3==0) {
        			$('#ponudaDiv').append("<div class=\"row\">");
        		}
        		newDiv += "<div class=\"col-lg-4\"><div class=\"divPonuda divSearchInput\">"
        			+"<h4>" + data.ponude[i].datumOd + " - " + data.ponude[i].datumDo + "</h4>"
        			+ "<p> Number of beds: " + data.ponude[i].brojLezaja + "</p><p> " + "Number of available rooms: "+ data.ponude[i].brojSlobodnihPonuda+"</p>"
        			+ "<div id=\"divUsluge" + i + "\" style=\"display:none\">asd</div>"
        			+ "<a id=\"aTag" + i + "\" onclick=\"return showMoreServicesClick(" + i + ",'" + data.ponude[i].id + "')\" class=\"aTag\" style=\"background-color: #e2e9fc; color: #1e1e77\">Show services</a>"
        			+ "</div></div>";
        		if(i%3==0) {
        			$('#ponudaDiv').append("</div>");
        		}
        		$('#ponudaDiv').append(newDiv);
        	}
        	
        },
        error: function (jqxhr, textStatus, errorThrown) {
            alert('error');
        }

		
	});
}