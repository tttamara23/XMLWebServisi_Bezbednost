function rezervisanje(idPonude){
	$.ajax({
		async: false,
		url: "https://localhost:1234/rezervacija/reserve/"+idPonude,
        type: "POST",
        dataType:"json",
        crossDomain: true,
        xhrFields: {
            withCredentials: true
         },
        headers: {  'Access-Control-Allow-Origin': '*' },
        success: function (data) {
        	
        		top.location.href = "myreservations.html";
        	
        },
        error: function (jqXHR, textStatus, errorThrown) {
            toastr["error"](jqXHR.responseText);
        }
        
	});
}

function gotoReservations(){
	top.location.href = "myreservations.html";
}