var cupcakeApp = angular.module('cupcakeApp', ['ui.router', 'ui.bootstrap']);

// Route config

cupcakeApp.config(function($stateProvider, $urlRouterProvider){
	
	$urlRouterProvider.otherwise('/home');

	$stateProvider

		.state('home', {
			url: '/home',
			templateUrl: 'pages/home.html',
			controller: 'homeController'
		})
		.state('cadastro', {
			url: '/cadastro',
			abstract: true,
			templateUrl: 'pages/cadastro.html',
			controller: 'cadastroController'
		})
		.state('cadastro.pessoa', {
			url: '',
			templateUrl: 'tabs/cad-pessoa.html',
			controller: 'cadastroController'
		})
		.state('cadastro.sabor', {
			url: '/sabor',
			templateUrl: 'tabs/cad-sabor.html',
			controller: 'cadastroController'
		})
		.state('cadastro.pedido', {
			url: '/pedido',
			templateUrl: 'tabs/cad-pedido.html',
			controller: 'cadastroController'
		})
		.state('consulta', {
			url: '/consulta',
			abstract: true,
			templateUrl: 'pages/consulta.html',
			controller: 'consultaController'
		})
		.state('consulta.pessoa', {
			url: '',
			templateUrl: 'tabs/con-pessoa.html',
			controller: 'consultaController'
		})
		.state('consulta.sabor', {
			url: '/sabor',
			templateUrl: 'tabs/con-sabor.html',
			controller: 'consultaController'
		})
		.state('consulta.pedido', {
			url: '/pedido',
			templateUrl: 'tabs/con-pedido.html',
			controller: 'consultaController'
		});
});


// App Controller

cupcakeApp.controller('homeController', function($scope){
	$scope.message = 'App home';
});

cupcakeApp.controller('consultaController', function($scope, $http, $uibModal){
	var urlGetPessoa = 'http://localhost:8080/CupcakeStore/rs/pessoa'
	
	function getPessoas(){
		$http.get(urlGetPessoa)
			.then(function(response){
			$scope.pessoas = response.data;
		});	
	} 

	var modalMap = {
		pessoa: './modal/modal-edit-pessoa.html',
		sabor: './modal/modal-edit-sabor.html',
		pedido: './modal/modal-edit-pedido.html'
	}

 	$scope.animationsEnabled = true;

	$scope.edit = function(template, item){

		var modalInstance = $uibModal.open({
			transclude: true,
			animation: $scope.animationsEnabled,
			templateUrl: modalMap[template],
			controller: 'modalEditCtrl',
			resolve: {
				items: function () {
				  return item;
				}
			}
		}).result.then(function (response) {
			console.log("response ok", response);
		});
	}

	getPessoas();
});

cupcakeApp.controller('cadastroController', function($scope){
	$scope.message = 'Pagina cadastro';
	$scope.teste = "tabs cadastro";
});

cupcakeApp.controller('modalEditCtrl', function($scope, items, $uibModalInstance){
	
	$scope.pessoa = items;

	$scope.salvar = function () {
		$uibModalInstance.close();
	};

	$scope.cancel = function () {
		$uibModalInstance.dismiss('cancel');
	};
});

