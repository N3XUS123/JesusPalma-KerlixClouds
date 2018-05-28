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
       states : {
           "default-state": {
               gradients: [
                   ['#834D9B', '#D04ED6'],
                   ['#1CD8D2', '#93EDC7']
               ]
           }
       }
    });
}