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
		url: "https://localhost:1234/smestaj/getByLocation",
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
		url: "https://localhost:1234/ponudaUsluga/getByPonuda/"+idPonude,
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
		url: "https://localhost:1234/smestaj/getSmestaj/"+idSmestaja,
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
        		url: "https://localhost:1234/smestajVlasnik/getVlasnik/"+idSmestaja,
                type: "GET",
                dataType: "json",       
                crossDomain: true,
                xhrFields: {
                    withCredentials: true
                 },
                headers: {  'Access-Control-Allow-Origin': '*' },
                success: function (dataVlasnik) {
                	
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
                        success: function (dataRejting) {
		                	$('#ocenaSmestaja').empty();
		                	
			                	if(dataRejting == true){
			                		divOcena = "<h4>Please rate "+data.naziv+":</h4>"
			                			+"<input type=\"checkbox\" class=\"boxes\" value=\"1\" onclick =\"uncheckAll(btn1)\"  name=\"radioButtons\" id=\"btn1\" style=\"width:3%\"/>1&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp"
			                			+"<input type=\"checkbox\"  class=\"boxes\" value=\"2\" onclick =\"uncheckAll(btn2)\" name=\"radioButtons\" id=\"btn2\" style=\"width:3%\"/>2&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp"
			                			+"<input type=\"checkbox\" class=\"boxes\" value=\"3\" onclick =\"uncheckAll(btn3)\" name=\"radioButtons\" id=\"btn3\"/ style=\"width:3%\">3&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp"
			                			+"<input type=\"checkbox\" class=\"boxes\" value=\"4\" onclick =\"uncheckAll(btn4)\" name=\"radioButtons\" id=\"btn4\"/ style=\"width:3%\">4&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp"
			                			+"<input type=\"checkbox\"  class=\"boxes\" value=\"5\" onclick =\"uncheckAll(btn5)\" name=\"radioButtons\" id=\"btn5\"/ style=\"width:3%\">5&nbsp&nbsp&nbsp&nbsp"
			                			+"<button style=\"float:right;\" class=\"btn btn-light buttonSearch\" onclick=\"oceni("+idSmestaja+")\"  id=\"btnOceni\" >Submit</button>"
			                			+"<br/><br/>"
			                		$('#ocenaSmestaja').append(divOcena);
			                	
				                	
			                	}
					                	
                        }
                        });
                	$('#vlasnikSmestaja').empty();
                	$('#opisSmestaja').empty();
                	$('#tipSmestaja').empty();
                	$('#ratingSmestaja').empty();
                	$('#vlasnikSmestaja').append("<h4>Owners:</h4>")
                	
                	var user = 0;
                	
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
            	        success: function (dataUlogovani) {
            	        	user = 1;
                	    }
            		});
                	for(j=0;j<dataVlasnik.length;j++){
                		var divCnt =  "<p style=\"height:50px;\">"+dataVlasnik[j].vlasnikDTO.ime + " " + dataVlasnik[j].vlasnikDTO.prezime + " - " + dataVlasnik[j].vlasnikDTO.email 
        				
                		if(user === 1) {
                			$.ajax({
                    			async: false,
                    			url: "https://localhost:1234/chat/checkChat/" + dataVlasnik[j].vlasnikDTO.id,
                    	        type: "GET",
                    	        dataType: "json",
                    	        crossDomain: true,
                    	        xhrFields: {
                    	            withCredentials: true
                    	         },
                    	        headers: {  'Access-Control-Allow-Origin': '*' },
                    	        success: function (dataPoruka) {
                    	        	if(dataPoruka) {
                    	        		divCnt += "<button style=\"float:right;\" class=\"btn btn-light buttonSearch\" onclick=\"posaljiPoruku(" + dataVlasnik[j].vlasnikDTO.id + ")\">Send message</button>";
                    	        
                    	        	}
                    	        }
                			});
                    	}
                		divCnt += "</p>";
                		$('#vlasnikSmestaja').append(divCnt);
                	
                		
                	}
                	$('#nazivSmestaja').append(data.naziv);
                	$('#opisSmestaja').append("<h4>Description: </h4>"+data.opis);
                	$('#tipSmestaja').append("<h4>Type: </h4>"+data.tip.naziv);
                	for(i=0; i<data.ponude.length; i++) {
                		var newDiv = "";
                		if(i%3==0) {
                			$('#ponudaDiv').append("<div class=\"row\">");
                		}
                		newDiv += "<div class=\"col-lg-4\"><div class=\"divPonuda divSearchInput \" style=\"padding-bottom:10%\">"
                			+"<h4>" + data.ponude[i].datumOd + " - " + data.ponude[i].datumDo + "</h4>"
                			+ "<p> Number of beds: " + data.ponude[i].brojLezaja + "<br/> " + "Number of available rooms: "+ data.ponude[i].brojSlobodnihPonuda +"<br/>"
                			+ "Price: "+data.ponude[i].cena+"</p>"
                			+ "<div id=\"divUsluge" + i + "\" style=\"display:none\">asd</div>"
                		newDiv += "<a id=\"aTag" + i + "\" onclick=\"return showMoreServicesClick(" + i + ",'" + data.ponude[i].id + "')\" class=\"aTag\" style=\"background-color: #e2e9fc; color: #1e1e77\">Show services</a>";
                		
                		if(user === 1) {
                			newDiv += "<button class=\"btn btn-light buttonSearch\" onclick=\"rezervisanje("+data.ponude[i].id+")\" >Reserve</button>";
                		}
                		newDiv += "</div></div>";
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

function oceni(idSmestaja){
	var elements=document.getElementsByClassName('boxes');
	var value = null;
	for(i=0;i<elements.length;i++){
		if(elements[i].checked==true){
			value=elements[i].value;
		}
	}
	
	
	$.ajax({
		async: false,
		url: "https://localhost:1234/user/getLoggedIn",
        type: "GET",
        dataType:"json",
        crossDomain: true,
        xhrFields: {
            withCredentials: true
         },
        headers: {  'Access-Control-Allow-Origin': '*' },
        success: function (data) {
        	var userId = data.id;
        	var url2 = "http://localhost:8010/cloud-demo/us-central1/helloWorld?smestajID="+idSmestaja+"&userID="+userId+"&ocena="+value;
        	//var url = "https://localhost:1234/ocena/oceniSmestaj/"+idSmestaja;
        	$.ajax({
        		//async: false,
        		url: url2,
                type: "GET",
                crossDomain: true,
                /*xhrFields: {
                    withCredentials: true
                 },
                headers: {  'Access-Control-Allow-Origin': 'http://localhost:8010' },*/
                success: function (data) {
                	var elements = document.getElementsByClassName('boxes');
                	for(i=0;i<elements.length;i++){
                		elements[i].checked=false;
                	}
                		toastr['success']('Rating successfull');
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
function uncheckAll(id){
	var elements = document.getElementsByClassName('boxes');
	for(i=0;i<elements.length;i++){
		if(elements[i].id==id.id){
			continue;
		}else{
			elements[i].checked=false;
		}
	}
}


