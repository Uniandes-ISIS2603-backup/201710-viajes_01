(function (ng) {
    var mod = ng.module("reservaModule", ['ui.router']);
    mod.constant("reservasContext", "api/reservas");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/reservas/';
            $urlRouterProvider.otherwise("/reservasList");

            $stateProvider.state('reservas', {
                url: '/reservas',
                abstract: true,
                resolve: {
                    reservas: ['$http', 'reservasContext', function ($http, reservasContext) {
                            return $http.get(reservasContext);
                        }]
                },
                views: {
                    'mainView': {
                        templateUrl: basePath + 'reservas.html',
                        controller: ['$scope', 'reservas', function ($scope, reservas) {
                                $scope.reservasRecords = reservas.data;
                            }]
                    }
                }
            }).state('reservasList', {
                url: '/list',
                parent: 'reservas',
                views: {
                    'listView': {
                        templateUrl: basePath + 'reservas.list.html'
                    }
                }
            }).state('reservasNice', {
                url: '/nice',
                parent: 'reservas',
                views: {
                    'listView': {
                        templateUrl: basePath + 'reservas.nice.html',
                        controller: ['$http', 'reservasContext', '$stateParams', '$scope', function ($http, reservasContext, $stateParams, $scope) {
                                    $scope.campos = {
                                        pas : 0,
                                        pre : 0.0,
                                        com : 0.0
                                    };
                                    this.confirmDelete = function ($params) {
                                        alert('¿Seguro que quiere eliminarlo?');
                                        $http.delete(reservasContext+"/"+$params.reservaId);
                                    };
                                    this.confirmEdit = function () {
                                        
                                    };
                                    this.confirmCreate = function () {
                                        var data = {
                                            pasajeros : $scope.campos.pas,
                                            precio : $scope.campos.pre,
                                            comision : $scope.campos.com
                                        };
                                        $http.post(reservasContext, data);
                                        alert('Se ha creado la reserva correctamente');
                                    };
                                }],
                        controllerAs: 'ctrl'
                    }
                }
            }).state('reservaNew', {
                url: '/new',
                parent: 'reservas',
                views: {
                    reservaView: {
                        templateUrl: basePath + 'reservas.new.html',
                        controller: ['$http', 'reservasContext', '$stateParams', function ($http, reservasContext) {
                                    this.campos = {
                                        pasajeros : 0,
                                        precio : 0.0,
                                        comision : 0.0
                                    },
                                    this.crear = function(){
                                        alert('Se creara la reserva');
                                    }
                                    this.confirmDelete = function (id) {
                                        alert('Seguro que quiere eliminarlo? ');
                                        $http.delete(reservasContext, "/"+id);
                                    };
                                    this.confirmEdit = function () {
                                        $state.go('reservaNew');
                                    };
                                    this.confirmCreate = function () {
                                        alert('Se creara la reserva');
                                        var data = {precio:10000.0, comision:100.0, pasajeros:10};
                                        $http.post(reservasContext,data);
                                        alert('Se ha creado la resserva correctamente');
                                    };
                                }],
                        controllerAs: 'ctrl'
                    }
                }
            }).state('reservaDetail', {
                url: '/{reservaId:int}/detail',
                parent: 'reservas',
                param: {
                    reservaId: null
                },
                resolve: {
                    currentReserva: ['$http', 'reservasContext', '$stateParams', function ($http, reservasContext, $params) {
                            return $http.get(reservasContext + '/' + $params.reservaId);
                        }]
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + 'reservas.detail.html',
                        controller: ['$scope', 'currentReserva', function ($scope, currentReserva) {
                                $scope.currentReserva = currentReserva.data;
                            }]
                    }
                }
            }).state('reservasDelete', {
                url: '/delete',
                parent: 'reservas',
                views: {
                    'listView': {
                        reservas: ['$http', function ($http)
                            {
                                return $http.delete(reservas.id);
                            }],
                        templateUrl: basePath + 'delete/reservas.delete.tpl.html',
                        controller: 'reservaNewCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
        }]);
})(window.angular);