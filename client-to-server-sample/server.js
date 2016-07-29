var express = require('express');
var crypto = require('crypto');
var moment = require('moment')
var request = require('request')

const PORT=8080;
const API_SECRET = "[YOUR_SECRET_API_KEY]";

var app = express();

// Add headers for CORS
app.use(function (req, res, next) {
    res.setHeader('Access-Control-Allow-Origin', '*');
    res.setHeader('Access-Control-Allow-Methods', 'GET');
    res.setHeader('Access-Control-Allow-Headers', 'X-Requested-With,content-type');
    res.setHeader('Access-Control-Allow-Credentials', true);
    next();
});

app.use(express.static('client_application'));

function generateToken(clientIp, timestamp) {
    var hmac = crypto.createHmac("md5", API_SECRET);
    
    var tokenString = API_SECRET + ":" + clientIp + ":" + timestamp
    hmac.update(tokenString);
    var crypted = hmac.digest("hex");

    return crypted;
};

app.get("/token", function(req, res) {
    var currentTime = moment().format('x');

    var clientIp = req.connection.remoteAddress;
    //if behind proxy
    //var clientIp = request.headers['x-forwarded-for']

    if (clientIp === '::1' || clientIp === '127.0.0.1') {
        request.get({url: 'http://ipinfo.io', 'json': true }, function(err, response, data) {

            if (err) {
                console.log(err)
                return res.send('error getting your external ip, try not to run local.') 
            }

            clientIp = data.ip

            var token = generateToken(clientIp, currentTime);

            console.log('clientIp: ' + clientIp);
            console.log('token:' + token)
            console.log('timestamp: ' + currentTime)

            res.setHeader('Content-Type', 'application/json');
            res.send({'timestamp': currentTime, 'token': token});
        });
    }
});    

app.listen(PORT, function () {
  console.log('server listening on port %s!', PORT);
});
