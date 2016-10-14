angular.module('sampleApp')
    .service('LsService', ['$http', function($http) {
        this.getAccounts = function(token, clientId, timestamp, options) {
            var events = {}

            var config = {
                method : 'GET',
                url : 'https://livestreamapis.com/v1/accounts',
                params : {
                    'token': token,
                    'timestamp': timestamp,
                    'client_id': clientId
                }
            };

            $http(config).success(options.success).error(options.error);
        }
        
    }])
    .service('TokenService', ['$http', function($http) {
        this.getToken = function(options) {
            var config = {
                method : 'GET',
                url : '/token'
            };

            $http(config).success(options.success).error(options.error);
        }
    }])