
(function (ng) {

    var mod = ng.module("multaModule");

    mod.controller("multaDeleteCtrl", ["$state", "multas", function ($state, multas) {
            this.confirmDelete = function () {
                multas.remove().then(function () {
                    $state.go('multasList', null, {reload: true});
                });
            };
        }]);
})(window.angular);
