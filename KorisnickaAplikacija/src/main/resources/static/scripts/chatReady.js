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
		url: "http://localhost:1234/chat/findAllByKorisniciId",
        type: "GET",
        dataType: "json",
        crossDomain: true,
        xhrFields: {
            withCredentials: true
         },
        headers: {  'Access-Control-Allow-Origin': '*' },
        success: function (data) {
        	for(i=0; i<data.length; i++){
        		newChat = "<div class=\"divSearchInput\"><a class=\"aTagChat\" onclick=\"return showChat(" + data[i].id + ")\"><h4>";
        		for(j=0; j<data[i].korisnici.length; j++) {
        			newChat += data[i].korisnici[j].ime + " " + data[i].korisnici[j].prezime;
	        	
        		}
        		newChat += "</h4></a></div><br>";
        		$('#divAllChats').append(newChat);
        	}
        },
        error: function (jqxhr, textStatus, errorThrown) {
            alert(errorThrown);
        }
		
	});
		
})