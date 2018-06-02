function tipSmestaja() {
	$("#tableTipSmestaja").find("tr:gt(0)").remove();
    $.ajax({
    	url: "http://localhost:1234/administrator/tipSmestaja",
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
                   td.innerHTML=data[i].naziv;
                   td1 = document.createElement('td');
                   td1.innerHTML= i+1;
                
                   
                   tr.appendChild(td1);  
                   tr.appendChild(td);              
                   td2 = document.createElement('td');
                   td2.innerHTML="<button class=\"btn btn-danger\" onclick=\"return ukloni('" + data[i].id + "')\">Ukloni</button> &nbsp;&nbsp;&nbsp; <button class=\"btn btn-warning\" onclick=\"return izmeni('" + data[i].id + "')\">Izmeni</button>";
                   tr.appendChild(td2);    
                   
                   $('#tableTipSmestaja').append(tr);
                   
               }
             
        }, error: function (jqxhr, textStatus, errorThrown) {
            alert(errorThrown);
        }
    });
}
function ukloni(id){
	$.ajax({
    	url: "http://localhost:1234/administrator/ukloniTipSmestaja",
        type: "POST",
        crossDomain: true,
        contentType: "text/plain",
        data: id,
        xhrFields: {
            withCredentials: true
         },
        success: function () {
        	$("#tableTipSmestaja").find("tr:gt(0)").remove();
        	
        	tipSmestaja();

        }, error: function (jqxhr, textStatus, errorThrown) {
            alert(errorThrown);
        }
    });
}

function izmeni(id){
	$.ajax({
    	url: "http://localhost:1234/administrator/izmeniTipSmestaja",
        type: "POST",
        crossDomain: true,
        contentType: "text/plain",
        data: id,
        xhrFields: {
            withCredentials: true
         },
        success: function () {
        	$("#tableTipSmestaja").find("tr:gt(0)").remove();
        	
        	tipSmestaja();

        }, error: function (jqxhr, textStatus, errorThrown) {
            alert(errorThrown);
        }
    });
}
function dodajTipSmestaja(){
	naziv = $('#textBoxTipSmestaja').val();
	if(!naziv) {
		toastr["error"]('Fill in all required entry fields!');
		return;
	}
	var data = JSON.stringify({
		"naziv": naziv
	});
    $.ajax({
    	async: false,
		url: "http://localhost:1234/administrator/addTipSmestaja",
        type: "POST",
        contentType: "application/json",
        data: data,
        crossDomain: true,
        xhrFields: {
            withCredentials: true
         },
        headers: {  'Access-Control-Allow-Origin': '*' },
        success: function () {
        	$('#textBoxTipSmestaja').val("");
             tipSmestaja();
        }, error: function (jqxhr, textStatus, errorThrown) {
            alert(errorThrown);
        }
    });
}

function dodajKategorijuSmestaja(){
	kategorija = $('#textBoxKategorijaSmestaja').val();
	if(!kategorija) {
		toastr["error"]('Fill in all required entry fields!');
		return;
	}
	var data = JSON.stringify({
		"kategorija": kategorija
	});
    $.ajax({
    	async: false,
		url: "http://localhost:1234/administrator/addKategorijaSmestaja",
        type: "POST",
        contentType: "application/json",
        data: data,
        crossDomain: true,
        xhrFields: {
            withCredentials: true
         },
        headers: {  'Access-Control-Allow-Origin': '*' },
        success: function () {
        	$('#textBoxKategorijaSmestaja').val("");
             kategorijaSmestaja();
        }, error: function (jqxhr, textStatus, errorThrown) {
            alert(errorThrown);
        }
    });
}

function dodajDodatneUsluge(){
	naziv = $('#textBoxDodatneUsluge').val();
	if(!naziv) {
		toastr["error"]('Fill in all required entry fields!');
		return;
	}
	var data = JSON.stringify({
		"naziv": naziv
	});
    $.ajax({
    	async: false,
		url: "http://localhost:1234/administrator/addDodatneUsluge",
        type: "POST",
        contentType: "application/json",
        data: data,
        crossDomain: true,
        xhrFields: {
            withCredentials: true
         },
        headers: {  'Access-Control-Allow-Origin': '*' },
        success: function () {
        	$('#textBoxDodatneUsluge').val("");
             dodatneUsluge();
        }, error: function (jqxhr, textStatus, errorThrown) {
            alert(errorThrown);
        }
    });
}

function kategorijaSmestaja() {
	$("#tableKategorijaSmestaja").find("tr:gt(0)").remove();
    $.ajax({
    	url: "http://localhost:1234/administrator/kategorijaSmestaja",
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
                   td.innerHTML=data[i].kategorija;
                   td1 = document.createElement('td');
                   td1.innerHTML= i+1;
                
                   
                   tr.appendChild(td1);  
                   tr.appendChild(td);              
                   td2 = document.createElement('td');
                   td2.innerHTML="<button class=\"btn btn-danger\" onclick=\"return ukloniKategoriju('" + data[i].id + "')\">Ukloni</button>";
                   tr.appendChild(td2);    
                  
                   
                   $('#tableKategorijaSmestaja').append(tr);
                   
               }
             
        }, error: function (jqxhr, textStatus, errorThrown) {
            alert(errorThrown);
        }
    });
}
function ukloniKategoriju(id){
	$.ajax({
    	url: "http://localhost:1234/administrator/ukloniKategoriju",
        type: "POST",
        crossDomain: true,
        contentType: "text/plain",
        data: id,
        xhrFields: {
            withCredentials: true
         },
        success: function () {
        	$("#tableKategorijaSmestaja").find("tr:gt(0)").remove();
        	
        	kategorijaSmestaja();

        }, error: function (jqxhr, textStatus, errorThrown) {
            alert(errorThrown);
        }
    });
}
function dodatneUsluge() {
	$("#tableDodatneUsluge").find("tr:gt(0)").remove();
    $.ajax({
    	url: "http://localhost:1234/administrator/dodatneUsluge",
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
                   td.innerHTML=data[i].naziv;
                   td1 = document.createElement('td');
                   td1.innerHTML= i+1;
                
                   
                   tr.appendChild(td1);  
                   tr.appendChild(td);              
                   td2 = document.createElement('td');
                   td2.innerHTML="<button class=\"btn btn-danger\" onclick=\"return ukloniUslugu('" + data[i].id + "')\">Ukloni</button>";
                   tr.appendChild(td2);    
                  
                   
                   $('#tableDodatneUsluge').append(tr);
                   
               }
             
        }, error: function (jqxhr, textStatus, errorThrown) {
            alert(errorThrown);
        }
    });
}
function ukloniUslugu(id){
	$.ajax({
    	url: "http://localhost:1234/administrator/ukloniUslugu",
        type: "POST",
        crossDomain: true,
        contentType: "text/plain",
        data: id,
        xhrFields: {
            withCredentials: true
         },
        success: function () {
        	$("#tableDodatneUsluge").find("tr:gt(0)").remove();
        	
        	dodatneUsluge();

        }, error: function (jqxhr, textStatus, errorThrown) {
            alert(errorThrown);
        }
    });
}