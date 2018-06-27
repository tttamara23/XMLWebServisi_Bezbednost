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
		url: "https://localhost:1234/user/loginRegistered",
        type: "POST",
        contentType: "application/json",
        data: data,
        crossDomain: true,
        xhrFields: {
            withCredentials: true
         },
        headers: {  'Access-Control-Allow-Origin': '*'
        },
        success: function () {
        	top.location.href = "home.html";
        },
        error: function (jqXHR, textStatus, errorThrown) {
            toastr["error"](jqXHR.responseText);
        }
    });
}

function buttonRegisterClick() {
	firstName = $('#formRegister-first-name').val();
	lastName = $('#formRegister-last-name').val();
	email = $('#formRegister-email').val();
	phoneNumber = $('#formRegister-phone-number').val();
	
	if(!firstName || !lastName || !email || !phoneNumber) {
		toastr["error"]('Fill in all required entry fields!');
		return;
	}
	
	
	
	var data = JSON.stringify({
		"ime": firstName, 
		"prezime": lastName, 
		"email": email,
		"kontakt": phoneNumber
	});
	$.ajax({
		async: false,
		url: "https://localhost:1234/user/register",
        type: "POST",
        contentType: "application/json",
        data: data,
        headers: {  'Access-Control-Allow-Origin': '*' },
        success: function () {
        	alert('Registration successfull!');
        	top.location.href = "index.html";
        	//toastr["success"]('Registration successful!');
        },
        error: function (jqXHR, textStatus, errorThrown) {
            toastr["error"](jqXHR.responseText);
        }
    });
}

function buttonForgotClick() {
	$('#forgotPasswordModal').modal('toggle');
}

function forgotPasswordClick() {
	data = $('#forgotPasswordContent').val();
	$.ajax({
		async: false,
		url: "https://localhost:1234/user/forgotPassword",
        type: "POST",
        contentType: "text/plain",
        data: data,
        headers: {  'Access-Control-Allow-Origin': '*' },
        success: function () {
        	$('#forgotPasswordModal').modal('toggle');
        	toastr["info"]('New password sent on email.');
        	$('#forgotPasswordContent').val('');
        },
        error: function (jqXHR, textStatus, errorThrown) {
        	$('#forgotPasswordModal').modal('toggle');
            toastr["error"](jqXHR.responseText);
            $('#forgotPasswordContent').val('');
        }
    });
}
