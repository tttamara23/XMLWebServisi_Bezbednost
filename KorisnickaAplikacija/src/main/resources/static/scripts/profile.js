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
        	if(data.role === "REGISTERED") {
        		$("#tabProfileName").text(data.name);
        	} else {
        		top.location.href = "index.html";
        	}
        },
        error: function (jqxhr, textStatus, errorThrown) {
            top.location.href = "index.html";
        }
    });
	
	$('#aTagShowMore').click(function() {
	    $('#advancedSearchDiv').slideToggle('medium', function(){
	    	$('#aTagShowMore').text($('#aTagShowMore').text() == 'Show advanced' ? 'Hide advanced' : 'Show advanced');
	    });
	    
	    return false;
	});
	
	$.ajax({
		async: false,
		url: "http://localhost:1234/smestaj/getLocations",
        type: "GET",
        dataType: "json",
        crossDomain: true,
        xhrFields: {
            withCredentials: true
         },
        headers: {  'Access-Control-Allow-Origin': '*' },
        success: function (data) {
        	for(i=0; i<data.length; i++) {
        		newDiv = "";
        		if(i%3==0) {
        			$('#divPonude').append("<div class=\"row\">");
        		}
        		newDiv += "<div class=\"col-lg-4\"><div class=\"divPonuda divSearchInput\">"
        			+ "<h1>" + data[i] + "</h1>"
        			+ "<div id=\"divPonuda" + i + "\" style=\"display:none\">asd</div>"
        			+ "<a id=\"aTag" + i + "\" onclick=\"return showMoreLocationClick(" + i + ",'" + data[i] + "')\" class=\"aTag\" style=\"background-color: #e2e9fc; color: #1e1e77\">Show accommodations</a>"
        			+ "</div></div>";
        		if(i%3==0) {
        			$('#divPonude').append("</div>");
        		}
        		$('#divPonude').append(newDiv);
        	}
        },
        error: function (jqxhr, textStatus, errorThrown) {
            top.location.href = "index.html";
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