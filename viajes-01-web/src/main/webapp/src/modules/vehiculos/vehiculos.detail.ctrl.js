
(function (ng) {

    var mod = ng.module("vehiculoModule");

    mod.controller("vehiculoDetailCtrl", ['$scope', "$state", "vehiculos",
        function ($scope, $state, vehiculos) {
            $scope.currentRecord = vehiculos;
            $scope.actions = {
                create: {
                    displayName: 'Create',
                    icon: 'plus',
                    fn: function () {
                        $state.go('vehiculosNew');
                    }
                },
                edit: {
                    displayName: 'Edit',
                    icon: 'edit',
                    fn: function () {
                        $state.go('vehiculosEdit');
                    }
                },
                delete: {
                    displayName: 'Delete',
                    icon: 'minus',
                    fn: function () {
                        $state.go('vehiculosDelete');
                    }
                },
                refresh: {
                    displayName: 'Refresh',
                    icon: 'refresh',
                    fn: function () {
                        $state.reload();
                    }
                },
                list: {
                    displayName: 'List',
                    icon: 'th-list',
                    fn: function () {
                        $state.go('vehiculosList');
                    }
                }
            };
        }]);
})(window.angular);
