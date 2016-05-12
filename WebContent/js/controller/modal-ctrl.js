(function(){
	function ModalController($injector, $scope, $uibModalInstance, sets){
		var vm = this,
			actionService = $injector.get('ActionService');

		function init(){
			vm.info = sets.ind;
		}

		function update() {
			var ind = vm.info;
			var tab = sets.tab;

			actionService.updateData(tab,ind)
				.then(function(response){
					$uibModalInstance.close(response);
				});
		}

		function cancelar() {
			$uibModalInstance.dismiss('cancelar');
		}

		vm.update = update;
		vm.cancelar = cancelar;

		init();
	}

	angular.module('cupcakeApp')
		.controller('ModalController', ModalController);

})();