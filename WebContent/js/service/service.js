(function(){
	function ActionService($http){
		var url = 'http://localhost:8080/CupcakeStore/rs/';

		this.getData = function(tab){
			return $http.get(url + tab);
		}

		this.saveData = function(tab, ind){
			return $http({
				method: 'POST',
				url: url + tab,
				data: ind
			});
		}

		this.updateData = function(tab, ind){
			return $http({
				method: 'PUT',
				url: url + tab,
				data: ind
			});
		}

		this.deleteData = function(tab, id){
			return $http.delete(url + tab + "/" + id);
		}
	}

	angular.module('cupcakeApp')
		.service('ActionService', ActionService);

})();