function termins() {
	$("#tableTermins").find("tr:gt(0)").remove();
    $.ajax({
    	url: "http://localhost:4321/agent/termins",
        type: "GET",
        crossDomain: true,
        xhrFields: {
            withCredentials: true
         },
        success: function (data) {
        		
        		
               
               for (var i=0; i<data.length; i++){
                   var td;
                   var td1,td2;
                   var tr=document.createElement('tr');
                  
                   td = document.createElement('td');
                   
                   
                   /*var d = new Date(data[i].date);
                   var stringDate = d.toLocaleString();*/
                   td.innerHTML=data[i].naziv;
                   td1 = document.createElement('td');
                   td1.innerHTML= i+1;
                  
                   
                   tr.appendChild(td1);  
                   tr.appendChild(td); 
                  
                   
                   td2 = document.createElement('td');
                   td2.innerHTML="<button class=\"btn btn-success\" onclick=\"return DodajTermin('" + data[i].id + "')\">Dodaj termine</button> &nbsp;&nbsp;&nbsp;"+
                   "<button class=\"btn btn-info\" onclick=\"return PregledajTermine('" + data[i].id + "')\">Pregledaj termine</button> &nbsp;&nbsp;&nbsp;";
                   tr.appendChild(td2);    
                    
                   
                   $('#tableTermins').append(tr);
                   
               }
             
        }, error: function (jqxhr, textStatus, errorThrown) {
            alert(errorThrown);
        }
    });
}

function DodajTermin(id) {
	var button = document.getElementById("dodajTermin");
	button.setAttribute("onclick","return dodajTermin2('"+ id +"')");
	$("#modalTermin").modal('show');	
}

function dodajTermin2(id){
	datumOd = $('#datumOd').val();
	datumDo = $('#datumDo').val();
	brojSoba = $('#inputBrojSoba').val();
	brojKreveta = $('#inputBrojKreveta').val();
	cena = $('#inputCena').val();
	
	if(!datumOd || !datumDo || !brojSoba || !brojKreveta || !cena ) {
		toastr["error"]('Fill in all required entry fields!');
		return;
	}
	
	var data = JSON.stringify({
		"datumOd": datumOd,
		"datumDo" : datumDo,
		"cena": cena,
		"brojSlobodnihPonuda" : brojSoba,
		"brojLezaja" : brojKreveta,
		"smestajId": id
		
	});
    $.ajax({
    	async: false,
		url: "http://localhost:4321/agent/dodajTermin",
        type: "POST",
        contentType: "application/json",
        data: data,
        crossDomain: true,
        xhrFields: {
            withCredentials: true
         },
        headers: {  'Access-Control-Allow-Origin': '*' },
        success: function () {
        	document.getElementById("inputBrojSoba").value = "";
        	document.getElementById("inputBrojKreveta").value = "";
        	document.getElementById("inputCena").value = "";
        	document.getElementById("datumOd").valueAsDate = null;
        	document.getElementById("datumDo").valueAsDate = null;
        	
        }, error: function (jqxhr, textStatus, errorThrown) {
            alert(errorThrown);
        }
    });
	
}
function PregledajTermine(id){
	$("#tablePregledTermina").find("tr:gt(0)").remove();
	$("#modalPregledTermina").modal('show');
	$.ajax({
    	url: "http://localhost:4321/agent/pregledajTermine",
        type: "POST",
        crossDomain: true,
        contentType: "text/plain",
        data: id,
        xhrFields: {
            withCredentials: true
         },
        success: function (data) {
        	for(i=0;i<data.length;i++){
        		 var tdDatumOd, tdBrojSoba, tdBrojKreveta;
                 var tdDatumDo,tdCena;
                 var tr=document.createElement('tr');
                 var td1;
                 tdDatumOd = document.createElement('td');
                 tdDatumDo = document.createElement('td');
                 tdBrojSoba = document.createElement('td');
                 tdBrojKreveta = document.createElement('td');
           
                 tdCena = document.createElement('td');
                 td1 = document.createElement('td');
                 tdDatumOd.innerHTML=data[i].datumOd;
                
                 td1.innerHTML= i+1;
                 tdDatumDo.innerHTML = data[i].datumDo;
                 tdBrojSoba.innerHTML = data[i].brojSlobodnihPonuda;
                 tdBrojKreveta.innerHTML = data[i].brojLezaja;
                 tdCena.innerHTML = data[i].cena;
                 
                 tr.appendChild(td1);  
                 tr.appendChild(tdDatumOd); 
                 tr.appendChild(tdDatumDo);
                 tr.appendChild(tdBrojSoba);
                 tr.appendChild(tdBrojKreveta);
                
                 tr.appendChild(tdCena);
                 
                 td2 = document.createElement('td');
                 td2.innerHTML="<button class=\"btn btn-primary\" data-dismiss=\"modal\" onclick=\"return nadjiTermin('" + data[i].id + "')\">Zauzmi termin</button> &nbsp;&nbsp;&nbsp;";
                 tr.appendChild(td2);    
                
                 
                 $('#tablePregledTermina').append(tr);
        		
        	}

        }, error: function (jqxhr, textStatus, errorThrown) {
            alert(errorThrown);
        }
    });
}

function nadjiTermin(idTermina){
	$("#modalZauzmiTermin").modal('show');
	var buttonPotvrdi = document.getElementById("potvrdiZauzimanje");
	buttonPotvrdi.setAttribute("onclick","return potvrdiZauzimanjeTermina('"+ idTermina +"')");
	
	
}

function potvrdiZauzimanjeTermina(idTermina){
	
	$.ajax({
    	url: "http://localhost:4321/agent/nadjiTermin",
        type: "POST",
        crossDomain: true,
        contentType: "text/plain",
        data: idTermina,
        xhrFields: {
            withCredentials: true
         },
        success: function (data) {
        	var unetBrojSoba = document.getElementById("inputBrojSobaZauzmi").value;
        	if(unetBrojSoba > data.brojSlobodnihPonuda){
        		toastr["error"]('Broj slobodnih soba je: ' + data.brojSlobodnihPonuda +'!');
        		$("#inputBrojSobaZauzmi").val("");
        	}else{
        		var zauzimanjeDTO = {};
        		zauzimanjeDTO.idTermina = idTermina;
        		zauzimanjeDTO.brojSoba = unetBrojSoba;
        		$.ajax({
        	    	url: "http://localhost:4321/agent/zauzmiTermin",
        	        type: "POST",
        	        crossDomain: true,
        	        contentType: "application/json",
        	        data: JSON.stringify(zauzimanjeDTO),
        	        xhrFields: {
        	            withCredentials: true
        	         },
        	        success: function (data) {
        	        	if(data!=null){
        	        		$("#inputBrojSobaZauzmi").val("");
        	        		toastr["success"]('Uspesno!');
        	        	}
        	        	

        	        }, error: function (jqxhr, textStatus, errorThrown) {
        	            alert(errorThrown);
        	        }
        	    });
        	}
        	

        }, error: function (jqxhr, textStatus, errorThrown) {
            alert(errorThrown);
        }
    });

}
function reservations() {
	$("#tableReservations").find("tr:gt(0)").remove();
    $.ajax({
    	url: "http://localhost:4321/agent/rezervacije",
        type: "GET",
        crossDomain: true,
        xhrFields: {
            withCredentials: true
         },
        success: function (data) {
        		
        		
               
               for (var i=0; i<data.length; i++){
                   var td;
                   var td1,td2,td3,td4,tdOd,tdDo,tdCena;
                   var tr=document.createElement('tr');
                  
                   td = document.createElement('td');
                   td3 = document.createElement('td');
                   td4 = document.createElement('td');
                   tdOd = document.createElement('td');
                   tdDo = document.createElement('td');
                   tdCena = document.createElement('td');
                   
                   /*var d = new Date(data[i].date);
                   var stringDate = d.toLocaleString();*/
                   td.innerHTML=data[i].date;
                   td1 = document.createElement('td');
                   td1.innerHTML= i+1;
                   td4.innerHTML = data[i].ime + " " + data[i].prezime;
                   td3.innerHTML = data[i].ponudaDTO.smestajNaziv;
                   tdOd.innerHTML = data[i].ponudaDTO.datumOd;
                   tdDo.innerHTML = data[i].ponudaDTO.datumDo;
                   tdCena.innerHTML = data[i].ponudaDTO.cena;
                   
                   tr.appendChild(td1);  
                   tr.appendChild(td); 
                   tr.appendChild(td4);
                   tr.appendChild(td3);
                   tr.appendChild(tdOd);
                   tr.appendChild(tdDo);
                   tr.appendChild(tdCena);
                   
                   td2 = document.createElement('td');
                   td2.innerHTML="<button class=\"btn btn-success\" onclick=\"return potvrdiRezervaciju('" + data[i].id + "')\">Potvrdi rezervaciju</button> &nbsp;&nbsp;&nbsp;";
                   tr.appendChild(td2);    
                  
                   
                   $('#tableReservations').append(tr);
                   
               }
             
        }, error: function (jqxhr, textStatus, errorThrown) {
            alert(errorThrown);
        }
    });
}

function potvrdiRezervaciju(id){
	$.ajax({
    	url: "http://localhost:4321/agent/potvrdiRezervaciju",
        type: "POST",
        crossDomain: true,
        contentType: "text/plain",
        data: id,
        xhrFields: {
            withCredentials: true
         },
        success: function (data) {
        	if(data==true){
	        	$("#tableReservations").find("tr:gt(0)").remove();
	        	toastr["success"]('Uspesno!');
	        	reservations();
        	}else{
        		alert("bozmeg");
        	}

        }, error: function (jqxhr, textStatus, errorThrown) {
            alert(errorThrown);
        }
    });
}

function getBase64(file) {
	   var reader = new FileReader();
	   reader.readAsDataURL(file);
	   reader.onload = function () {
	     console.log(reader.result);
	   };
	   reader.onerror = function (error) {
	     console.log('Error: ', error);
	   };
	}


function dodajSmestajnuJedinicu(){
	tipSmestaja = $('#selectTipSmestaja').val();
	kategorijaSmestaja = $('#selectKategorijaSmestaja').val();
	opisSmestaja = $('#inputOpis').val();
	lokacijaSmestaja = $('#inputLokacija').val();
	nazivSmestaja = $('#inputNazivSmestaja').val();
	var fileArray = [];
	var files = document.getElementById("files");
	var numberOfFiles = files.files.length;
	for (var i = 0; i < numberOfFiles; i++) {
		var f = files.files[i];
        var fileReader = new FileReader();
		fileReader.readAsDataURL(f);
        fileArray.push(fileReader.result);
		
	}
   
	if(!tipSmestaja || !opisSmestaja || !lokacijaSmestaja || !nazivSmestaja ) {
		toastr["error"]('Fill in all required entry fields!');
		return;
	}
	
	var oznaceneUsluge = getSelectedChbox();
	var data = JSON.stringify({
		"naziv": nazivSmestaja,
		"tip" : tipSmestaja,
		"lokacija": lokacijaSmestaja,
		"opis" : opisSmestaja,
		"usluge" : oznaceneUsluge,
		"kategorija": kategorijaSmestaja,
		"slike": fileArray
		
	});
    $.ajax({
    	async: false,
		url: "http://localhost:4321/agent/addSmestaj",
        type: "POST",
        contentType: "application/json",
        data: data,
        crossDomain: true,
        xhrFields: {
            withCredentials: true
         },
        headers: {  'Access-Control-Allow-Origin': '*' },
        success: function () {
        	toastr["success"]('Uspesno!');
        	$('#inputOpis').val("");
             location.reload();
        }, error: function (jqxhr, textStatus, errorThrown) {
            alert(errorThrown);
        }
    });
}

//get selected checkboxes
function getSelectedChbox() {
  var selchbox = [];// array that will store the value of selected checkboxes
  // gets all the input tags in frm, and their number
  var inpfields = document.getElementsByTagName('input');
  var nr_inpfields = inpfields.length;
  // traverse the inpfields elements, and adds the value of selected (checked) checkbox in selchbox
  for(var i=0; i<nr_inpfields; i++) {
    if(inpfields[i].type == 'checkbox' && inpfields[i].checked == true) {
    	var usluga = new Object();
    	usluga.id = inpfields[i].id;
    	usluga.naziv = inpfields[i].value;
    	selchbox.push(usluga);
    }
  }
  return selchbox;
}

function chats() {
	$("#tableChats").find("tr:gt(0)").remove();
    $.ajax({
    	url: "http://localhost:4321/agent/chatovi",
        type: "GET",
        crossDomain: true,
        xhrFields: {
            withCredentials: true
         },
        success: function (data) {
        		
        	
               
               for (var i=0; i<data.length; i++){
                   var td;
                   var td1,td2,td3,td4,tdOd,tdDo,tdCena;
                   var tr=document.createElement('tr');
                  
                   td = document.createElement('td');
                   td4 = document.createElement('td');
                   
                   td.innerHTML=data[i].poruke.length;
                   td1 = document.createElement('td');
                   td1.innerHTML= i+1;
                   td4.innerHTML = data[i].unseen;
                   
                   
                   tr.appendChild(td1);  
                   tr.appendChild(td); 
                   tr.appendChild(td4);
                   
                   td2 = document.createElement('td');
                   td2.innerHTML="<button class=\"btn btn-success\" onclick=\"return pregledajChat('" + data[i].id + "')\">Pregledaj chat</button> &nbsp;&nbsp;&nbsp;";
                   tr.appendChild(td2);    
                  
                   
                   $('#tableChats').append(tr);
                   
               }
             
        }, error: function (jqxhr, textStatus, errorThrown) {
            alert(errorThrown);
        }
    });
}

function pregledajChat(id){
	$("#modalBodyChat").html("");
	$.ajax({
    	url: "http://localhost:4321/agent/getPorukeIzChata",
        type: "POST",
        contentType: "text/plain",
        data: id,
        crossDomain: true,
        xhrFields: {
            withCredentials: true
         },
        success: function (data) {
        	$("#modalChat").modal('show');
        	var i = 0;
        	for(i=0;i<data.length;i++){
        		var divZaPoruku = document.createElement('div');
        		var pSadrzaj = document.createElement('p');
        		var pDatum = document.createElement('p');
        		pDatum.innerHTML = data[i].datum;
        		pSadrzaj.innerHTML = data[i].posiljalac.ime + " " +  data[i].posiljalac.prezime + ": " + data[i].sadrzaj;
        		divZaPoruku.append(pDatum);
        		var br = document.createElement('br');
        		divZaPoruku.append(br);
        		
        		divZaPoruku.append(pSadrzaj);
        		var button = document.getElementById("posaljiPoruku");
            	button.setAttribute("onclick","return posaljiPoruku('"+ id +"')");
        		$("#modalBodyChat").append(divZaPoruku);
        		$("#modalBodyChat").append(br);
        		
        	}
                   
        }
         , error: function (jqxhr, textStatus, errorThrown) {
            alert(errorThrown);
        }
    });
	
}

function posaljiPoruku(id){

	var textAreaSadrzaj = document.getElementById("sadrzajPoruke");
	var sadrzaj = textAreaSadrzaj.value;
	var poruka = {};
	poruka.sadrzajPoruke = sadrzaj;
	poruka.idChat = id;
	
	$.ajax({
    	url: "http://localhost:4321/agent/posaljiPoruku",
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify(poruka),
        crossDomain: true,
        xhrFields: {
            withCredentials: true
         },
        success: function (data) {
        	toastr["success"]('Poruka poslata!');
        	$("#modalBodyChat").html("");
        	document.getElementById("sadrzajPoruke").value = "";
        	pregledajChat(id);
                   
        }
         , error: function (jqxhr, textStatus, errorThrown) {
            alert(errorThrown);
        }
    });
	
}
