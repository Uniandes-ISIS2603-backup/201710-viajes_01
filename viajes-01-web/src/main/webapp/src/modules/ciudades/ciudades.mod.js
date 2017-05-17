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
                        templateUrl: basePath + 'ciudades.nice.html',
                        controller: ['$http', 'ciudadesContext', '$stateParams', function ($http, ciudadesContext, $params) {
                                    this.confirmDelete = function () {
                                        alert('LLEGA MALDITA SEA');
                                        return $http.get(ciudadesContext + '/' + $params.ciudadId)
                                    };
                                    this.confirmEdit = function () {
                                        alert('LLEGA MALDITA SEA');
                                        var data = {nombre:'Girardot'} 
                                        $http.post(ciudadesContext + '/' + $params.ciudadId,data)
                                    };
                                    this.confirmCreate = function () {
                                        alert('LLEGA MALDITA SEA');
                                        var data = {nombre:'Fusagasuga'};
                                        $http.post(ciudadesContext,data)
                                    };
                                }],
                        controllerAs: 'ctrl'
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
            }).state('ciudadesDelete', {
                url: '/delete',
                parent: 'ciudades',
                views: {
                    'listView': {
                        ciudades: ['$http', function ($http)
                            {
                                return $http.delete(ciudades.id);
                            }],
                        templateUrl: basePath + 'delete/ciudades.delete.tpl.html',
                        controller: 'ciudadNewCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
        }]);
})(window.angular);