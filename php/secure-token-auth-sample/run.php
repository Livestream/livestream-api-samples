<?php

$api_key = '[YOUR_API_KEY]';
$client_id = [YOUR_CLIENT_ID];
$scope = '[SCOPE]';
$separator = ':';
$timestamp = time();

$token=hash_hmac("md5", $api_key . $scope . $timestamp , $api_key);

$method = $_SERVER['REQUEST_METHOD'];
$path = $_SERVER['REQUEST_URI'];

if (strcasecmp("GET", $method) == 0 && strcmp("/token", $path) == 0) {
    $response = ['secure_token' => $token, 'timestamp' => $timestamp, 'client_id' => intval($client_id)];
    header('Content-Type: application/json');
    echo json_encode($response);
} else {
    http_response_code(404);
}

