
(function (ng) {

    var mod = ng.module("usuarioModule");

    mod.controller("usuarioEditCtrl", ["$scope", "$state", "usuarios",
        function ($scope, $state, usuarios) {
            $scope.currentRecord = usuarios;
            $scope.actions = {
                save: {
                    displayName: 'Save',
                    icon: 'save',
                    fn: function () {
                        if ($scope.usuarioForm.$valid) {
                            $scope.currentRecord.put().then(function (rc) {
                                $state.go('usuarioDetail', {usuarioId: rc.id}, {reload: true});
                            });
                        }
                    }
                },
                cancel: {
                    displayName: 'Cancel',
                    icon: 'remove',
                    fn: function () {
                        $state.go('usuarioDetail');
                    }
                }
            };
        }]);
})(window.angular);
