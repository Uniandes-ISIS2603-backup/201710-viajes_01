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
                    viajes: ['$http', 'viajesContext', function ($http, viajesContext) {
                            return $http.get(viajesContext);
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
                resolve: {
                    currentViaje: ['$http', 'viajesContext', '$stateParams', function ($http, viajesContext, $params) {
                            return $http.get(viajesContext + '/' + $params.viajeId);
                        }]
                },
                views: {
                    'listView': {
                        resolve: {
                            viajes: ['$http', 'viajesContext', function ($http, viajesContext) {
                                    return $http.get(viajesContext);
                                }]
                        },
                        templateUrl: basePathViajes + 'viajes.list.html',
                        controller: ['$scope', 'currentViaje', function ($scope, currentViaje) {
                                $scope.currentViaje = currentViaje.data;
                            }]
                    },
                    'detailView': {
                        templateUrl: basePath + 'viajes.detail.html',
                        controller: ['$scope', 'currentViaje', function ($scope, currentViaje) {
                                $scope.currentViaje = currentViaje.data;
                            }]
                    }
                }
            }).state('viajesDelete', {
                url: '/delete',
                parent: 'viajes',
                views: {
                    'listView': {
                        viajes: ['$http', function ($http)
                            {
                                return $http.delete(viajes.id);
                            }],
                        templateUrl: basePath + 'delete/viajes.delete.tpl.html',
                        controller: 'viajeNewCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
            ;
        }]);
})(window.angular);