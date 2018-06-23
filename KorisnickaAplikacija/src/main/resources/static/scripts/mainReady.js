$(document).ready(function () {
	$.ajax({
		async: false,
		url: "https://localhost:1234/user/getLoggedIn",
        type: "GET",
        dataType: "json",
        crossDomain: true,
        xhrFields: {
            withCredentials: true
         },
        headers: {  'Access-Control-Allow-Origin': '*' },
        success: function (data) {
        	if(data.role === "REGISTERED") {
        		top.location.href = "home.html";
        	} 
        },
        error: function (jqxhr, textStatus, errorThrown) {
        	
        }
    });
	
	$('#aTagShowMore').click(function() {
	    $('#advancedSearchDiv').slideToggle('medium', function(){
	    	$('#aTagShowMore').text($('#aTagShowMore').text() == 'Show advanced' ? 'Hide advanced' : 'Show advanced');
	    });
	    
	    return false;
	});
	
	$.ajax({
		async: false,
		url: "https://localhost:1234/smestaj/getLocations",
        type: "GET",
        dataType: "json",
        crossDomain: true,
        xhrFields: {
            withCredentials: true
         },
        headers: {  'Access-Control-Allow-Origin': '*' },
        success: function (data) {
        	for(i=0; i<data.length; i++) {
        		newDiv = "";
        		if(i%3==0) {
        			$('#divPonude').append("<div class=\"row\">");
        		}
        		newDiv += "<div class=\"col-lg-4\"><div class=\"divPonuda divSearchInput\">"
        			+ "<h1>" + data[i] + "</h1>"
        			+ "<div id=\"divPonuda" + i + "\" style=\"display:none\">asd</div>"
        			+ "<a id=\"aTag" + i + "\" onclick=\"return showMoreLocationClick(" + i + ",'" + data[i] + "')\" class=\"aTag\" style=\"background-color: #e2e9fc; color: #1e1e77\">Show accommodations</a>"
        			+ "</div></div>";
        		if(i%3==0) {
        			$('#divPonude').append("</div>");
        		}
        		$('#divPonude').append(newDiv);
        	}
        },
        error: function (jqxhr, textStatus, errorThrown) {
            
        }
    });
	
	$.ajax({
		async: false,
		url: "https://localhost:1234/usluga/getUsluge",
        type: "GET",
        dataType: "json",
        crossDomain: true,
        xhrFields: {
            withCredentials: true
         },
        headers: {  'Access-Control-Allow-Origin': '*' },
        success: function (data) {
        	for(i=0;i<data.length;i++){
        		$('#searchServices').append("<option value=\""+ data[i].id+"\">"+data[i].naziv+"</option>");
        	}
        },
        error: function (jqxhr, textStatus, errorThrown) {
            alert("asd")
        }
        
		
	});
	
	$.ajax({
		async: false,
		url: "https://localhost:1234/tipSmestaja/getSviTipovi",
        type: "GET",
        dataType: "json",
        crossDomain: true,
        xhrFields: {
            withCredentials: true
         },
        headers: {  'Access-Control-Allow-Origin': '*' },
        success: function (data) {
        	$('#searchAccommodationType').empty();
        	for(i=0;i<data.length;i++){
        		$('#searchAccommodationType').append("<option value=\""+ data[i].id+"\">"+data[i].naziv+"</option>");
        	}
        },
        error: function (jqxhr, textStatus, errorThrown) {
            
        }
	});
	
	$.ajax({
		async: false,
		url: "https://localhost:1234/kategorijaSmestaja/getSveKategorije",
        type: "GET",
        dataType: "json",
        crossDomain: true,
        xhrFields: {
            withCredentials: true
         },
        headers: {  'Access-Control-Allow-Origin': '*' },
        success: function (data) {
        	$('#searchCategory').empty();
        	for(i=0;i<data.length;i++){
        		$('#searchCategory').append("<option value=\""+ data[i].id+"\">"+data[i].kategorija+"</option>");
        	}
        },
        error: function (jqxhr, textStatus, errorThrown) {
            
        }
	});
	
})
