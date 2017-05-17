
(function (ng) {

    var mod = ng.module("viajeModule");

    mod.controller("viajesDetailCtrl", ['$scope', "$state", "viajes",
        function ($scope, $state, viajes) {
            $scope.currentRecord = viajes;
            $scope.actions = {
                create: {
                    displayName: 'Create',
                    icon: 'plus',
                    fn: function () {
                        $state.go('viajesNew');
                    }
                },
                edit: {
                    displayName: 'Edit',
                    icon: 'edit',
                    fn: function () {
                        $state.go('viajesEdit');
                    }
                },
                delete: {
                    displayName: 'Delete',
                    icon: 'minus',
                    fn: function () {
                        $state.go('viajesDelete');
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
                        $state.go('viajesList');
                    }
                }
            };
        }]);
})(window.angular);
