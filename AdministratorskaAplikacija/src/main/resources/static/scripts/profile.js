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


/*function changePasswordClick() {
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
}*/

function logout() {
    $.ajax({
    	url: "https://localhost:1234/user/logout",
        type: "POST",
        crossDomain: true,
        xhrFields: {
            withCredentials: true
         },
         headers: {  'Access-Control-Allow-Origin': '*' },
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
        headers: {  'Access-Control-Allow-Origin': '*' },
        xhrFields: {
            withCredentials: true
         },
        success: function (data) {
        	
               
               for (var i=0; i<data.length; i++){
                   var td;
                   var td1,td2,td3,td4,td5,td6,td7;
                   var tr=document.createElement('tr');
                  
                   td = document.createElement('td');
                   td.innerHTML=data[i].korisnikDTO.ime;
                   td1 = document.createElement('td');
                   td1.innerHTML= i+1;
                   td2 = document.createElement('td');
                   td2.innerHTML= data[i].korisnikDTO.prezime;
                   td3 = document.createElement('td');
                   td3.innerHTML= data[i].korisnikDTO.email;
                   td4 = document.createElement('td');
                   td4.innerHTML= data[i].korisnikDTO.kontakt;
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
                	   td6.innerHTML= "<button class=\"btn btn-warning\" onclick=\"return blokiraj('" + data[i].korisnikDTO.email + "')\">Blokiraj</button>";
                   else 
                	   td6.innerHTML= "<button class=\"btn btn-success\" onclick=\"return aktiviraj('" + data[i].korisnikDTO.email + "')\">Aktiviraj</button>";
                   tr.appendChild(td6);
                   td7 = document.createElement('td');
                   td7.innerHTML = "<button class=\"btn btn-danger\" onclick=\"return ukloniKorisnika('" + data[i].korisnikDTO.email + "')\">Ukloni</button>";
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
         headers: {  'Access-Control-Allow-Origin': '*' },
        success: function () {
        	$("#tableUsers").find("tr:gt(0)").remove();
        	toastr["info"]('Korisnik blokiran.');
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
         headers: {  'Access-Control-Allow-Origin': '*' },
        success: function () {
        	$("#tableUsers").find("tr:gt(0)").remove();
        	toastr["info"]('Korisnik aktiviran.');
                users();

        }, error: function (jqxhr, textStatus, errorThrown) {
            alert(errorThrown);
        }
    });
}
function ukloniKorisnika(id){
	$.ajax({
    	url: "https://localhost:1234/administrator/ukloni",
        type: "POST",
        crossDomain: true,
        contentType: "text/plain",
        data: id,
        xhrFields: {
            withCredentials: true
         },
         headers: {  'Access-Control-Allow-Origin': '*' },
        success: function () {
        	//$("#tableUsers").find("tr:gt(0)").remove();
        	
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
         headers: {  'Access-Control-Allow-Origin': '*' },
        success: function (data) {
        	
               
               for (var i=0; i<data.length; i++){
                   var td;
                   var td1,td2,td3,td4,td5,td6,td7,td8;
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
                   td7 = document.createElement('td');
                   td7.innerHTML = data[i].imeAutora + " " + data[i].prezimeAutora;
                   
                   td8 = document.createElement('td');
                   td8.innerHTML = data[i].smestajDTO.naziv + ", " + data[i].smestajDTO.lokacija;
                   
                   tr.appendChild(td7);
                   tr.appendChild(td8);
                   
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
         headers: {  'Access-Control-Allow-Origin': '*' },
        success: function () {
        	$("#tableComments").find("tr:gt(0)").remove();
        	toastr["info"]('Komentar objavljen.');
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
	
	if(isNaN(phoneNumber) || isNaN(brn)){
		toastr["error"]('uneti brojcane vrednosti za broj telefona i poslovni maticni broj!');
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
        	
        	top.location.href = "home.html";
        	toastr["success"]('Registracija agenta uspesna!');
        },
        error: function (jqXHR, textStatus, errorThrown) {
            toastr["error"](jqXHR.responseText);
        }
    });
}

function showRolesAndPermissions() {
	$("#tableRolesAndPermissions").find("tr:gt(0)").remove();
	$.ajax({
    	url: "https://localhost:1234/role/getRoles",
        type: "GET",
        crossDomain: true,
        xhrFields: {
            withCredentials: true
         },
        success: function (data) {
        	
               
        	 for (var i=0; i<data.length; i++){
                 var td;
                 var td1,td2,td3;
                 var tr=document.createElement('tr');
                
                 td1 = document.createElement('td');
                 td1.innerHTML= data[i].id;
                 td2 = document.createElement('td');
                 td2.innerHTML= data[i].name;
                 
                 tr.appendChild(td1);  
                 tr.appendChild(td2);             
                
                 td3 = document.createElement('td');
                 td3.innerHTML= "<button class=\"btn btn-default\" onclick=\"return prikaziPermisije('" + data[i].id + "')\">Show permissions</button>&nbsp&nbsp&nbsp<button class=\"btn btn-success\" onclick=\"return dodajPermisiju('" + data[i].id + "')\">Add permissions</button>";
                 tr.appendChild(td3);
                 $('#tableRolesAndPermissions').append(tr);
                   
               }
             
        }, error: function (jqxhr, textStatus, errorThrown) {
            alert(jqxhr.responseText);
        }
    });
}

function prikaziPermisije(idRole) {
	$("#tableRolesAndPermissionsPer").find("tr:gt(0)").remove();
	$.ajax({
    	url: "https://localhost:1234/permission/getPermissions/" + idRole,
        type: "GET",
        crossDomain: true,
        xhrFields: {
            withCredentials: true
         },
        success: function (data) {
        	
               
        	 for (var i=0; i<data.length; i++){
                 var td;
                 var td1,td2,td3;
                 var tr=document.createElement('tr');
                
                 td1 = document.createElement('td');
                 td1.innerHTML= data[i].id;
                 td2 = document.createElement('td');
                 td2.innerHTML= data[i].name;
                 
                 tr.appendChild(td1);  
                 tr.appendChild(td2);             
                
                 td3 = document.createElement('td');
                 td3.innerHTML= "<button class=\"btn btn-danger\" onclick=\"return obrisiPermisiju(" + idRole + ", " + data[i].id + ")\">Remove</button>";
                 tr.appendChild(td3);
                 $('#tableRolesAndPermissionsPer').append(tr);
                   
               }
             
        }, error: function (jqxhr, textStatus, errorThrown) {
            alert(jqxhr.responseText);
        }
    });
}

function obrisiPermisiju(idRole, idPermission) {
	$("#tableRolesAndPermissionsPer").find("tr:gt(0)").remove();
	$.ajax({
    	url: "https://localhost:1234/role/deletePermissionToRole/" + idRole + "/" + idPermission,
        type: "DELETE",
        crossDomain: true,
        xhrFields: {
            withCredentials: true
         },
         headers: {  'Access-Control-Allow-Origin': '*' },
        success: function (data) {
        	prikaziPermisije(idRole);
        }, error: function (jqxhr, textStatus, errorThrown) {
            alert(jqxhr.responseText);
        }
	});
}

function dodajPermisiju(idRole) {
	$('#addPermissionModalIdRole').val(idRole);
	$.ajax({
    	url: "https://localhost:1234/permission/getAll",
        type: "GET",
        crossDomain: true,
        xhrFields: {
            withCredentials: true
         },
        success: function (data) {
        	$('#selectPermisija').empty();
        	for(i=0; i<data.length; i++) {
        		$('#selectPermisija').append("<option value=\"" + data[i].id +"\">" + data[i].name + "</select>");
        	}
        }
	});
	$('#modalPermisija').modal('toggle');
}

function dodajPermisijuButton() {
	idRole = $('#addPermissionModalIdRole').val();
	idPermisije = $('#selectPermisija').val();
	$('#modalPermisija').modal('toggle');
	$.ajax({
    	url: "https://localhost:1234/role/addPermissionToRole/" + idRole + "/" + idPermisije,
        type: "GET",
        crossDomain: true,
        xhrFields: {
            withCredentials: true
         },
         headers: {  'Access-Control-Allow-Origin': '*' },
        success: function (data) {
        	prikaziPermisije(idRole);
        }, error: function (jqxhr, textStatus, errorThrown) {
            alert(jqxhr.responseText);
        }
	});
}