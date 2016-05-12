(function(){
	function SaborController($rootScope, $injector, $scope, $http, $uibModal){
		var vm = this,
			actionService = $injector.get('ActionService');
			$rootScope.tab = 'sabor';
		
		function init(){
			var sabores = actionService.getData($rootScope.tab)
				.then(function(response){
					vm.sabores = response.data;
				});
		} 

		function edit(ind){

			var modalInstance = $uibModal.open({
				animation: true,
				templateUrl: './components/modal/modal-edit-sabor.html',
				controller: 'ModalController as editSabor',
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
			var sabor = vm.sabor;
			actionService.saveData($rootScope.tab, sabor)
				.then(function(response){
					vm.sabores.push(response);
					vm.sabor = "";
				});
		}

		function remove(ind){
			var id = ind.idSabor;
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
		.controller('SaborController', SaborController);

})();