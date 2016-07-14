app.filter('propsFilter', function() {
    return function(items, props) {
        var out = [];

        if (angular.isArray(items)) {
            items.forEach(function(item) {
                var itemMatches = false;

                var keys = Object.keys(props);
                for (var i = 0; i < keys.length; i++) {
                    var prop = keys[i];
                    var text = props[prop].toLowerCase();
                    if (item[prop].toString().toLowerCase().indexOf(text) !== -1) {
                        itemMatches = true;
                        break;
                    }
                }

                if (itemMatches) {
                    out.push(item);
                }
            });
        } else {
            // Let the output be the input untouched
            out = items;
        }

        return out;
    };
});
app.controller('WeixinSetupController', ['$scope', '$http', '$state', '$location', function ($scope, $http, $state, $location) {
    var setupTypeIsAdd = new RegExp("add"+"$").test($location.url());
    if (setupTypeIsAdd) {
        $scope.setupTypeDisplay = "添加";
    } else {
        $scope.setupTypeDisplay = "修改";
    }
    $scope.back = function() {
        $state.go("app.weixin.list");
    };
    $scope.type = {};
    $scope.types = [
        {name : "服务号", value : "fuwu"},
        {name : "订阅号", value : "dingyue"}
    ];
}]);