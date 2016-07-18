app.controller('WeixinListController', ['$scope', '$http', '$modal', function ($scope, $http, $modal) {
    var list = function() {
        $http.get(api("/weixin/list.json"))
            .success(function (data) {
                if (data.length == 0) {
                    $scope.authError = "您还未添加微信公众号。";
                    return;
                }
                $scope.channels = data;
                $scope.delete = function (id, name) {
                    $modal.open({
                        templateUrl: 'deleteWeixin.html',
                        controller: function ($scope, $modalInstance) {
                            $scope.name = name;
                            $scope.confirmDelete = function () {
                                _delete(id);
                                $modalInstance.close();
                            };
                            $scope.cancelDelete = function () {
                                $modalInstance.dismiss('cancel');
                            };
                        }
                    });
                }
            });
    };
    var _delete = function(id) {
        $http.post(api("/weixin/delete.json"), id)
            .success(function (data) {
                if (data.errcode == 0) {
                    list();
                } else {
                    $scope.authError = data.errmsg;
                }
            });
    };
    list();
}]);