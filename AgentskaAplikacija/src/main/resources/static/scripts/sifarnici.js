function dodajSmestajnuJedinicu(){
	tipSmestaja = $('#inputTipSmestaja').val();
	opisSmestaja = $('#inputOpis').val();
	lokacijaSmestaja = $('#inputLokacija').val();
	brojOsobaSmestaja = $('#selectBrojOsoba').val();
	nazivSmestaja = $('#inputNazivSmestaja').val();
	
	if(!tipSmestaja || !opisSmestaja || !lokacijaSmestaja || !nazivSmestaja) {
		toastr["error"]('Fill in all required entry fields!');
		return;
	}
	var data = JSON.stringify({
		"naziv": nazivSmestaja,
		"tip" : tipSmestaja,
		"lokacija": lokacijaSmestaja,
		"opis" : opisSmestaja
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
        	$('#inputOpis').val("");
             location.reload();
        }, error: function (jqxhr, textStatus, errorThrown) {
            alert(errorThrown);
        }
    });
}

