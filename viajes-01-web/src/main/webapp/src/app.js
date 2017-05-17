(function (ng) {
    var app = angular.module('mainApp', [
        // External dependencies
        'ui.router','multaModule','ciudadModule', 'viajeModule',
        'vehiculoModule',
        'reservaModule',
        'usuarioModule'
        

    ]);
    
   var loggedIn = false;

	app.controller('MainController', function(){
		this.loggedIn = false;
	});
    
    // Resuelve problemas de las promesas
    app.config(['$qProvider', function ($qProvider) {
            $qProvider.errorOnUnhandledRejections(false);
        }]);
})(window.angular);
