
(function (ng) {

    var mod = ng.module("ciudadModule");

    mod.controller("ciudadDeleteCtrl", ["$state", "ciudades", function ($state, ciudades) {
            this.confirmDelete = function () {
                ciudades.remove().then(function () {
                    $state.go('ciudadesList', null, {reload: true});
                });
            };
        }]);
})(window.angular);
