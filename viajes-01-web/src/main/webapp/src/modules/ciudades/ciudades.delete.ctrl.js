(function (ng) {

    var mod = ng.module("ciudaddModule", ['ui.router']);
    

    mod.controller("ciudadDeleteCtrl", ["$http", "$state", function ($http, $state) {
            this.confirmDelete = function (id) {
                alert('LLEGA MALDITA SEA');
                $http.delete('api/ciudades/' + id).then(function () {
                    $state.go('ciudadesNice', null, {reload: true});
                });
            };
        }]);
})(window.angular);
