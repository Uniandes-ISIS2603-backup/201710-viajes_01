(function (ng) {
    var mod = ng.module("multaModule", ['ui.router']);
    mod.constant("multasContext", "api/multas");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/multas/';
            var basePathMultas = 'src/modules/multas/';
            //var basePathUsuarios = 'src/modules/usuarios/';
            //var basePathReservas = 'src/modules/reservas/;
            $urlRouterProvider.otherwise("/multasList");

            $stateProvider.state('multas', {
                url: '/multas',
                abstract: true,
                resolve: {
                   //multas: ['http', 'multasContext', function($http, multasContext){
                    multas: ['$http', function ($http) {
                           return $http.get('data/multas.json');
                             //return $http.get(multasContext);
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
              /** 
                 resolve:  {
                    currentMulta: ['$http', 'multasContext', '$stateParams', function ($http, multasContext, $params) {
                            return $http.get(multasContext+'/'+$params.multaId);
                        }]
                },
                **/
                views: {
                    'listView': {
                      resolve: {
                            multas: ['$http', function ($http) {
                                    return $http.get('data/multas.json');
                                }]
                        },
                        templateUrl: basePathMultas + 'multas.list.html',
                        controller: ['$scope', 'multas', '$stateParams', function ($scope, multas, $params) {
                                $scope.multasRecords = multas.data;
                                $scope.currentMulta = $scope.multasRecords[$params.multaId - 1];
                            }]
      
                        //  templateUrl: basePath + 'multas.list.html'
                    },
                    'detailView': {
                        templateUrl: basePath + 'multas.detail.html',
                        controller: ['$scope', '$stateParams', function ($scope, $params) {
                                $scope.currentMulta = $scope.multasRecords[$params.multaId-1];
                            }]
                    }

                }

            });
        }]);
})(window.angular);
