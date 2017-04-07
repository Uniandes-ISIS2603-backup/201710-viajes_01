(function (ng) {
    var mod = ng.module("vehiculoModule", ['ui.router']);
    mod.constant("vehiculosContext", "api/vehiculos");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/vehiculos/';
            var basePathVehiculos = 'src/modules/vehiculos/';
            $urlRouterProvider.otherwise("/vehiculosList");
            
            $stateProvider.state('books', {
                url: '/vehiculos',
                abstract: true,
                resolve: {
                    vehiculos: ['$http', function ($http){
                            return $http.get('data/vehiculos.json');
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
            }).state('vehiculosList',{
                url: '/list',
                parent: 'viajes',
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
                views: {
                    'listView': {
                        resolve: {
                            vehiculos: ['$http', function ($http) {
                                    return $http.get('data/vehiculos.json');
                            }]
                        },
                        templateUrl: basePathVehiculos + 'vehiculos.list.html',
                        controller: ['$scope', 'vehiculos', '$stateParams', function ($scope, vehiculos, $params) {
                                $scope.vehiculosRecords = vehiculos.data;
                                $scope.currentVehiculo = $scope.vehiculosRecords[$params.vehiculoId - 1];
                        }]
                    },
                    'detailView': {
                        templateUrl: basePathVehiculos + 'vehiculos.detail.html',
                        controller: ['$scope', '$stateParams', function ($scope, $params) {
                                $scope.currentVehiculo = $scope.vehiculosRecords[$params.vehiculoId - 1];
                            }]
                    }
                }
            });
    }]);
}) (window.angular);