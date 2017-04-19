(function (ng) {
    var mod = ng.module('multaModule', ['ngCrud', 'ui.router']);

    mod.constant('multaModel', {
        name: 'multa',
        displayName: 'Multa',
        url: 'multas',
        fields: {
            id: {
                displayName: 'Id',
                type: 'Long',
                required: true
            },
            valor: {
                displayName: 'Valor',
                type: 'Double',
                required: true
            },
            fecha: {
                displayName: 'Fecha',
                type: 'Date',
                required: true
            },
            descripcion: {
                displayName: 'Descripcion',
                type: 'String',
                required: true
            }        }
    });

    mod.config(['$stateProvider',
        function($sp){
            var basePath = 'src/modules/multas/';
            var baseInstancePath = basePath + 'CRUDMulta/';

            $sp.state('multa', {
                url: '/multas?page&limit',
                abstract: true,
                
                views: {
                     mainView: {
                        templateUrl: basePath + 'multa.tpl.html',
                        controller: 'multaCtrl'
                    }
                },
                resolve: {
                    model: 'multaModel',
                    multas: ['Restangular', 'model', '$stateParams', function (r, model, $params) {
                            return r.all(model.url).getList($params);
                        }]
                }
            });
            $sp.state('multaList', {
                url: '/list',
                parent: 'multa',
                views: {
                    multaView: {
                        templateUrl: baseInstancePath + 'list/multa.list.tpl.html',
                        controller: 'multaListCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
            $sp.state('multaNew', {
                url: '/new',
                parent: 'multa',
                views: {
                    multaView: {
                        templateUrl: baseInstancePath + 'new/multa.new.tpl.html',
                        controller: 'multaNewCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
            $sp.state('multaInstance', {
                url: '/{multaId:int}',
                abstract: true,
                parent: 'multa',
                views: {
                    multaView: {
                        template: '<div ui-view="multaInstanceView"></div>'
                    }
                },
                resolve: {
                    multa: ['multas', '$stateParams', function (multas, $params) {
                            return multas.get($params.multaId);
                        }]
                }
            });
            $sp.state('multaDetail', {
                url: '/details',
                parent: 'multaInstance',
                views: {
                    multaInstanceView: {
                        templateUrl: baseInstancePath + 'detail/multa.detail.tpl.html',
                        controller: 'multaDetailCtrl'
                    }
                }
            });
            $sp.state('multaEdit', {
                url: '/edit',
                sticky: true,
                parent: 'multaInstance',
                views: {
                    multaInstanceView: {
                        templateUrl: baseInstancePath + 'edit/multa.edit.tpl.html',
                        controller: 'multaEditCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
            $sp.state('multaDelete', {
                url: '/delete',
                parent: 'multaInstance',
                views: {
                    multaInstanceView: {
                        templateUrl: baseInstancePath + 'delete/multa.delete.tpl.html',
                        controller: 'multaDeleteCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
	}]);
})(window.angular);