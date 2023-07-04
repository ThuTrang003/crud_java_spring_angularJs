window.hienThiNhanVienCtrl = function ($scope, $http, $location, $routeParams) {
  let api = "http://localhost:8080/nhan-vien";
  $scope.listNhanVien = [];
  $scope.currentPage = 1;
  $scope.pageSize = 5;
  

  
  $scope.pageChanged = function() {
    $http.get(api + "/hien-thi?page=" + $scope.currentPage 
    ).then(function (response) {
      $scope.listNhanVien = response.data.content;
      $scope.totalItems = response.data.totalElements;
    });

  };

  $scope.pageChanged();


  $scope.delete = function (event, id) {
    $http.delete(api + "/delete/" + id).then(function (response) {
      $location.path("/hien-thi");
      alert("Xóa thành công");
    });
  };
};
