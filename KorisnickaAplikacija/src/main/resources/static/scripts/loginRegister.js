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
	password = $('#formRegister-password').val();
	passwordConfirm = $('#formRegister-confirm-password').val();
	
	if(!firstName || !lastName || !email || !phoneNumber || !password || !passwordConfirm) {
		toastr["error"]('Fill in all required entry fields!');
		return;
	}
	
	var strongRegex = new RegExp("^(?=.{10,})(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*\\W).*$", "g");
	if(!strongRegex.test(password)) {
		toastr["error"]('Password must be at least ten characters including'
				+ ' one uppercase letter, one special character and alphanumeric characters!');
		return;
	}
	
	if(password !== passwordConfirm) {
		toastr["error"]('Passwords don\'t match!');
		return;
	}
	
	var data = JSON.stringify({
		"ime": firstName, 
		"prezime": lastName, 
		"email": email,
		"kontakt": phoneNumber, 
		"password": password, 
		"passwordConfirm": passwordConfirm
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

