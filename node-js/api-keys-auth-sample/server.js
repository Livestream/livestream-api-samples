var express = require('express');
var request = require('request');

const PORT=8080;
const API_SECRET = "rYYkIgdqWJMVuts3n4PlmikSjoxAEHPO";

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



app.get("/accounts", function(req, res) {

    var options = {
        url: 'https://livestreamapis.com/v1/accounts',
        auth: {
            username: API_SECRET
        }
    }

    request.get(options, function(err, response, body) {
        if (err) {
            console.error('livestream api call failed ', err)
            return res.send(err)
        }   

        console.log('data received ' + body);
        res.setHeader('Content-Type', 'application/json');
        res.send(body)
    })

});    

app.listen(PORT, function () {
  console.log('server listening on port %s!', PORT);
});
