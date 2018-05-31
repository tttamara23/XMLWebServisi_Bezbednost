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

function showAccommodationClick(idSmestaja) {
	alert(idSmestaja);
	return false;
}