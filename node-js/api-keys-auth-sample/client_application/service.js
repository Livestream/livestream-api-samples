angular.module('sampleApp')
    .service('DataService', ['$http', function($http) {
        this.getAccounts = function(options) {
            var config = {
                method : 'GET',
                url : '/accounts'
            };

            $http(config).success(options.success).error(options.error);
        }
    }])