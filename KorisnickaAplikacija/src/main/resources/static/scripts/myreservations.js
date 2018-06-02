$(document).ready(function () {
	$.ajax({
		async: false,
		url: "http://localhost:1234/user/getLoggedIn",
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
        		
        		ucitajRezervacije();
        	} else {
        		top.location.href = "index.html";
        	}
        },
        error: function (jqxhr, textStatus, errorThrown) {
            top.location.href = "index.html";
        }
    });
	

})

function ucitajRezervacije(){
	$.ajax({
		async: false,
		url: "http://localhost:1234/user/getReservations",
        type: "GET",
        dataType: "json",
        crossDomain: true,
        xhrFields: {
            withCredentials: true
         },
        headers: {  'Access-Control-Allow-Origin': '*' },
        success: function (data) {
        	for(i=0;i<data.length;i++){
	        	divContent = "<div class=\"searchDiv\">" 
		        		+"<h4 id=\"nazivSmestaja\" style=\"padding-left: 1.5%\">Naziv smeštaja: "+data[i].ponudaDTO.smestajNaziv
		        		+"</h4>"
		        		
		        		+ "<div class=\"divSearchInput\" id=\"datumRezervacije\">Datum kreiranja rezervacije: "
		        		+data[i].date+"</div>"
		        		+ "<div class=\"divSearchInput\" id=\"datumPonude\">Datum ponude: "
		        		+data[i].ponudaDTO.datumOd+" - "+data[i].ponudaDTO.datumDo+"</div>"
		        		+ "<div class=\"divSearchInput\" id=\"cenaPonude\"> Cena ponude: "
		        		+data[i].ponudaDTO.cena+"</div>"
		        		+ "<div class=\"divSearchInput\" id=\"brojLezaja\">Broj lezaja: "
		        		+data[i].ponudaDTO.brojLezaja+"</div>"
		        		+"<button style=\"margin-top:3%;margin-bottom:3%\" class=\"btn btn-warning buttonSearch\" onclick=\"otkaziRezervaciju("+data[i].id+")\">Cancel reservation</button>"
		        		+"<br/></div><br/><br/>"
		        		+"</div>";
	        	$('#homeDivID').append(divContent);
	        	}
        		
        },
        error: function (jqxhr, textStatus, errorThrown) {
            alert('error');
        }
	});
	
}


function otkaziRezervaciju(idRezervacije){
	$.ajax({
		async: false,
		url: "http://localhost:1234/rezervacija/cancelReservation/"+idRezervacije,
        type: "DELETE",
        dataType: "json",
        crossDomain: true,
        xhrFields: {
            withCredentials: true
         },
        headers: {  'Access-Control-Allow-Origin': '*' },
        success: function (data) {
        	top.location.href = "myreservations.html";
        },
        error: function (jqxhr, textStatus, errorThrown) {
            alert('error');
        }
        
		
	});
}