(function (ng) {
    var mod = ng.module("multaModule", ['ui.router']);
    mod.constant("multasContext", "api/multas");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/multas/';
            var basePathMultas = 'src/modules/multas/';
            $urlRouterProvider.otherwise("/multasList");

            $stateProvider.state('multas', {
                url: '/multas',
                abstract: true,
                resolve: {
                   multas: ['$http', 'multasContext', function ($http, multasContext) {
                            return $http.get(multasContext);
                        }]
                },
                views: {
                    'mainView': {
                        templateUrl: basePath + 'multas.html',
                        controller: ['$scope', 'multas', function ($scope, multas) {
                                $scope.multasRecords = multas.data;
                            }]
                    }
                }
            }).state('multasNice', {
                url: '/nice',
                parent: 'multas',
                views: {
                    'listView': {
                        templateUrl: basePath + 'multas.nice.html'
                    }
                }
            }).state('multasList', {
                url: '/list',
                parent: 'multas',
                views: {
                    'listView': {
                        templateUrl: basePath + 'multas.list.html'
                    }
                }          
            }).state('multaDetail', {
                url: '/{multaId:int}/detail',
                parent: 'multas',
                param: {
                    multaId: null
                },            
                resolve: {
                    currentMulta: ['$http', 'multasContext', '$stateParams', function ($http, multasContext, $params) {
                            return $http.get(multasContext + '/' + $params.multaId);
                        }]
                },
                views: {
                    'listView': {
                        resolve: {
                            multas: ['$http', 'multasContext', function ($http, multasContext) {
                                    return $http.get(multasContext);
                                }]
                        },
                        templateUrl: basePathMultas + 'multas.list.html',
                        controller: ['$scope', 'currentMulta', function ($scope, currentMulta) {
                                $scope.currentMulta = currentMulta.data;
                            }]
                    },
                    'detailView': {
                        templateUrl: basePath + 'multas.detail.html',
                        controller: ['$scope', 'currentMulta', function ($scope, currentMulta) {
                                $scope.currentMulta = currentMulta.data;
                            }]
                    }
                }

            }).state('multasDelete', {
                url: '/delete',
                parent: 'multas',
                views: {
                    'listView': {
                        multas: ['$http', function ($http)
                            {
                                return $http.delete(multas.id);
                            }],
                        templateUrl: basePath + 'delete/multas.delete.tpl.html',
                        controller: 'multaNewCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
        }]);
})(window.angular);
