
(function (ng) {

    var mod = ng.module("reservaModule");

    mod.controller("reservasDetailCtrl", ['$scope', "$state", "reservas",
        function ($scope, $state, reservas) {
            $scope.currentRecord = reservas;
            $scope.actions = {
                create: {
                    displayName: 'Create',
                    icon: 'plus',
                    fn: function () {
                        $state.go('reservaNew');
                    }
                },
                edit: {
                    displayName: 'Edit',
                    icon: 'edit',
                    fn: function () {
                        $state.go('reservasEdit');
                    }
                },
                delete: {
                    displayName: 'Delete',
                    icon: 'minus',
                    fn: function () {
                        $state.go('reservasDelete');
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
                        $state.go('reservasList');
                    }
                }
            };
        }]);
})(window.angular);
