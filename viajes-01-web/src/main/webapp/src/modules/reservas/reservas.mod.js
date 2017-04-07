(function (ng) {
    var mod = ng.module("reservaModule", ['ui.router']);
    mod.constant("reservasContext", "api/reservas");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/reservas/';
            $urlRouterProvider.otherwise("/reservasList");

            $stateProvider.state('reservas', {
                url: '/reservas',
                abstract: true,
                resolve: {
                    reservas: ['$http', function ($http) {
                            return $http.get('data/reservas.json');
                        }]
                },
                views: {
                    'mainView': {
                        templateUrl: basePath + 'reservas.html',
                        controller: ['$scope', 'reservas', function ($scope, reservas) {
                                $scope.reservasRecords = reservas.data;
                            }]
                    }
                }
            }).state('reservasList', {
                url: '/list',
                parent: 'reservas',
                views: {
                    'listView': {
                        templateUrl: basePath + 'reservas.list.html'
                    }
                }
            }).state('reservaDetail', {
                url: '/{reservaId:int}/detail',
                parent: 'reservas',
                param: {
                    reservaId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + 'reservas.detail.html',
                        controller: ['$scope', '$stateParams', function ($scope, $params) {
                                $scope.currentReserva = $scope.reservasRecords[$params.reservaId - 1];
                            }]
                    }
                }
            });
        }]);
})(window.angular);