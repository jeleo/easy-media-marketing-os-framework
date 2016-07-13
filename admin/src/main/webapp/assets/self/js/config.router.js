'use strict';

/**
 * Config for the router
 */
angular.module('app')
    .run(
    ['$rootScope', '$state', '$stateParams', 'UserAuthentication',
        function ($rootScope, $state, $stateParams, UserAuthentication) {
            $rootScope.$state = $state;
            $rootScope.$stateParams = $stateParams;
            $rootScope.$on('$stateChangeStart',function(event, toState, toParams, fromState, fromParams){
                if (toState.name.indexOf("access") != -1) {
                    return;
                }
                var promise = UserAuthentication.isAuthenticated();
                promise.then(function(data) {
                    if (data.errcode == 10010) {
                        // 取消默认跳转行为
                        event.preventDefault();
                        $state.go('access.signin');
                    }
                }, function(data) { // 处理错误 .reject
                    console.log("err " + data);
                });
            });
        }
    ]
)
    .config(
    ['$stateProvider', '$urlRouterProvider', 'JQ_CONFIG', 'MODULE_CONFIG',
        function ($stateProvider, $urlRouterProvider, JQ_CONFIG, MODULE_CONFIG) {
            var layout = "views/app.html";
            $urlRouterProvider.otherwise('/access/404');
            $stateProvider
                .state('mgmt', {
                    abstract: true,
                    url: '/mgmt',
                    templateUrl: layout,
                    resolve: load( ['js/controllers/nav.js'] )
                })
                .state('mgmt.dashboard', {
                    url: '/dashboard',
                    templateUrl: 'views/app_dashboard.html'
                })
                .state('access', {
                    url: '/access',
                    template: '<div ui-view class="fade-in-right-big smooth"></div>'
                })
                .state('access.signin', {
                    url: '/signin',
                    templateUrl: 'views/page_signin.html',
                    resolve: load( ['js/controllers/signin.js'] )
                })
                .state('access.forgotpwd', {
                    url: '/forgotpwd',
                    templateUrl: 'views/page_forgotpwd.html'
                })
                .state('access.404', {
                    url: '/404',
                    templateUrl: 'views/page_404.html'
                });

            function load(srcs, callback) {
                srcs = context_path + '/assets/self/' + srcs;
                return {
                    deps: ['$ocLazyLoad', '$q',
                        function ($ocLazyLoad, $q) {
                            var deferred = $q.defer();
                            var promise = false;
                            srcs = angular.isArray(srcs) ? srcs : srcs.split(/\s+/);
                            if (!promise) {
                                promise = deferred.promise;
                            }
                            angular.forEach(srcs, function (src) {
                                promise = promise.then(function () {
                                    if (JQ_CONFIG[src]) {
                                        return $ocLazyLoad.load(JQ_CONFIG[src]);
                                    }
                                    var name;
                                    angular.forEach(MODULE_CONFIG, function (module) {
                                        if (module.name == src) {
                                            name = module.name;
                                        } else {
                                            name = src;
                                        }
                                    });
                                    return $ocLazyLoad.load(name);
                                });
                            });
                            deferred.resolve();
                            return callback ? promise.then(function () {
                                return callback();
                            }) : promise;
                        }]
                }
            }


        }
    ]
);
