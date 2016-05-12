(function(){
	function PedidoController($filter, $rootScope, $injector, $scope, $http, $uibModal){
		var vm = this,
			actionService = $injector.get('ActionService');
			$rootScope.tab = 'pedido';
		
		function init(){
			
			vm.options = [];
			vm.dropLabel = 'Selecione a Pessoa';

			var pedidos = actionService.getData($rootScope.tab)
				.then(function(response){
					vm.pedidos = response.data;
				});

			var pessoas = actionService.getData('pessoa')
				.then(function(response){
					var listaPessoas = vm.listaPessoas = response.data;
					setDropdown(listaPessoas);
				});
		}

		function selectPessoa(selected){
			vm.dropLabel = selected.id + ' - ' + selected.nome;
			var found = $filter('filter')(vm.listaPessoas, {idPessoa: selected.id}, true);
			vm.selectedPessoa = found[0];
		}
		
		function setDropdown(listaPessoas){
		    for (var i=0; i<listaPessoas.length; i++){
				vm.options[i] = {id: listaPessoas[i].idPessoa, nome: listaPessoas[i].nome};
		    }
		}

		function edit(ind){

			var modalInstance = $uibModal.open({
				animation: true,
				templateUrl: './components/modal/modal-edit-pedido.html',
				controller: 'ModalController as editPedido',
				resolve: {
					sets: function () {
					  return {tab:$rootScope.tab, ind:ind};
					}
				}
			}).result.then(function (response) {
				init();
			});
		}

		function create(){
			var pedido = vm.pedido;
			pedido.pessoa = vm.selectedPessoa;

			actionService.saveData($rootScope.tab, pedido)
				.then(function(response){
					vm.pedidos.push(response);
					vm.pedido = "";
					vm.dropLabel = 'Selecione a Pessoa';
				});
		}

		function remove(ind){
			var id = ind.idPedido;
			var del = actionService.deleteData($rootScope.tab, id)
				.then(function(){
					init();
				});
		}

		vm.edit = edit;
		vm.create = create;
		vm.remove = remove;
		vm.selectPessoa = selectPessoa;

		init();

	}

	angular.module('cupcakeApp')
		.controller('PedidoController', PedidoController);

})();