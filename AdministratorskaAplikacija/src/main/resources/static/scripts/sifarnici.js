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
                   
                   /*td6 = document.createElement('td');
                   if(data[i].blokiran == false)
                	   td6.innerHTML= "<button class=\"btn btn-warning\" onclick=\"return blokiraj('" + data[i].email + "')\">Blokiraj</button>";
                   else 
                	   td6.innerHTML= "<button class=\"btn btn-success\" onclick=\"return aktiviraj('" + data[i].email + "')\">Aktiviraj</button>";
                   tr.appendChild(td6);
                   td7 = document.createElement('td');
                   td7.innerHTML = "<button class=\"btn btn-danger\" onclick=\"return ukloni('" + data[i].naziv + "')\">Ukloni</button>" +
                   		"<button class=\"btn btn-danger\" onclick=\"return ukloni('" + data[i].naziv + "')\">Izmeni</button>";
                   tr.appendChild(td7);*/
                   $('#tableTipSmestaja').append(tr);
                   
               }
             
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
                   
                   /*td6 = document.createElement('td');
                   if(data[i].blokiran == false)
                	   td6.innerHTML= "<button class=\"btn btn-warning\" onclick=\"return blokiraj('" + data[i].email + "')\">Blokiraj</button>";
                   else 
                	   td6.innerHTML= "<button class=\"btn btn-success\" onclick=\"return aktiviraj('" + data[i].email + "')\">Aktiviraj</button>";
                   tr.appendChild(td6);
                   td7 = document.createElement('td');
                   td7.innerHTML = "<button class=\"btn btn-danger\" onclick=\"return ukloni('" + data[i].email + "')\">Ukloni</button>";
                   tr.appendChild(td7);*/
                   $('#tableKategorijaSmestaja').append(tr);
                   
               }
             
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
                   
                   /*td6 = document.createElement('td');
                   if(data[i].blokiran == false)
                	   td6.innerHTML= "<button class=\"btn btn-warning\" onclick=\"return blokiraj('" + data[i].email + "')\">Blokiraj</button>";
                   else 
                	   td6.innerHTML= "<button class=\"btn btn-success\" onclick=\"return aktiviraj('" + data[i].email + "')\">Aktiviraj</button>";
                   tr.appendChild(td6);
                   td7 = document.createElement('td');
                   td7.innerHTML = "<button class=\"btn btn-danger\" onclick=\"return ukloni('" + data[i].email + "')\">Ukloni</button>";
                   tr.appendChild(td7);*/
                   $('#tableDodatneUsluge').append(tr);
                   
               }
             
        }, error: function (jqxhr, textStatus, errorThrown) {
            alert(errorThrown);
        }
    });
}