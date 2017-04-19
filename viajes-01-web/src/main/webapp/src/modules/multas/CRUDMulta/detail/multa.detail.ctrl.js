(function (ng) {

    var mod = ng.module("multaModule");

    mod.controller("multaDetailCtrl", ['$scope', "$state", "multa",
        function ($scope, $state, multa) {
            $scope.currentMulta = multa;
            $scope.actions = {
                //Post
                create: {
                    displayName: 'Create',
                    icon: 'plus',
                    fn: function () {
                        $state.go('multaNew');
                    }
                },
                //Put
                edit: {
                    displayName: 'Edit',
                    icon: 'edit',
                    fn: function () {
                        $state.go('multaEdit');
                    }
                },
                //Delete
                delete: {
                    displayName: 'Delete',
                    icon: 'minus',
                    fn: function () {
                        $state.go('multaDelete');
                    }
                },
                refresh: {
                    displayName: 'Refresh',
                    icon: 'refresh',
                    fn: function () {
                        $state.reload();
                    }
                },
                //Get
                list: {
                    displayName: 'List',
                    icon: 'th-list',
                    fn: function () {
                        $state.go('multaList');
                    }
                }
            };
        }]);
})(window.angular);