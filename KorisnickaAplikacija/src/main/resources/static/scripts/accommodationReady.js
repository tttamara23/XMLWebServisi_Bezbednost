$(document).ready(function () {
	var url_string = window.location.href;
	var url = new URL(url_string);
	var idSmestaja = url.searchParams.get("idSmestaja");
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
        		
        		$("#tabProfileName").text(data.name);
        		var url_string = window.location.href;
        		var url = new URL(url_string);
        		var idSmestaja = url.searchParams.get("idSmestaja");
        		ucitajSmestaj(idSmestaja);
        	} else {
        		top.location.href = "index.html";
        	}
        },
        error: function (jqxhr, textStatus, errorThrown) {
            top.location.href = "index.html";
        }
    });
	
	$.ajax({
		async: false,
		url: "https://localhost:1234/komentar/getBySmestaj/"+idSmestaja,
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
        		url: "https://localhost:1234/user/checkReservations/"+idSmestaja,
        		type: "POST",
                contentType:"application/json",
                crossDomain: true,
                xhrFields: {
                    withCredentials: true
                 },
                headers: {  'Access-Control-Allow-Origin': '*' },
                success: function (data) {
                	if(data) {
                		if(data) {
                			addCom = "<div class=\"row textTag\" style=\"padding-left:2%;padding-bottom:8%;width:50%;\">"
                				+ "<label class=\"searchLabel\">Add New Comment</label>"
                				+ "<textarea placeholder=\"Type your comment here\" class=\"form-control\" rows=\"3\" id=\"sadrzajNovogKomentara\" name=\"sadrzajKom\"></textarea>"
                				+ "<br><button onclick=\"ostaviKomentar("+idSmestaja+")\" style=\"margin-right:1%;\" class=\"btn btn-light buttonSearch\">Submit</button>"
                				+ "</div>";
                			$('#newCommentDiv').append(addCom);
                		}
                	}
                }
        	});
        	
        	for(i=0; i<data.length; i++) {
        		datum = data[i].datumKomentara.substring(0, 19);
        		newCom = "<div class=\"row textTag\" style=\"padding-left:2%;width:50%;\">"
        			+ "<div class=\"col-lg-8\">" +data[i].imeAutora + "&nbsp" + data[i].prezimeAutora + ":</div>"
        			+ "<div class=\"col-lg-4\">" + datum + "</div>"
        			+ "</div>"
        			+ "<div class=\"divMessageContent commentStyle\">" + data[i].opis + "</div>";
        		$('#commentsDiv').append(newCom);
        	}
        },
        error: function (jqxhr, textStatus, errorThrown) {
        	
        }
    });
	
	
	$.ajax({
		async: false,
		url: "https://localhost:1234/slika/getBySmestaj/" + idSmestaja,
        type: "GET",
        dataType: "json",
        crossDomain: true,
        xhrFields: {
            withCredentials: true
         },
        headers: {  'Access-Control-Allow-Origin': '*' },
        success: function (data) {
        	imageContent = "<div class=\"container\">";
        	
        	for(i=0; i<data.length; i++) {
        		number = i+1;
        		imageContent += "<div class=\"mySlides\">"
        			+ "<div class=\"numbertext\">" + number + " / " + data.length + "</div>"
        			+ "<img src=\"" + data[i].url + "\" style=\"width:100%;height:290px;\">"
        			+ "</div>";
        	}
        	imageContent += "<a class=\"prev\" onclick=\"plusSlides(-1)\">&#10094;</a>";
        	imageContent += "<a class=\"next\" onclick=\"plusSlides(1)\">&#10095;</a>";
        	imageContent += "<div class=\"caption-container\">";
        	imageContent += "<p id=\"caption\"></p>";
        	imageContent += "</div>";
        	
        	imageContent += "<div class=\"row\" style=\"padding-left:5%;padding-right:5%;\">";
        	for(i=0; i<data.length; i++) {
        		number = i+1;
        		imageContent += "<div class=\"column\">"
        			+ "<img class=\"demo cursor\" src=\"" + data[i].url +"\" style=\"width:100%;height:50px;\" onclick=\"currentSlide(" + number + ")\">"
        			+ "</div>";
        	}
        	
        	imageContent += "</div>";
        	imageContent += "</div>";
        	$('#divImages').append(imageContent);
        	if(data.length != 0) {
        		showSlides(1);
        	}
        },
        error: function (jqxhr, textStatus, errorThrown) {
            
        }
    });
	
	var url = "http://localhost:8010/cloud-demo/us-central1/findRating?smestajID="+idSmestaja;
	//var url = "https://localhost:1234/ocena/oceniSmestaj/"+idSmestaja;
	$.ajax({
		//async: false,
		url: url,
        type: "GET",
        dataType: "json",
        crossDomain: true,
        /*xhrFields: {
            withCredentials: true
         },
        headers: {  'Access-Control-Allow-Origin': 'http://localhost:8010' },*/
        success: function (data) {
        	$('#ratingSmestaja').append("<h4>Rating: </h4>"+data[0].rating);
        },
        error: function (jqxhr, textStatus, errorThrown) {
            alert(errorThrown);
        }
	});
	
			
})
