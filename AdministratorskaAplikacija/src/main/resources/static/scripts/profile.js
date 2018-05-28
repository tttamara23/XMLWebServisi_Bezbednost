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
        	if(data.role === "ADMIN") {
        		$("#tabProfileName").text(data.name);
        	} else {
        		top.location.href = "index.html";
        	}
        	
        },
        error: function (jqxhr, textStatus, errorThrown) {
        	if (jqxhr.status === 301) {
                top.location.href = "index.html";
            }
        }
    });
})


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
		url: "http://localhost:1234/user/changePassword",
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

function logout() {
    $.ajax({
    	url: "http://localhost:1234/user/logout",
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

function buttonRegisterAgentClick() {
	firstName = $('#formRegister-first-name').val();
	lastName = $('#formRegister-last-name').val();
	email = $('#formRegister-email').val();
	phoneNumber = $('#formRegister-phone-number').val();
	brn = $('#formRegister-brn').val();
	
	if(!firstName || !lastName || !email || !phoneNumber || !brn) {
		toastr["error"]('Fill in all required entry fields!');
		return;
	}
	
	var data = JSON.stringify({
		"ime": firstName, 
		"prezime": lastName, 
		"email": email,
		"kontakt": phoneNumber, 
		"poslovniMaticniBroj": brn
	});
	$.ajax({
		async: false,
		url: "http://localhost:1234/administrator/addAgent",
        type: "POST",
        contentType: "application/json",
        data: data,
        crossDomain: true,
        xhrFields: {
            withCredentials: true
         },
        headers: {  'Access-Control-Allow-Origin': '*' },
        success: function () {
        	alert('Registration successfull!');
        	top.location.href = "home.html";
        	//toastr["success"]('Registration successful!');
        },
        error: function (jqXHR, textStatus, errorThrown) {
            toastr["error"](jqXHR.responseText);
        }
    });
}