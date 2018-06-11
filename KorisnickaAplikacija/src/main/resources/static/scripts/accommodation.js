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
		url: "http://localhost:1234/ponudaUsluga/getByPonuda/"+idPonude,
        type: "GET",
        dataType: "json",
        crossDomain: true,
        xhrFields: {
            withCredentials: true
         },
        headers: {  'Access-Control-Allow-Origin' : '*' },
        success: function (data) {
        	$('#divUsluge' + i).empty();
        	if(data.length == 0) {
        		$('#divUsluge' + i).append("No services.<br><br>");
        		return;
        	}
        	for(j=0; j<data.length; j++) {
        		divContent = "&nbsp<i class=\"glyphicon glyphicon-plus\"></i>" + data[j].uslugaDTO.naziv + "<br>";
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
        	
        	$.ajax({
        		async: false,
        		url: "http://localhost:1234/smestajVlasnik/getVlasnik/"+idSmestaja,
                type: "GET",
                dataType: "json",       
                crossDomain: true,
                xhrFields: {
                    withCredentials: true
                 },
                headers: {  'Access-Control-Allow-Origin': '*' },
                success: function (dataVlasnik) {
                	$('#vlasnikSmestaja').empty();
                	$('#opisSmestaja').empty();
                	$('#tipSmestaja').empty();
                	
                	$('#nazivSmestaja').append(data.naziv);
                	$('#vlasnikSmestaja').append("<h4>Owners:</h4>")
                	for(j=0;j<dataVlasnik.length;j++){
                		divCnt =  "<p style=\"height:50px;\">"+dataVlasnik[j].vlasnikDTO.ime + " " + dataVlasnik[j].vlasnikDTO.prezime + " - " + dataVlasnik[j].vlasnikDTO.email 
        				+ "<button style=\"float:right;\" class=\"btn btn-light buttonSearch\" onclick=\"posaljiPoruku("+dataVlasnik[j].vlasnikDTO.id+")\">Send message</button></p>";
                		$('#vlasnikSmestaja').append(divCnt);
                	
                		
                	}
                	$('#opisSmestaja').append("<h4>Description: </h4>"+data.opis);
                	$('#tipSmestaja').append("<h4>Type: </h4>"+data.tip.naziv);
                	for(i=0; i<data.ponude.length; i++) {
                		newDiv = "";
                		if(i%3==0) {
                			$('#ponudaDiv').append("<div class=\"row\">");
                		}
                		newDiv += "<div class=\"col-lg-4\"><div class=\"divPonuda divSearchInput \" style=\"padding-bottom:10%\">"
                			+"<h4>" + data.ponude[i].datumOd + " - " + data.ponude[i].datumDo + "</h4>"
                			+ "<p> Number of beds: " + data.ponude[i].brojLezaja + "<br/> " + "Number of available rooms: "+ data.ponude[i].brojSlobodnihPonuda +"<br/>"
                			+ "Price: "+data.ponude[i].cena+"</p>"
                			+ "<div id=\"divUsluge" + i + "\" style=\"display:none\">asd</div>"
                			+ "<a id=\"aTag" + i + "\" onclick=\"return showMoreServicesClick(" + i + ",'" + data.ponude[i].id + "')\" class=\"aTag\" style=\"background-color: #e2e9fc; color: #1e1e77\">Show services</a>"
                			+"<button class=\"btn btn-light buttonSearch\" onclick=\"rezervisanje("+data.ponude[i].id+")\" >Reserve</button>"
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
        	
        	
        	
        },
        error: function (jqxhr, textStatus, errorThrown) {
            alert('error');
        }

		
	});
}