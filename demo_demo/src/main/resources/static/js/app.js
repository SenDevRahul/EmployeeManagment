var app = angular.module("myApp", ["ngRoute"]);

app.config(function($routeProvider, $locationProvider) {
  $locationProvider.hashPrefix("!");

  $routeProvider
    .when("/", {
      templateUrl: "ui/index.html",
	  controller:"loginCtrl"
    })
	.when("/dashboard", {
	     templateUrl: "ui/dashboard.html",
	  controller:"dashboardCtrl"
	   })
    .when("/create", {
      templateUrl: "ui/create.html",
	  controller:"createCtrl"
    })
    .when("/update/:id", {
      templateUrl: "ui/update.html",
	  controller:"updateCtrl"
    })
    .when("/list", {
      templateUrl: "ui/empList.html",
	  controller:"listCtrl"
    })
    .otherwise({ redirectTo: "/" });
});

app.controller("NavCtrl", function($scope,$location) {
    $scope.username = sessionStorage.getItem("username");
	console.log($scope.username);
	if (!$scope.username) {
	    window.location.href = "#!";
	}else{
		window.location.href = '#!/dashboard/';
	}
	
});

app.controller("dashboardCtrl", function($scope,SessionService) {
  $scope.message = "hii..welcome to my Dashboard";
  var uname=SessionService.get("username");
  $scope.message="Hi "+uname;
});


app.controller("createCtrl", function($scope,$http) {
	
  $scope.emp = {};
  $scope.createEmployee=function(){
	console.log($scope.emp);
	$http.post("/app/employee/saveEmployee", $scope.emp)
	       .then(function(response) {
			console.log(response.data);
	         alert("Data submitted successfully!");
	       }, function(error) {
			console.error(error);
	         alert("Error submitting data.");
	       });
	
  }
});


app.controller("updateCtrl", function($scope,$http,$routeParams,$location) {
  $scope.message = "Update Employee Details";
  var empId = $routeParams.id; // Get ID from URL
  $scope.emp={};
  console.log('empId : '+empId);
  $http.get("/app/employee/getEmployee/" + empId).then(function(response) {
	console.log(response.data);
     $scope.emp = response.data; // Bind data to form
   }, function(error) {
     console.error("Failed to load employee:", error);
   });
   
   $scope.finalEmployee=function(){
	$http.post("/app/employee/updateEmployee", $scope.emp)
		       .then(function(response) {
				console.log(response.data);
		         alert("Data updated successfully!");
				 window.location.href = "#!/list/";
		       }, function(error) {
				console.error(error);
		         alert("Error update data.");
		       });
   }
});


app.controller("listCtrl", function($scope,$http,$location) {
	$scope.employees=[];
	getdata();
  
			   $scope.deleteEmployee=function(id){
				   console.log('id = '+id); 
				   $http.get("/app/employee/deleteEmployee/"+id)
				   		       .then(function(response) {
				   				console.log(response.data);
				   				 if(response.data==true){
									getdata();
									alert('employee '+id+' deleted sucessfully !');
								 }
				   		       }, function(error) {
				   				console.error(error);
				   		         //alert("Error submitting data.");
				   		       });
				   
			   }
			   
			   function getdata(){
				$http.get("/app/employee/getEmployee")
						       .then(function(response) {
								//console.log(response.data);
								$scope.employees=response.data;
						       }, function(error) {
								console.error(error);
						         //alert("Error submitting data.");
						       });
			   }
			   
			   $scope.updateData=function(id){
				console.log('id = '+id); 
				window.location.href = "#!/update/" + id;
			   }
  
});

app.controller('loginCtrl', function($scope, $http,SessionService) {
    $scope.user = {};
    
    $scope.login = function() {
    	if(!$scope.user.userId){
    		alert('Enter User Id !');
    	}else if(!$scope.user.password){
    		alert('Enter Password !');
    	}else{
    		console.log($scope.user);
       	 $http.post('/app/user/login', $scope.user)
            .then(function(response) {
                console.log('Success:', response.data);
                
                if(response.status==200){
					SessionService.set("username", $scope.user.userId);
               	 window.location.href = '#!/dashboard/'; // or change hash: $location.path('/main')
                }else{
               	   alert('Userid or password mismatch !');
                }
            }, function(error) {
                //console.error('Error:', error);
           	 alert('Userid or password mismatch !');
            });
    	}
    	   
    };
});

app.service("SessionService", function() {
    this.set = function(key, value) {
        sessionStorage.setItem(key, angular.toJson(value)); // store object as JSON string
    };

    this.get = function(key) {
        var value = sessionStorage.getItem(key);
        return value ? angular.fromJson(value) : null; // convert JSON string back to object
    };

    this.remove = function(key) {
        sessionStorage.removeItem(key);
    };

    this.clear = function() {
        sessionStorage.clear();
    };
});
