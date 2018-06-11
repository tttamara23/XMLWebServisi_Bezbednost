
function changePasswordClick() {
	oldPassword = $('#changePasOldPas').val();
	newPassword = $('#changePasNewPas').val();
	passwordConfirm = $('#changePasPasCon').val();
	
	var data = JSON.stringify({
		"oldPassword": oldPassword,
		"newPassword": newPassword,
		"passwordConfirm": passwordConfirm
	});
	
	$.ajax({
		async: false,
		url: "https://localhost:1234/user/changePassword",
        type: "POST",
        contentType: "application/json",
        data: data,
        crossDomain: true,
        xhrFields: {
            withCredentials: true
         },
        headers: {  'Access-Control-Allow-Origin': '*' },
        success: function () {
        	logout();
        },
        error: function (jqXHR, textStatus, errorThrown) {
            toastr["error"](jqXHR.responseText);
        }
    });
}

function logout() {
    $.ajax({
    	url: "https://localhost:1234/user/logout",
        type: "POST",
        crossDomain: true,
        xhrFields: {
            withCredentials: true
         },
        success: function () {
                top.location.href = "index.html";

        }, error: function (jqxhr, textStatus, errorThrown) {
            alert(errorThrown);
        }
    });
}