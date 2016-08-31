angular.module('sampleApp', [])
    .directive('accounts', ['DataService', function(dataService){

        return {
            restrict: 'E', 
            templateUrl: 'accounts.html',
            controller: function($scope) {
                $scope.accounts = {}

                //Call to your server
                dataService.getAccounts({
                    success: function(data, status, headers, config) {
                        console.log(status)
                        $scope.accounts = data;
                    },
                    
                    error: function (data, status, headers, config) {
                        console.log(status)
                    }
                })

            },
            link: function($scope, iElm, iAttrs, controller) {
                
            }
        };
    }]);