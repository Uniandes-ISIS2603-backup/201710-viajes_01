
(function (ng) {

    var mod = ng.module("viajeModule");

    mod.controller("viajeDeleteCtrl", ["$state", "viajes", function ($state, viajes) {
            this.confirmDelete = function () {
                viajes.remove().then(function () {
                    $state.go('viajesList', null, {reload: true});
                });
            };
        }]);
})(window.angular);
