(function (ng) {
    var mod = ng.module("ciudadModule", ['ui.router']);
    mod.constant("ciudadesContext", "api/ciudades");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/ciudades/';
            $urlRouterProvider.otherwise("/ciudadesList");

            $stateProvider.state('ciudades', {
                url: '/ciudades',
                abstract: true,
                resolve: {
                    ciudades: ['$http', 'ciudadesContext', function ($http, ciudadesContext) {
                            return $http.get(ciudadesContext);
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
                resolve: {
                    currentCiudad: ['$http', 'ciudadesContext', '$stateParams', function ($http, ciudadesContext, $params) {
                            return $http.get(ciudadesContext + '/' + $params.ciudadId);
                        }]
                },
                views: {
                    'listView': {
                        resolve: {
                            ciudades: ['$http', 'ciudadesContext', function ($http, ciudadesContext) {
                                    return $http.get(ciudadesContext);
                                }]
                        },
                        templateUrl: basePath + 'ciudades.list.html',
                        controller: ['$scope', 'currentCiudad', function ($scope, currentCiudad) {
                                $scope.currentCiudad = currentCiudad.data;
                            }]
                    },
                    'detailView': {
                        templateUrl: basePath + 'ciudades.detail.html',
                        controller: ['$scope', 'currentCiudad', function ($scope, currentCiudad) {
                                $scope.currentCiudad = currentCiudad.data;
                            }]
                    }
                }
            });
        }]);
})(window.angular);