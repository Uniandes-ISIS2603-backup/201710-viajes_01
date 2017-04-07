
(function (ng) {

    var mod = ng.module("usuarioModule");

    mod.controller("usuarioDeleteCtrl", ["$state", "usuarios", function ($state, usuarios) {
            this.confirmDelete = function () {
                usuarios.remove().then(function () {
                    $state.go('usuariosList', null, {reload: true});
                });
            };
        }]);
})(window.angular);
