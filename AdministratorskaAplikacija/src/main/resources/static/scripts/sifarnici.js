function tipSmestaja() {
	$("#tableTipSmestaja").find("tr:gt(0)").remove();
    $.ajax({
    	url: "https://localhost:1234/administrator/tipSmestaja",
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
    	url: "https://localhost:1234/administrator/ukloniTipSmestaja",
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
        	toastr["error"]('Zabranjeno brisanje ovog tipa smestaja!');
            
        }
    });
}


function izmeni(id){
	$.ajax({
    	url: "https://localhost:1234/administrator/izmeniTipSmestaja",
        type: "POST",
        crossDomain: true,
        contentType: "text/plain",
        data: id,
        xhrFields: {
            withCredentials: true
         },
        success: function (data) {
        	
        	var x = document.getElementById("nazivTipaInput");
        	x.value = data.naziv;
        	
        	var button = document.getElementById("saveTipButton");
        	button.setAttribute("onclick","return sacuvajIzmenuTipa('"+data.id +"')");
        	
        	$("#myModal").modal('show');
        	
        }, error: function (jqxhr, textStatus, errorThrown) {
            alert(errorThrown);
        }
    });
}
function sacuvajIzmenuTipa(id){
	var noviNaziv = document.getElementById("nazivTipaInput");
	sacuvajIzmenuTipa2(id,noviNaziv.value);
}

function sacuvajIzmenuTipa2(id,naziv){
	var podaci = {};
	podaci.id = id;
	podaci.naziv = naziv;
	
	var podaciJson = JSON.stringify(podaci);
	$.ajax({
    	url: "https://localhost:1234/administrator/sacuvajIzmenuTipaSmestaja",
        type: "POST",
        crossDomain: true,
        contentType: "application/json",
        data: podaciJson,
        xhrFields: {
            withCredentials: true
         },
        success: function () {
        	$("#tableTipSmestaja").find("tr:gt(0)").remove();
        	toastr["success"]('Izmena tipa uspesna!');

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
		url: "https://localhost:1234/administrator/addTipSmestaja",
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
        	toastr["success"]('Tip smestaja dodat!');

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
		url: "https://localhost:1234/administrator/addKategorijaSmestaja",
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
        	toastr["success"]('Kategorija uspesno dodata!');

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
		url: "https://localhost:1234/administrator/addDodatneUsluge",
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
        	toastr["success"]('Dodatna usluga uspesno dodata!');

             dodatneUsluge();
        }, error: function (jqxhr, textStatus, errorThrown) {
            alert(errorThrown);
        }
    });
}

function kategorijaSmestaja() {
	$("#tableKategorijaSmestaja").find("tr:gt(0)").remove();
    $.ajax({
    	url: "https://localhost:1234/administrator/kategorijaSmestaja",
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
                   td2.innerHTML="<button class=\"btn btn-danger\" onclick=\"return ukloniKategoriju('" + data[i].id + "')\">Ukloni</button> &nbsp;&nbsp;&nbsp; <button class=\"btn btn-warning\" onclick=\"return izmeniKategoriju('" + data[i].id + "')\">Izmeni</button>";
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
    	url: "https://localhost:1234/administrator/ukloniKategoriju",
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
        	toastr["success"]('Brisanje ove kategorije zabranjeno!');

        }
    });
}
function izmeniKategoriju(id){
	$.ajax({
    	url: "https://localhost:1234/administrator/izmeniKategoriju",
        type: "POST",
        crossDomain: true,
        contentType: "text/plain",
        data: id,
        xhrFields: {
            withCredentials: true
         },
        success: function (data) {
        	
        	var x = document.getElementById("nazivKategorije");
        	x.value = data.kategorija;
        	
        	var button = document.getElementById("saveKategorijaButton");
        	button.setAttribute("onclick","return sacuvajIzmenuKategorije('"+data.id +"')");
        	
        	$("#modalKategorija").modal('show');


        }, error: function (jqxhr, textStatus, errorThrown) {
            alert(errorThrown);
        }
    });
}

function sacuvajIzmenuKategorije(id){
	var noviNaziv = document.getElementById("nazivKategorije");
	sacuvajIzmenuKategorije2(id,noviNaziv.value);
}

function sacuvajIzmenuKategorije2(id,kategorija){
	var podaci = {};
	podaci.id = id;
	podaci.kategorija = kategorija;
	
	var podaciJson = JSON.stringify(podaci);
	$.ajax({
    	url: "https://localhost:1234/administrator/sacuvajIzmenuKategorijeSmestaja",
        type: "POST",
        crossDomain: true,
        contentType: "application/json",
        data: podaciJson,
        xhrFields: {
            withCredentials: true
         },
        success: function () {
        	$("#tableKategorijaSmestaja").find("tr:gt(0)").remove();
        	toastr["success"]('Izmena kategorije uspesna!');

        	kategorijaSmestaja();

        }, error: function (jqxhr, textStatus, errorThrown) {
            alert(errorThrown);
        }
    });
}

function dodatneUsluge() {
	$("#tableDodatneUsluge").find("tr:gt(0)").remove();
    $.ajax({
    	url: "https://localhost:1234/administrator/dodatneUsluge",
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
                   td2.innerHTML="<button class=\"btn btn-danger\" onclick=\"return ukloniUslugu('" + data[i].id + "')\">Ukloni</button> &nbsp;&nbsp;&nbsp; <button class=\"btn btn-warning\" onclick=\"return izmeniUslugu('" + data[i].id + "')\">Izmeni</button>";
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
    	url: "https://localhost:1234/administrator/ukloniUslugu",
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
        	toastr["success"]('Brisanje usluge zabranjeno!');

        }
    });
}

function izmeniUslugu(id){
	$.ajax({
    	url: "https://localhost:1234/administrator/izmeniUslugu",
        type: "POST",
        crossDomain: true,
        contentType: "text/plain",
        data: id,
        xhrFields: {
            withCredentials: true
         },
        success: function (data) {
        	
        	var x = document.getElementById("nazivUsluge");
        	x.value = data.naziv;
        	
        	var button = document.getElementById("saveUslugaButton");
        	button.setAttribute("onclick","return sacuvajIzmenuUsluge('"+data.id +"')");
        	
        	$("#modalUsluga").modal('show');


        }, error: function (jqxhr, textStatus, errorThrown) {
            alert(errorThrown);
        }
    });
}
function sacuvajIzmenuUsluge(id){
	var noviNaziv = document.getElementById("nazivUsluge");
	sacuvajIzmenuUsluge2(id,noviNaziv.value);
}

function sacuvajIzmenuUsluge2(id,naziv){
	var podaci = {};
	podaci.id = id;
	podaci.naziv = naziv;
	
	var podaciJson = JSON.stringify(podaci);
	$.ajax({
    	url: "https://localhost:1234/administrator/sacuvajIzmenuUsluge",
        type: "POST",
        crossDomain: true,
        contentType: "application/json",
        data: podaciJson,
        xhrFields: {
            withCredentials: true
         },
        success: function () {
        	$("#tableDodatneUsluge").find("tr:gt(0)").remove();
        	toastr["success"]('Izmena usluge uspesna!');

        	dodatneUsluge();

        }, error: function (jqxhr, textStatus, errorThrown) {
            alert(errorThrown);
        }
    });
}