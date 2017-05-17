(function (ng) {
    var mod = ng.module("vehiculoModule", ['ui.router']);
    mod.constant("vehiculosContext", "api/vehiculos");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/vehiculos/';
            var basePathVehiculos = 'src/modules/vehiculos/';
            $urlRouterProvider.otherwise("/vehiculosList");
            
            $stateProvider.state('vehiculos', {
                url: '/vehiculos',
                abstract: true,
                resolve: {
                   vehiculos: ['$http', 'vehiculosContext', function ($http, vehiculosContext) {
                            return $http.get(vehiculosContext);
                        }]
                },
                views: {
                    'mainView': {
                        templateUrl: basePath + 'vehiculos.html',
                        controller: ['$scope', 'vehiculos', function ($scope, vehiculos) {
                                $scope.vehiculosRecords = vehiculos.data;
                        }]
                    }
                }
            }).state('vehiculosList', {
                url: '/list',
                parent: 'vehiculos',
                views: {
                    'listView': {
                        templateUrl: basePath + 'vehiculos.list.html'
                    }
                }
            }).state('vehiculosNice', {
                url: '/nice',
                parent: 'vehiculos',
                views: {
                    'listView': {
                        templateUrl: basePath + 'vehiculos.nice.html'
                    }
                }
            }).state('vehiculoDetail', {
                url: '/{vehiculoId:int}/detail',
                parent: 'vehiculos',
                param: {
                    vehiculoId: null
                },
                resolve: {
                    currentVehiculo: ['$http', 'vehiculosContext', '$stateParams', function ($http, vehiculosContext, $params) {
                            return $http.get(vehiculosContext + '/' + $params.vehiculoId);
                        }]
                },
                views: {
                    'listView': {
                        resolve: {
                            vehiculos: ['$http', 'vehiculosContext', function ($http, vehiculosContext) {
                                    return $http.get(vehiculosContext);
                                }]
                        },
                        templateUrl: basePathVehiculos + 'vehiculos.list.html',
                        controller: ['$scope', 'currentVehiculo', function ($scope, currentVehiculo) {
                                $scope.currentVehiculo = currentVehiculo.data;
                            }]
                    },
                    'detailView': {
                        templateUrl: basePath + 'vehiculos.detail.html',
                        controller: ['$scope', 'currentVehiculo', function ($scope, currentVehiculo) {
                                $scope.currentVehiculo = currentVehiculo.data;
                            }]
                    }
                }
            }).state('viajessDelete', {
                url: '/delete',
                parent: 'vehiculos',
                views: {
                    'listView': {
                        vehiculos: ['$http', function ($http)
                            {
                                return $http.delete(vehiculos.id);
                            }],
                        templateUrl: basePath + 'delete/vehiculos.delete.tpl.html',
                        controller: 'vehiculoNewCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
    }]);
}) (window.angular);