(function (ng) {
    var mod = ng.module("usuarioModule", ['ui.router']);
    mod.constant("usuariosContext", "api/usuarios");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/usuarios/';
            var basePathUsuarios = 'src/modules/usuarios/';
            $urlRouterProvider.otherwise("/usuariosList");

            $stateProvider.state('usuarios', {
                url: '/usuarios',
                abstract: true,
                resolve: {
                    usuarios: ['$http', 'usuariosContext', function ($http, usuariosContext) {
                            return $http.get(usuariosContext);
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
                        templateUrl: basePath + 'usuarios.nice.html',
                        controller: ['$http', 'usuariosContext', '$stateParams', function ($http, usuariosContext, $params) {
                                    this.confirmDelete = function () {
                                        alert('Se ha eliminado, por favor refresque la pagina ');
                                        $http.delete(usuariosContext + '/' + usuariosContext.id);
                                        
                                    };
                                    this.confirmEdit = function () {
                                        alert('Se ha cambiado, por favor refresque la pagina');
                                        var data = {nombre:'cambio'} ;
                                        $http.put(usuariosContext + '/' + 20, data);
                                      
                                    };
                                    this.confirmCreate = function () {
                                        alert('Seguro que quiere crear Juan');
                                        var data = {nombre:'Juan'};
                                        $http.post(usuariosContext,data);
                                        alert('Hemos creado a Juan correctamente');
                                    };
                                }],
                        controllerAs: 'ctrl'
                    }
                }
            }).state('usuarioDetail', {
                url: '/{usuarioId:int}/detail',
                parent: 'usuarios',
                param: {
                    usuarioId: null
                },
                resolve: {
                    currentUsuario: ['$http', 'usuariosContext', '$stateParams', function ($http, usuariosContext, $params) {
                            return $http.get(usuariosContext + '/' + $params.usuarioId);
                        }]
                },
                views: {
                    'listView': {
                        resolve: {
                            usuarios: ['$http', 'usuariosContext', function ($http, usuariosContext) {
                                    return $http.get(usuariosContext);
                                }]
                        },
                        templateUrl: basePathUsuarios + 'usuarios.list.html',
                        controller: ['$scope', 'currentUsuario', function ($scope, currentUsuario) {
                                $scope.currentUsuario = currentUsuario.data;
                            }]
                    },
                    'detailView': {
                        templateUrl: basePath + 'usuarios.detail.html',
                        controller: ['$scope', 'currentUsuario', function ($scope, currentUsuario) {
                                $scope.currentUsuario = currentUsuario.data;
                            }]
                    }
                }
                
            }).state('usuariosDelete', {
                url: '/delete',
                parent: 'usuarios',
                views: {
                    'listView': {
                        usuarios: ['$http', function ($http)
                            {
                                return $http.delete(usuarios.id);
                            }],
                        templateUrl: basePath + 'delete/usuarios.delete.tpl.html',
                        controller: 'usuarioNewCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('usuariosEdit', {
                url: '/edit',
                parent: 'usuarios',
                views: {
                    'listView': {
                        usuarios: ['$http', function ($http)
                            {
                                return $http.edit(usuarios.id);
                            }],
                        templateUrl: basePath + 'edit/usuarios.edit.tpl.html'
                       
                    }
                }
            });
        }]);
})(window.angular);