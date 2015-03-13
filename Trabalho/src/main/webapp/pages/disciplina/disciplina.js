module = angular.module("Prova", []);

module.controller("DisciplinaController", ["$scope","$http", DisciplinaController]);


function DisciplinaController($scope,$http) {
    
    $scope.iniciar = funcaoIniciar;
    $scope.salvar = funcaoSalvar;
    $scope.excluir = funcaoExcluir;
    $scope.editar = funcaoEditar;
    
    $scope.disciplinas = [];
    $scope.disciplina = {};
    $scope.isNovo = true;
    
    function funcaoEditar(disciplina) {
        $scope.disciplina = angular.copy(disciplina);
        $scope.isNovo = false;
    }

    
    function funcaoExcluir(disciplina) {
        http.delete("/disciplinas",disciplina).success(onSuccess).error(onError);;
    }
    
    function funcaoSalvar() {
        http.post("/disciplinas",disciplina).success(onSuccess).error(onError);
    }
    
    function funcaoCarregar() {
        $http.get("/disciplinas").success(onSuccess).error(onError);
        
        function onSuccess(data, status) {
            $scope.disciplinas = data;       
            console.log(data);
        }
        function onError(data, status) {
            alert("Deu erro: " + data);
        }
    }
    
    function funcaoIniciar() {
        funcaoCarregar();
        console.log(">>> disciplinas carregadas....");
    }
        
}


