$(document).ready(function () {
	$.ajax({
		async: false,
		url: "https://localhost:1234/user/getLoggedIn",
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
        	logout()
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

function users() {
	$("#tableUsers").find("tr:gt(0)").remove();
    $.ajax({
    	url: "https://localhost:1234/administrator/showUsers",
        type: "GET",
        crossDomain: true,
        xhrFields: {
            withCredentials: true
         },
        success: function (data) {
        	
               
               for (var i=0; i<data.length; i++){
                   var td;
                   var td1,td2,td3,td4,td5,td6,td7;
                   var tr=document.createElement('tr');
                  
                   td = document.createElement('td');
                   td.innerHTML=data[i].ime;
                   td1 = document.createElement('td');
                   td1.innerHTML= i+1;
                   td2 = document.createElement('td');
                   td2.innerHTML= data[i].prezime;
                   td3 = document.createElement('td');
                   td3.innerHTML= data[i].email;
                   td4 = document.createElement('td');
                   td4.innerHTML= data[i].kontakt;
                   td5 = document.createElement('td');
                   td5.innerHTML= data[i].blokiran;
                   
                   tr.appendChild(td1);  
                   tr.appendChild(td);              
                   tr.appendChild(td2);  
                   tr.appendChild(td3);              
                   tr.appendChild(td4);  
                   tr.appendChild(td5);  
                   
                   td6 = document.createElement('td');
                   if(data[i].blokiran == false)
                	   td6.innerHTML= "<button class=\"btn btn-warning\" onclick=\"return blokiraj('" + data[i].email + "')\">Blokiraj</button>";
                   else 
                	   td6.innerHTML= "<button class=\"btn btn-success\" onclick=\"return aktiviraj('" + data[i].email + "')\">Aktiviraj</button>";
                   tr.appendChild(td6);
                   td7 = document.createElement('td');
                   td7.innerHTML = "<button class=\"btn btn-danger\" onclick=\"return ukloni('" + data[i].email + "')\">Ukloni</button>";
                   tr.appendChild(td7);
                   $('#tableUsers').append(tr);
                   
               }
             
        }, error: function (jqxhr, textStatus, errorThrown) {
            alert(errorThrown);
        }
    });
}


function blokiraj(id){
	$.ajax({
    	url: "https://localhost:1234/administrator/blokiraj",
        type: "POST",
        crossDomain: true,
        contentType: "text/plain",
        data: id,
        xhrFields: {
            withCredentials: true
         },
        success: function () {
        	$("#tableUsers").find("tr:gt(0)").remove();
        	
        	users();

        }, error: function (jqxhr, textStatus, errorThrown) {
            alert(errorThrown);
        }
    });
}
function aktiviraj(id){
	$.ajax({
    	url: "https://localhost:1234/administrator/aktiviraj",
        type: "POST",
        crossDomain: true,
        contentType: "text/plain",
        data: id,
        xhrFields: {
            withCredentials: true
         },
        success: function () {
        	$("#tableUsers").find("tr:gt(0)").remove();
        	
                users();

        }, error: function (jqxhr, textStatus, errorThrown) {
            alert(errorThrown);
        }
    });
}
function ukloni(id){
	$.ajax({
    	url: "https://localhost:1234/administrator/ukloni",
        type: "POST",
        crossDomain: true,
        contentType: "text/plain",
        data: id,
        xhrFields: {
            withCredentials: true
         },
        success: function () {
        	$("#tableUsers").find("tr:gt(0)").remove();
        	
            users();

        }, error: function (jqxhr, textStatus, errorThrown) {
            alert(errorThrown);
        }
    });
}
function comments() {
	$("#tableComments").find("tr:gt(0)").remove();
    $.ajax({
    	url: "https://localhost:1234/administrator/showComments",
        type: "GET",
        crossDomain: true,
        xhrFields: {
            withCredentials: true
         },
        success: function (data) {
        	
               
               for (var i=0; i<data.length; i++){
                   var td;
                   var td1,td2,td3,td4,td5,td6,td7;
                   var tr=document.createElement('tr');
                  
                  td1 = document.createElement('td');
                   td1.innerHTML= i+1;
                   td2 = document.createElement('td');
                   td2.innerHTML= data[i].opis;
                   td3 = document.createElement('td');
                   var d = new Date(data[i].datumKomentara);
                   var stringDate = d.toLocaleString();
                   td3.innerHTML= stringDate;
                   
                   tr.appendChild(td1);  
                    tr.appendChild(td2);  
                   tr.appendChild(td3);              
                  
                   td6 = document.createElement('td');
                   td6.innerHTML= "<button class=\"btn btn-success\" onclick=\"return objavi('" + data[i].id + "')\">Objavi</button>";
                   tr.appendChild(td6);
                    $('#tableComments').append(tr);
                   
               }
             
        }, error: function (jqxhr, textStatus, errorThrown) {
            alert(errorThrown);
        }
    });
}
function objavi(id){
	$.ajax({
    	url: "https://localhost:1234/administrator/objaviKomentar",
        type: "POST",
        crossDomain: true,
        contentType: "text/plain",
        data: id,
        xhrFields: {
            withCredentials: true
         },
        success: function () {
        	$("#tableComments").find("tr:gt(0)").remove();
        	
            comments();

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
		url: "https://localhost:1234/administrator/addAgent",
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