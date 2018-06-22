function ostaviKomentar(idSmestaj) {
	sadrzaj = $('#sadrzajNovogKomentara').val();
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
        	var url2 = "http://localhost:8010/cloud-demo/us-central1/comment?smestajID="+idSmestaj+"&userID="+userId;
        	//var url = "https://localhost:1234/ocena/oceniSmestaj/"+idSmestaja;
        	$.ajax({
        		//async: false,
        		url: url2,
                type: "POST",
                contentType:"text/plain",
                crossDomain: true,
                data:sadrzaj,
                /*xhrFields: {
                    withCredentials: true
                 },
                headers: {  'Access-Control-Allow-Origin': 'http://localhost:8010' },*/
                success: function (data) {
                	toastr["success"]("Your comment has been submitted and it is awaiting moderation.");
            		$('#sadrzajNovogKomentara').val('');
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

	
	
	/*$.ajax({
		async: false,
		url: "https://localhost:1234/komentar/comment/"+idSmestaj,
		type: "POST",
        contentType:"text/plain",
        dataType:"json",
        crossDomain: true,
        data:sadrzaj,
        xhrFields: {
            withCredentials: true
         },
        headers: {  'Access-Control-Allow-Origin': '*' },
        success: function (data) {
        	toastr["success"]("Your comment has been submitted and it is awaiting moderation.");
    		$('#sadrzajNovogKomentara').val('');
        },
        error: function (jqxhr, textStatus, errorThrown) {
        	toastr["error"](jqxhr.responseText);
        }
	});*/
} 