(function(){
	function HomeController($scope){
		$scope.message = 'App home';
	}

	angular.module('cupcakeApp')
		.controller('HomeController', HomeController);
})();