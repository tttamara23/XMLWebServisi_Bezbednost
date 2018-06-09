function posaljiPoruku(primalacId) {
	$('#idPrimalac').val(primalacId);
	$("#sendMessageModal").modal('toggle');
}

function posaljiPorukuUChat(chatId) {
	sadrzaj = $('#sadrzajPoruke').val();
	$.ajax({
		async: false,
		url: "http://localhost:1234/poruka/posaljiPorukuUChat/"+chatId,
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
        }
	});
}

function showChat(id) {
	$.ajax({
		async: false,
		url: "http://localhost:1234/poruka/getPoruke/"+id,
        type: "GET",
        dataType: "json",
        crossDomain: true,
        xhrFields: {
            withCredentials: true
         },
        headers: {  'Access-Control-Allow-Origin': '*' },
        success: function (data) {
        	$('#divChat').empty();
        	divCnt="<h3 style=\"margin-left:5%;color:#1e1e77\">";
        	for(j=0;j<data.korisnici.length;j++){
        		divCnt += data.korisnici[j].ime +" "+data.korisnici[j].prezime;
        		if(j!=data.korisnici.length-1){
        			divCnt+=", ";
        		}
        		
        	}
        	divCnt+="</h3><br/>";
    		$('#divChat').append(divCnt);
        	
        	for(i=0;i<data.poruke.length;i++){
        		style="";
        		if(data.poruke[i].poslata){
        			style="style=\"margin-left:30%;margin-right:5%;padding-bottom:0.5%;\"";
        		}else{
        			style="style=\"margin-left:5%;margin-right:30%;padding-bottom:0.5%;\"";
        		}
        		divContent = "<div class=\"searchDiv\" "+style+" >"+data.poruke[i].posiljalac.ime+"<div  class=\"divSearchInput\" >"+data.poruke[i].sadrzaj+
        		"</div>"+data.poruke[i].datum +"</div><br/><br/>";
        		$('#divChat').append(divContent);
        	}
        	$('#divChat').append("<div><textarea style=\"margin-left:30%;width:72%\" placeholder=\"Message...\" class=\"form-control\" rows=\"5\" id=\"sadrzajPoruke\"></textarea></div>");
        	$('#divChat').append("<br><button onclick=\"posaljiPorukuUChat("+data.id+")\" style=\"margin-right:0%;\" class=\"btn btn-light buttonSearch\">Send</button>");
        }
	});
}