
(function (ng) {

    var mod = ng.module("viajeModule");

    mod.controller("viajeEditCtrl", ["$scope", "$state", "viajes",
        function ($scope, $state, viajes) {
            $scope.currentRecord = viajes;
            $scope.actions = {
                save: {
                    displayName: 'Save',
                    icon: 'save',
                    fn: function () {
                        if ($scope.viajeForm.$valid) {
                            $scope.currentRecord.put().then(function (rc) {
                                $state.go('viajeDetail', {viajeId: rc.id}, {reload: true});
                            });
                        }
                    }
                },
                cancel: {
                    displayName: 'Cancel',
                    icon: 'remove',
                    fn: function () {
                        $state.go('viajeDetail');
                    }
                }
            };
        }]);
})(window.angular);
