
(function (ng) {

    var mod = ng.module("usuarioModule");

    mod.controller("usuariosDetailCtrl", ['$scope', "$state", "usuarios",
        function ($scope, $state, usuarios) {
            $scope.currentRecord = usuarios;
            $scope.actions = {
                create: {
                    displayName: 'Create',
                    icon: 'plus',
                    fn: function () {
                        $state.go('usuariosNew');
                    }
                },
                edit: {
                    displayName: 'Edit',
                    icon: 'edit',
                    fn: function () {
                        $state.go('usuariosEdit');
                    }
                },
                delete: {
                    displayName: 'Delete',
                    icon: 'minus',
                    fn: function () {
                        $state.go('usuariosDelete');
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
                        $state.go('usuariosList');
                    }
                }
            };
        }]);
})(window.angular);
