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
        		
        		$("#tabProfileName").text(data.name);
        		
        		$.ajax({
        			
        			async: false,
        			url: "https://localhost:1234/chat/findAllByKorisniciId",
        	        type: "GET",
        	        dataType: "json",
        	        crossDomain: true,
        	        xhrFields: {
        	            withCredentials: true
        	         },
        	        headers: {  'Access-Control-Allow-Origin': '*' },
        	        success: function (data) {
        	        	for(i=0; i<data.length; i++){
        	        		newChat = "<div class=\"divSearchInput\"><a class=\"aTagChat\" onclick=\"return showChat(" + data[i].id + ")\"><h4 style=\"padding-left:6%;\" class=\"row\">";
        	        		for(j=0; j<data[i].korisnici.length; j++) {
        	        			newChat += data[i].korisnici[j].ime + " " + data[i].korisnici[j].prezime;
        	        		}
        	        		if(data[i].unseen != 0) { 
        	        			newChat += "<div id=\"divUnseenMessages" + data[i].id + "\">&nbsp(" + data[i].unseen + ")</div>";
        	        		}
        	        		newChat += "</h4></a></div>";
        	        		$('#divAllChats').append(newChat);
        	        	}
        	        	var url_string = window.location.href;
                		var url = new URL(url_string);
                		var idChat = url.searchParams.get("idChat");
                		if(idChat != null) {
                			showChat(idChat);
                		}
        	        },
        	        error: function (jqxhr, textStatus, errorThrown) {
        	            alert(errorThrown);
        	        }
        			
        		});
        		
        	} else {
        		top.location.href = "index.html";
        	}
        },
        error: function (jqxhr, textStatus, errorThrown) {
            top.location.href = "index.html";
        }
    });
	
	
	
	
		
})