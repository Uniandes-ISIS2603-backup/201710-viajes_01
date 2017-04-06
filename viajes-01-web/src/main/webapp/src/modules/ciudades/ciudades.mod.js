(function (ng) {
    var mod = ng.module("ciudadModule", ['ui.router']);
    mod.constant("ciudadesContext", "api/ciudades");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/ciudades/';
            var basePathCiudades = 'src/modules/ciudades/';
            var basePathViajes = 'src/modules/viajes/';
            $urlRouterProvider.otherwise("/ciudadesList");

            $stateProvider.state('ciudades', {
                url: '/ciudades',
                abstract: true,
                resolve: {
                    ciudades: ['$http', function ($http) {
                            return $http.get('data/ciudades.json');
                        }]
                },
                views: {
                    'mainView': {
                        templateUrl: basePath + 'ciudades.html',
                        controller: ['$scope', 'ciudades', function ($scope, ciudades) {
                                $scope.ciudadesRecords = ciudades.data;
                            }]
                    }
                }
            }).state('ciudadesList', {
                url: '/list',
                parent: 'ciudades',
                views: {
                    'listView': {
                        templateUrl: basePath + 'ciudades.list.html'
                    }
                }
            }).state('ciudadesNice', {
                url: '/nice',
                parent: 'ciudades',
                views: {
                    'listView': {
                        templateUrl: basePath + 'ciudades.nice.html'
                    }
                }
                
            }).state('ciudadDetail', {
                url: '/{ciudadId:int}/detail',
                parent: 'ciudades',
                param: {
                    ciudadId: null
                },
                views: {
                    'listView': {
                        resolve: {
                            ciudades: ['$http', function ($http) {
                                    return $http.get('data/ciudades.json');
                                }]
                        },
                        templateUrl: basePathCiudades + 'ciudades.list.html',
                        controller: ['$scope', 'ciudades', '$stateParams', function ($scope, ciudades, $params) {
                                $scope.ciudadesRecords = ciudades.data;
                                $scope.currentCiudad = $scope.ciudadesRecords[$params.ciudadId - 1];
                            }]
                    },
                    'detailView': {
                        templateUrl: basePath + 'ciudades.detail.html',
                        controller: ['$scope', '$stateParams', function ($scope, $params) {
                                $scope.currentCiudad = $scope.ciudadesRecords[$params.ciudadId - 1];
                            }]
                    }
                }
            });
        }]);
})(window.angular);