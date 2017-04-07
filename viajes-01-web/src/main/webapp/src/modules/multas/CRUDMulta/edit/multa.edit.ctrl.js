(function (ng) {

    var mod = ng.module("multaModule");

    mod.controller("multaEditCtrl", ["$scope", "$state", "multa",
        function ($scope, $state, multa) {
            $scope.currentMulta = multa;
            $scope.actions = {
                save: {
                    displayName: 'Save',
                    icon: 'save',
                    fn: function () {
                        if ($scope.multaForm.$valid) {
                            $scope.currentMulta.put().then(function (rc) {
                                $state.go('multaDetail', {multaId: rc.id}, {reload: true});
                            });
                        }
                    }
                },
                cancel: {
                    displayName: 'Cancel',
                    icon: 'remove',
                    fn: function () {
                        $state.go('multaDetail');
                    }
                }
            };
        }]);
})(window.angular);
