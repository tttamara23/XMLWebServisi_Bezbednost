function reservisanje(idPonude){
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
        }
        
	});
}