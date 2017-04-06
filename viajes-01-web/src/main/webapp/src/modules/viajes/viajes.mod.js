(function (ng) {
    var mod = ng.module("viajeModule", ['ui.router']);
    mod.constant("viajesContext", "api/viajes");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/viajes/';
            var basePathViajes = 'src/modules/viajes/';
            $urlRouterProvider.otherwise("/viajesList");

            $stateProvider.state('viajes', {
                url: '/viajes',
                abstract: true,
                resolve: {
                    viajes: ['$http', function ($http) {
                            return $http.get('data/viajes.json');
                        }]
                },
                views: {
                    'mainView': {
                        templateUrl: basePath + 'viajes.html',
                        controller: ['$scope', 'viajes', function ($scope, viajes) {
                                $scope.viajesRecords = viajes.data;
                            }]
                    }
                }
            }).state('viajesList', {
                url: '/list',
                parent: 'viajes',
                views: {
                    'listView': {
                        templateUrl: basePath + 'viajes.list.html'
                    }
                }
            }).state('viajesNice', {
                url: '/nice',
                parent: 'viajes',
                views: {
                    'listView': {
                        templateUrl: basePath + 'viajes.nice.html'
                    }
                }
            }).state('viajeDetail', {
                url: '/{viajeId:int}/detail',
                parent: 'viajes',
                param: {
                    viajeId: null
                },
                views: {
                    'listView': {
                        resolve: {
                            viajes: ['$http', function ($http) {
                                    return $http.get('data/viajes.json');
                                }]
                        },
                        templateUrl: basePathViajes + 'viajes.list.html',
                        controller: ['$scope', 'viajes', '$stateParams', function ($scope, viajes, $params) {
                                $scope.viajesRecords = viajes.data;
                                $scope.currentViaje = $scope.viajesRecords[$params.viajeId - 1];
                            }]
                    },
                    'detailView': {
                        templateUrl: basePath + 'viajes.detail.html',
                        controller: ['$scope', '$stateParams', function ($scope, $params) {
                                $scope.currentViaje = $scope.viajesRecords[$params.viajeId - 1];
                            }]
                    }
                }
            });
        }]);
})(window.angular);