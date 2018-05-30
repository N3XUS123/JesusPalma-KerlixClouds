/*** Página añadir / editar productos ***/
// Validación añadir host.
$("button#addHost").click(function() {
	var dominio = $("input#dominio").val();
	var db = $("input#db").val();
	var almacenamiento = $("input#almHost").val();
	var abanda = $("input#aBandaHost").val();
	var ftp = $("input#ftp").val();
	var email = $("input#email").val();
	var mensualidad = $("input#mensualidadHost").val();
	var nombrePlan = $("input#nombrePlanHost").val();
	if (dominio == '0' || db == '0' || almacenamiento == '0' || abanda == '0' || 
			ftp == '0' || email == '0' || mensualidad == '0.0' || nombrePlan == '' ) {
		toastr["error"]("Por favor, rellena todos los campos.");
		 return false;
	}
});

// Validación añadir Server.
$("button#addServer").click(function() {
	var cpu = $("input#cpu").val();
	var ram = $("input#ram").val();
	var almacenamiento = $("input#almServer").val();
	var abanda = $("input#aBandaServer").val();
	var red = $("input#red").val();
	var mensualidad = $("input#mensualidadServer").val();
	var nombrePlan = $("input#nombrePlanServer").val();
	if (cpu == '0' || ram == '0' || almacenamiento == '0' || abanda == '0' || 
			red == '0' || mensualidad == '0.0' || nombrePlan == '' ) {
		toastr["error"]("Por favor, rellena todos los campos.");
		 return false;
	}
});
