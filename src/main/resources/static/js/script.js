/*** Inicializar wow ***/
new WOW().init();

/*** Login ***/
function login() {
    $("button").removeClass("waves-effect waves-light");
    $("#goReg, #goLogin").click(function() {
        $("#login, #registro").toggleClass("girado");
    });
    
    var granimInstance = new Granim({
       element: '#granim-canvas',
       name: 'granim',
       opacity: [1, 1],
       states : {"default-state": {gradients: [['#834D9B', '#D04ED6'], ['#1CD8D2', '#93EDC7']]}}
    });

	    
	$("#register").click(function() {
		var name = $("#registroUsuario").val();
		var email = $("#registroEmail").val();
		var cemail = $("#registroConfirmarEmail").val();
		var password = $("#registroPass").val();
		if (name == '' || email == ''|| password == ''|| cpassword == '') {
			alert("Por favor, rellena todos los campos.");
		} else if ((password.length) < 8) {
			alert("La contraseña debe tener al menos 8 caracteres.");
		} else if (!(email).match(cemail)) {
			alert("Tus emails no coinciden.");
		} else {
			
		}
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

$('.renovar').click(function() {
	$("#ajaxContent").load("/app/ajax/order/" + this.value);
})

/*** Contratar ***/
function contratar(){
	$('select').on('change', function() {
		$("#ajaxContent").load("/app/ajax/product/" + this.value);
	});
	$('#meses').change(function() {

		var meses = parseFloat($('#meses').val());
		var precio = parseFloat($('#precio').text());

		total = precio * meses;
		$('#total').val(total);
	});
}