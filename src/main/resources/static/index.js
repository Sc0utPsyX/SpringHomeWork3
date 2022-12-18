angular.module ('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8190/app';

    $scope.loadProducts = function () {
        $http.get(contextPath + '/all')
            .then(function (response) {
                $scope.productsList = response.data;
            });
    };
    $scope.deleteProductById = function (productId){
        $http({
        url: contextPath + '/delete?productId=' + productId,
        method: "DELETE"
        }).then(function (response){
            $scope.loadProducts();
        });
    };

    $scope.createProduct = function (productTitle, productCost){
        $http({
            url: contextPath + '/add?productTitle=' + productTitle + '&productCost=' + productCost,
            method: "POST"
        }).then(function (response){
            $scope.loadProducts();
        });
    };

    $scope.loadProducts();
});