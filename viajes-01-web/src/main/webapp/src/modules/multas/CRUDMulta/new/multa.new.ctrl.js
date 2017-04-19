(function (ng) {

    var mod = ng.module("multaModule");

    mod.controller("multaNewCtrl", ["$scope", "$state", "multas",
        function ($scope, $state, multas) {
            $scope.currentMulta = {};
            $scope.actions = {
                save: {
                    displayName: 'Save',
                    icon: 'save',
                    fn: function () {
                        if ($scope.multaForm.$valid) {
                            multas.post($scope.currentMulta).then(function (rc) {
                                $state.go('multaDetail', {multaId: rc.id}, {reload: true});
                            });
                        }
                    }
                },
                cancel: {
                    displayName: 'Cancel',
                    icon: 'remove',
                    fn: function () {
                        $state.go('multaList');
                    }
                }
            };
        }]);
})(window.angular);
