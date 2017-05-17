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
                    reservas: ['$http', 'reservasContext', function ($http, reservasContext) {
                            return $http.get(reservasContext);
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
            }).state('reservasNice', {
                url: '/nice',
                parent: 'reservas',
                views: {
                    'listView': {
                        templateUrl: basePath + 'reservas.nice.html'
                    }
                }
            }).state('reservaNew', {
                url: '/new',
                parent: 'reservas',
                views: {
                    'reservaView': {
                        templateUrl: basePath + 'reservas.new.html',
                        controller: 'reservaNewCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('reservaDetail', {
                url: '/{reservaId:int}/detail',
                parent: 'reservas',
                param: {
                    reservaId: null
                },
                resolve: {
                    currentReserva: ['$http', 'reservasContext', '$stateParams', function ($http, reservasContext, $params) {
                            return $http.get(reservasContext + '/' + $params.reservaId);
                        }]
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + 'reservas.detail.html',
                        controller: ['$scope', 'currentReserva', function ($scope, currentReserva) {
                                $scope.currentReserva = currentReserva.data;
                            }]
                    }
                }
            });
        }]);
})(window.angular);