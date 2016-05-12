(function(){
	function PessoaController($rootScope,$injector, $scope, $http, $uibModal){
		var vm = this,
			actionService = $injector.get('ActionService');
			$rootScope.tab = 'pessoa';
		
		function init(){
			var pessoas = actionService.getData($rootScope.tab)
				.then(function(response){
					vm.pessoas = response.data;
				});
		} 

		function edit(ind){

			var modalInstance = $uibModal.open({
				animation: true,
				templateUrl: './components/modal/modal-edit-pessoa.html',
				controller: 'ModalController as editPessoa',
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
			var pessoa = vm.pessoa;
			actionService.saveData($rootScope.tab, pessoa)
				.then(function(response){
					vm.pessoas.push(response);
					vm.pessoa = "";
				});
		}

		function remove(ind){
			var id = ind.idPessoa;
			var del = actionService.deleteData($rootScope.tab, id)
				.then(function(){
					init();
				});
		}

		vm.edit = edit;
		vm.create = create;
		vm.remove = remove;

		init();

	}

	angular.module('cupcakeApp')
		.controller('PessoaController', PessoaController);

})();