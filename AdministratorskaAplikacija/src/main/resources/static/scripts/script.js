function clickFunction() {
	alert('Usao u funkciju'); 
	$.ajax({
		url: "http://localhost:1234/administrator/proba",
        type: "POST",
        //crossDomain: true,
        headers: {  'Access-Control-Allow-Origin': '*' },
        success: function () {
            alert('Uspeo');
        }
        //beforeSend: setHeader
    });
}

$(function() {

    $('#login-form-link').click(function(e) {
		$("#login-form").delay(100).fadeIn(100);
 		$("#register-form").fadeOut(100);
		$('#register-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});
	$('#register-form-link').click(function(e) {
		$("#register-form").delay(100).fadeIn(100);
 		$("#login-form").fadeOut(100);
		$('#login-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});

});