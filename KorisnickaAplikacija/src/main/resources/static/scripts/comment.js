function ostaviKomentar(idSmestaj) {
	sadrzaj = $('#sadrzajNovogKomentara').val();
	$.ajax({
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
	});
} 