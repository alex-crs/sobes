(function () {
    angular
        .module('app', ['ngRoute', 'ngStorage']);
})();

angular.module('app').controller('indexController', function ($scope, $http, $location, $localStorage) {
    $scope.loadStudentList = function () {
        $http.get('http://localhost:5555/api/all').then(function (response) {
            $scope.Students = response.data;
        });
    };
    $scope.loadStudentList();

    $scope.addStudent = function () {
        $http.post('http://localhost:5555/api/add', $scope.Student).then(function (response) {
            if (response.status === 201) {
                alert('Студент успешно добавлен в базу')
                $scope.loadStudentList();
                document.forms.namedItem('add').reset();
            }
        });
    };

    $scope.deleteStudent = function (id) {
        $http.delete('http://localhost:5555/api/delete/' + id).then(function (response) {
            if (response.status === 200) {
                alert('Студент успешно удален')
                $scope.loadStudentList();
            }
        });
    };

    $scope.getStudentById = function (id) {
        $http.get('http://localhost:5555/api/get/' + id).then(function (response) {
            if (response.status === 200) {
                $scope.StudentDTO = response.data;
                $scope.currentid = response.data.id;
                document.forms.namedItem('update').reset();
            }
        });
    };


    $scope.updateStudent = function (id) {
        $http.post('http://localhost:5555/api/update/'+$scope.currentid, $scope.Student).then(function (response) {
            if (response.status === 200) {
                alert('Студент успешно обновлен')
                $scope.loadStudentList();
                $scope.returnAdd();
                document.forms.namedItem('add').reset();
            }
        });
    };

    $scope.showUpdate = function (id) {
        if (!$scope.showUpdateField) {
            $scope.showUpdateField = true;
            $scope.showAddField = false;
        }
        $scope.getStudentById(id);
    };

    $scope.returnAdd = function () {
        $scope.showUpdateField = false;
        $scope.showAddField = true;
    };

    $scope.showAddField = true;
    $scope.showUpdateField = false;

});

