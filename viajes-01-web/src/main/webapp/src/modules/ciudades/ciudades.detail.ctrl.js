
(function (ng) {

    var mod = ng.module("ciudadModule");

    mod.controller("reservasDetailCtrl", ['$scope', "$state", "ciudades",
        function ($scope, $state, ciudades) {
            $scope.currentRecord = ciudades;
            $scope.actions = {
                create: {
                    displayName: 'Create',
                    icon: 'plus',
                    fn: function () {
                        $state.go('ciudadesNew');
                    }
                },
                edit: {
                    displayName: 'Edit',
                    icon: 'edit',
                    fn: function () {
                        $state.go('ciudadesEdit');
                    }
                },
                delete: {
                    displayName: 'Delete',
                    icon: 'minus',
                    fn: function () {
                        $state.go('ciudadesDelete');
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
                        $state.go('ciudadesList');
                    }
                }
            };
        }]);
})(window.angular);
