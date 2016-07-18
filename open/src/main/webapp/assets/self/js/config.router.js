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
                        $state.go('access.signin', {from: fromState.name});
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
                .state('app', {
                    abstract: true,
                    url: '/app',
                    templateUrl: layout,
                    resolve: load( ['js/controllers/nav.js', 'js/controllers/menu.js'] )
                })
                .state('app.dashboard', {
                    url: '/dashboard',
                    templateUrl: 'views/app_dashboard.html'
                })
                .state('access', {
                    url: '/access',
                    template: '<div ui-view class="fade-in-right-big smooth"></div>'
                })
                .state('access.signin', {
                    params:{'from': null},
                    url: '/signin',
                    templateUrl: 'views/page_signin.html',
                    resolve: load( ['js/controllers/signin.js'] )
                })
                .state('access.signup', {
                    url: '/signup',
                    templateUrl: 'views/page_signup.html',
                    resolve: load( ['js/controllers/signup.js'] )
                })
                .state('access.forgotpwd', {
                    url: '/forgotpwd',
                    templateUrl: 'views/page_forgotpwd.html'
                })
                .state('access.404', {
                    url: '/404',
                    templateUrl: 'views/page_404.html'
                })
                // pages
                .state('app.weixin', {
                    url: '/weixin',
                    template: '<div ui-view class="fade-in-down"></div>'
                })
                .state('app.weixin.list', {
                    url: '/list',
                    templateUrl: 'views/page_weixin_list.html',
                    resolve: load( ['js/controllers/weixin/list.js'] )
                })
                .state('app.weixin.add', {
                    url: '/add',
                    templateUrl: 'views/page_weixin_add.html',
                    resolve: load( ['ui.select', 'js/controllers/weixin/setup.js'] )
                })
                .state('app.weixin.edit', {
                    url: '/edit?id',
                    templateUrl: 'views/page_weixin_edit.html',
                    resolve: load( ['js/controllers/weixin/setup.js'] )
                })
                .state('app.weixin.detail', {
                    url: '/detail?id',
                    templateUrl: 'views/page_weixin_detail.html',
                    resolve: load( ['js/controllers/weixin/detail.js'] )
                });

            function load(srcs, callback) {
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
                                    var name = context_path + '/assets/self/' + src;
                                    var keepGoing = true;
                                    angular.forEach(MODULE_CONFIG, function (module) {
                                        if (keepGoing) {
                                            if (module.name == src) {
                                                name = module.name;
                                                keepGoing = false;
                                            }
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
