(function (ng) {

    var mod = ng.module("multaModule");

    mod.controller("multaDeleteCtrl", ["$state", "multa", function ($state, multa) {
            this.confirmDelete = function () {
                multa.remove().then(function () {
                    $state.go('multaList', null, {reload: true});
                });
            };
        }]);
})(window.angular);
