function buttonLoginClick() {
	email = $('#formLogin-email').val();
	password = $('#formLogin-password').val();
	
	if(!email || !password) {
		toastr["error"]('Fill in all required entry fields!');
		return;
	}
	
	var data = JSON.stringify({
		"email": email,
		"password": password
	});
	$.ajax({
		async: false,
		url: "http://localhost:1234/user/loginAgent",
        type: "POST",
        contentType: "application/json",
        data: data,
        crossDomain: true,
        xhrFields: {
            withCredentials: true
         },
        headers: {  'Access-Control-Allow-Origin': '*' },
        success: function () {
        	top.location.href = "home.html";
        },
        error: function (jqXHR, textStatus, errorThrown) {
            toastr["error"](jqXHR.responseText);
        }
    });
}



