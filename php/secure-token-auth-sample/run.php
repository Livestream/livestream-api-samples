<?php

$api_key = '[YOUR_API_KEY]';
$client_id = '[YOUR_CLIENT_ID]';
$scope = '[SCOPE]';
$separator = ':';
$timestamp = time();

$token=hash_hmac("md5", $api_key . $scope . $timestamp , $api_key);

$response = ['secure_token' => $token, 'timestamp' => $timestamp, 'client_id' => $client_id];

echo json_encode($response);
