
(function (ng) {

    var mod = ng.module("reservaModule");

    mod.controller("usuarioDeleteCtrl", ["$state", "reservas", function ($state, reservas) {
            this.confirmDelete = function () {
                reservas.remove().then(function () {
                    $state.go('reservasList', null, {reload: true});
                });
            };
        }]);
})(window.angular);
