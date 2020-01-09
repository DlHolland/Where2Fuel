/**
 * 
 */

var where2fuel= angular.module('where2fuel', ['ngRoute', 'chart.js']);

where2fuel.config(function($routeProvider) {
	$routeProvider
	.when('/station_tracker', {
		templateUrl: 'station_tracker.html',
	})
	.when('/stacks', {
		templateUrl: 'stacks.html'
	})
	.when('/resume', {
		templateUrl: 'resume.html'
	})
	.when('/link1', {
		templateUrl: 'link1.html'
	})
	.when('/link2', {
		templateUrl: 'link2.html'
	})
	.when('/search', {
		templateUrl: 'search.html'
	})
	.when('/hobbies', {
		templateUrl: 'hobbies.html'
	})
	.when('/subscribe', {
		templateUrl: 'subscribe.html'
	})
	.when('/welcome', {
		templateUrl: 'welcome.html'
	})
	.otherwise({
		templateUrl: 'welcome.html'
	});
});

where2fuel.controller('where2fuelcontroller', function($scope, $http) {
	
	$scope.showsearch = true;
	
	 $scope.getAllStations = function() {
		
		 $http.get("/Where2Fuel/rest/v1/station")
		 .then(function(response) {
			 $scope.stations = response.data;
		 }, function(response) {
			 console.log('Error HTTP GET movies: ' + response.status)
		 });

	 }
	 
	$scope.selectedValue = "All";
	$scope.stationForDetails = null;
	 
	 
	 $scope.getStationsByValue = function(value) {
		 $scope.showsearch = false;
		 console.log('getStationsByValue() called' + $scope.selectedValue) 
		 $http.get("/Where2Fuel/rest/v1/station" + "/" + value)
		 .then(function(response) {
			 $scope.stations = response.data;
			 
            $scope.orderByField = 'station.price';
            $scope.reverseSort = false;
		 }, function(response) {
			 console.log('Error HTTP GET stationsbyvalue: ' + response.status)
			 
		 });
	 }
	 
	 $scope.getStationsByCity = function() {
		 console.log('getStationsByCity() called')
		 $http.get("/Where2Fuel/rest/v1/station/city" + "/" + $scope.selectedValues)
		 .then(function(response) {
			 $scope.stations = response.data;
		 }, function(response) {
			 console.log('Error HTTP GET stationsbycity: ' + response.status)
		 });
	 }
	 
	 $scope.selectStation = function(stationForDetails) {
		 $scope.stationForDetails = angular.copy(stationForDetails);
		 console.log('selectStation() called' + angular.toJson(stationForDetails));
		

	 }
	 
	 $scope.getStationsByAddress = function() {
		 console.log($scope.stationForDetails)
		 $http.get("/Where2Fuel/rest/v1/station/address" + "/" + $scope.stationForDetails.address)
		 .then(function(response) {
			 $scope.station = response.data;
			 console.log($scope.station)
			 $scope.chartlabels = [$scope.station[0].updateDate, $scope.station[1].updateDate, $scope.station[2].updateDate, $scope.station[3].updateDate, $scope.station[4].updateDate, $scope.station[5].updateDate, $scope.station[6].updateDate];
				$scope.chartdata = [
					[$scope.station[0].price, $scope.station[1].price, $scope.station[2].price, $scope.station[3].price, $scope.station[4].price, $scope.station[5].price, $scope.station[6].price]
				]
				
		 }, function(response) {
			 console.log('Error get stationsbyaddress: ' + response.status)
		 });
		
		
	 }
	 
		
	$scope.values = ["Fayetteville",
					 "Conway", 
					 "Little Rock",
					 "All"
					];
	
	
	
	$scope.subscribeByEmail = function(emailAddress) {
		$scope.emailAddress = angular.copy(emailAddress);
		console.log('subByEmail() called' + $scope.emailAddress)
		$http.get("/Where2Fuel/rest/v1/station/subscribe" + "/" + emailAddress + "/" + $scope.stationForDetails.address)
		 .then(function(response) {
			 console.log('success')
		 }, function(response) {
			 console.log('Error HTTP subscribeByEmail: ' + response.status)
		 });
	}
	 
})

	
	
	 





