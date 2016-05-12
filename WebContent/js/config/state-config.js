(function(){
	function config($stateProvider, $urlRouterProvider){

		$urlRouterProvider.otherwise('/home');

		$stateProvider

			.state('home', {
				url: '/home',
				templateUrl: 'pages/home.html',
				controller: 'HomeController as homeCtrl'
			})
			.state('cadastro', {
				url: '/cadastro',
				abstract: true,
				templateUrl: 'pages/cadastro.html'
			})
			.state('cadastro.pessoa', {
				url: '',
				templateUrl: 'tabs/cad-pessoa.html',
				controller: 'PessoaController as pessoaCtrl'
			})
			.state('cadastro.sabor', {
				url: '/sabor',
				templateUrl: 'tabs/cad-sabor.html',
				controller: 'SaborController as saborCtrl'
			})
			.state('cadastro.pedido', {
				url: '/pedido',
				templateUrl: 'tabs/cad-pedido.html',
				controller: 'PedidoController as pedidoCtrl'
			})
			.state('consulta', {
				url: '/consulta',
				abstract: true,
				templateUrl: 'pages/consulta.html',
			})
			.state('consulta.pessoa', {
				url: '',
				templateUrl: 'tabs/con-pessoa.html',
				controller: 'PessoaController as pessoaCtrl'
			})
			.state('consulta.sabor', {
				url: '/sabor',
				templateUrl: 'tabs/con-sabor.html',
				controller: 'SaborController as saborCtrl'
			})
			.state('consulta.pedido', {
				url: '/pedido',
				templateUrl: 'tabs/con-pedido.html',
				controller: 'PedidoController as pedidoCtrl'
			});

	}

	angular.module('cupcakeApp').config(config);

})();