(function (ng) {
    var mod = ng.module("usuarioModule", ['ui.router']);
    mod.constant("usuariosContext", "api/usuarios");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/usuarios/';
            var basePathUsuarios = 'src/modules/usuarios/';
            var basePathViajes = 'src/modules/viajes/';
            $urlRouterProvider.otherwise("/usuariosList");

            $stateProvider.state('usuarios', {
                url: '/usuarios',
                abstract: true,
                resolve: {
                    usuarios: ['$http', function ($http) {
                            return $http.get('data/usuarios.json');
                        }]
                },
                views: {
                    'mainView': {
                        templateUrl: basePath + 'usuarios.html',
                        controller: ['$scope', 'usuarios', function ($scope, usuarios) {
                                $scope.usuariosRecords = usuarios.data;
                            }]
                    }
                }
            }).state('usuariosList', {
                url: '/list',
                parent: 'usuarios',
                views: {
                    'listView': {
                        templateUrl: basePath + 'usuarios.list.html'
                    }
                }
                }).state('usuariosNice', {
                url: '/nice',
                parent: 'usuarios',
                views: {
                    'listView': {
                        templateUrl: basePath + 'usuarios.nice.html'
                    }
                }
            }).state('usuariosDetail', {
                url: '/{usuariosId:int}/detail',
                parent: 'usuarios',
                param: {
                    usuariosId: null
                },
                views: {
                    'listView': {
                        resolve: {
                            usuarios: ['$http', function ($http) {
                                    return $http.get('data/usuarios.json');
                                }]
                        },
                        templateUrl: basePathUsuarios + 'usuarios.list.html',
                        controller: ['$scope', 'usuarios', '$stateParams', function ($scope, usuarios, $params) {
                                $scope.usuariosRecords = usuarios.data;
                                $scope.currentUsuario = $scope.usuariosRecords[$params.usuarioId - 1];
                            }]
                    },
                    'detailView': {
                        templateUrl: basePath + 'usuarios.detail.html',
                        controller: ['$scope', '$stateParams', function ($scope, $params) {
                                $scope.currentUsuario = $scope.usuariosRecords[$params.usuariosId - 1];
                            }]
                    }
                }
            });
        }]);
})(window.angular);