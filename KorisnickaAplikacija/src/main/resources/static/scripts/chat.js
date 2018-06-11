function posaljiPoruku(primalacId) {
	$('#idPrimalac').val(primalacId);
	$("#sendMessageModal").modal('toggle');
}

function posaljiPorukuUChat(chatId) {
	sadrzaj = $('#sadrzajPoruke').val();
	$.ajax({
		async: false,
		url: "https://localhost:1234/poruka/posaljiPorukuUChat/"+chatId,
        type: "POST",
        dataType: "json",
        contentType:"text/plain",
        data:sadrzaj,
        crossDomain: true,
        xhrFields: {
            withCredentials: true
         },
        headers: {  'Access-Control-Allow-Origin': '*' },
        success: function (data) {
        	showChat(chatId);
        },
        error: function (jqxhr, textStatus, errorThrown) {
        	toastr["error"](jqxhr.responseText);
        }
	});
}

function showChat(id) {
	$.ajax({
		async: false,
		url: "https://localhost:1234/poruka/getPoruke/"+id,
        type: "GET",
        dataType: "json",
        crossDomain: true,
        xhrFields: {
            withCredentials: true
         },
        headers: {  'Access-Control-Allow-Origin': '*' },
        success: function (data) {
        	$('#divChat').empty();
        	divCnt="<h2 style=\"margin-left:5%;color:#1e1e77;\">";
        	for(j=0;j<data.korisnici.length;j++){
        		divCnt += data.korisnici[j].ime +" "+data.korisnici[j].prezime;
        		if(j!=data.korisnici.length-1){
        			divCnt+=", ";
        		}
        		
        	}
        	divCnt+="</h2><br/><br/>";
    		$('#divChat').append(divCnt);
        	
        	for(i=0;i<data.poruke.length;i++){
        		style="";
        		radius="";
        		if(data.poruke[i].poslata){
        			style="sentMessage";
        			radius="border-top-right-radius:0px;";
        		}else{
        			style="recievedMessage";
        			radius="border-top-left-radius:0px;";
        		}
        		divContent = "<div class=\"searchDiv " + style + "\" >&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp"+data.poruke[i].posiljalac.ime+"<div style=\"" + radius + "\" class=\"divMessageContent\">"+data.poruke[i].sadrzaj+
        		"</div>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp"+data.poruke[i].datum +"</div><br/><br/>";
        		$('#divChat').append(divContent);
        	}
        	divCnt = "<div><textarea style=\"margin-left:30%;width:94%;\" placeholder=\"Message...\" class=\"form-control\" rows=\"5\" id=\"sadrzajPoruke\"></textarea>"
        			+ "<br><button onclick=\"posaljiPorukuUChat("+data.id+")\" style=\"margin-right:1%;\" class=\"btn btn-light buttonSearch\">Send</button></div>"
        	$('#divChat').append(divCnt);
        	
        	$("html, body").animate({ scrollTop: $(document).height() }, 2000);
        }
	});
}


function sendMessageNew(){
	idPrimalac = $('#idPrimalac').val();
	sadrzaj = $('#messageContent').val();
	$.ajax({
		async: false,
		url: "https://localhost:1234/poruka/sendMessage/"+idPrimalac,
        type: "POST",
        dataType: "json",
        contentType:"text/plain",
        data:sadrzaj,
        crossDomain: true,
        xhrFields: {
            withCredentials: true
         },
        headers: {  'Access-Control-Allow-Origin': '*' },
        success: function (data) {
        	$("#sendMessageModal").modal('toggle');
        	$('#messageContent').val('');
        	top.location.href = "chat.html?idChat="+data.id;
        },
        error: function (jqxhr, textStatus, errorThrown) {
        	toastr["error"](jqxhr.responseText);
        }
	});
	
	
	
}
