var express = require('express');
var crypto = require('crypto');
var moment = require('moment');

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

function generateToken(scope, timestamp) {
    var hmac = crypto.createHmac("md5", API_SECRET);
    
    var tokenString = API_SECRET + ":" + scope + ":" + timestamp
    hmac.update(tokenString);
    var crypted = hmac.digest("hex");

    return crypted;
};

app.get("/token", function(req, res) {
    var currentTime = moment().format('x');

    var SCOPE = 'readonly';
    
    var token = generateToken(SCOPE, currentTime);

    console.log('scope:' + SCOPE);
    console.log('token:' + token);
    console.log('timestamp: ' + currentTime);

    res.setHeader('Content-Type', 'application/json');
    res.send({'timestamp': currentTime, 'token': token});
});    

app.listen(PORT, function () {
  console.log('server listening on port %s!', PORT);
});
