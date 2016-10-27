angular.module('sampleApp', [])
    .directive('accounts', ['LsService', 'TokenService', function(lsService, tokenService){

        var CLIENT_ID = 148;

        return {
            restrict: 'E', 
            templateUrl: 'accounts.html',
            controller: function($scope) {
                $scope.accounts = {}

                //Call to your server
                tokenService.getToken({
                    success: function(data, status, headers, config) {
                        console.log(status)

                        //Call to livestream api server
                        lsService.getAccounts(data.token, CLIENT_ID, data.timestamp, {
                            success: function(data, status, headers, config) {
                                console.log(status)

                                $scope.accounts = data;

                            },
                            error: function(data, status, headers, config) {
                                console.log(status)
                            }
                        })

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
