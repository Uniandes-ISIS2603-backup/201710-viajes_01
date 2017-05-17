
(function (ng) {

    var mod = ng.module("vehiculoModule");

    mod.controller("vehiculoDeleteCtrl", ["$state", "vehiculos", function ($state, vehiculos) {
            this.confirmDelete = function () {
                vehiculos.remove().then(function () {
                    $state.go('vehiculosList', null, {reload: true});
                });
            };
        }]);
})(window.angular);
