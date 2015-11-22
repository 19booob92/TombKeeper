var scheduleModule = angular.module('scheduleModule', []);

scheduleModule
		.controller(
				'ScheduleCtrl',
				function($scope, $http) {

					$scope.user = {};
					$scope.user.graves = [];
					$scope.saveHtml = function() {
						$http({
							method : 'POST',
							url : 'http://localhost:8080/human',
							data : $scope.user
						})
								.success(
										function(data, status, headers, config) {
											alert("poszło");
										})
								.error(
										function(data, status, headers, config) {
											alert("Użytkownik o podanym loginie już istnieje w systemie, wprowadź inny login !");
										});
					};

				});
