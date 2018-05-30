/*** Inicializar wow ***/
new WOW().init();

/*** Inicializar AOS ***/
AOS.init();

// Página de error.
function error(){
	var granimInstance = new Granim({
		element: '#granim-canvas',
	    name: 'granim',
	    opacity: [1, 1],
	    states : {"default-state": {gradients: [['#834D9B', '#D04ED6'], ['#1CD8D2', '#93EDC7']]}}
	});
}

/*** MAIN ***/
function main(){
	var mapProp = {
		center : new google.maps.LatLng(37.3804628, -6.0079459),
		zoom : 16,
	};
	var map = new google.maps.Map(document.getElementById("googleMap"), mapProp);
}

/*** CONTRATAR ***/
//Funcion AJAX mostrar tarjeta plan.
$('select#product').on('change', function() {
	$("#ajaxContent").load("/app/ajax/product/" + this.value);
});

// Función recalcular precio total al elegir meses.
$('input#meses').change(function() {
	var meses = parseFloat($('#meses').val());
	var precio = parseFloat($('#precio').text());

	total = precio * meses;
	$('input#total').val(total);
});

// Validaciones.
$("button#contratar").click(function() {
	var product = $("select#product").val();
	var nombre = $("input#nombre").val();
	var meses = $("input#meses").val();
	if (product == '' || nombre == '' || meses == '') {
		toastr["error"]("Por favor, rellena todos los campos.");
		 return false;
	}
});


/*** PRODUCTOS ***/
//Función AJAX al renovar un plan.
$('button.renovar').click(function() {
	$("#ajaxContent").load("/app/ajax/order/" + this.value);
})

/*** LOGIN ***/
// Animación registro
$("button#goReg, button#goLogin").removeClass("waves-effect waves-light");
$("button#goReg, button#goLogin").click(function() {
	$("#login, #registro").toggleClass("girado");
});

//Valdación al registrar.
$("#register").click(function() {
	var name = $("#registroUsuario").val();
	var email = $("#registroEmail").val();
	var cemail = $("#registroConfirmarEmail").val();
	var password = $("#registroPass").val();
	var emailRegex = /^[-\w.%+]{1,64}@(?:[A-Z0-9-]{1,63}\.){1,125}[A-Z]{2,63}$/i;
	if (name == '' || email == '' || cemail == '' || password == '') {
		 toastr["error"]("Por favor, rellena todos los campos.");
		 return false;
	} else if(!emailRegex.test(email)) {
		toastr["error"]("El email no tiene el formato adecuado.");
		return false;
	} else if (!(email).match(cemail)) {
		toastr["error"]("Tus emails no coinciden.");
		return false;
	} else if ((password.length) < 8) {
		toastr["error"]("La contraseña debe tener al menos 8 caracteres.");
		return false;
	}
});

/*** PERFIL ***/
//Validación al cambiar contraseña.
$("#changePass").click(function() {
	var pass = $("#nuevaContrasena").val();
	var cpass = $("#confirmarNuevaContrasena").val();
	if (pass == '' || cpass== '') {
		toastr["error"]("Por favor, rellena todos los campos.");
		return false;
	} else if ((pass.length) < 8) {
		toastr["error"]("La contraseña debe tener al menos 8 caracteres.");
		return false;
	} else if (!(pass).match(cpass)) {
		toastr["error"]("Las contraseñas no coinciden.");
		return false;
	} 
});           