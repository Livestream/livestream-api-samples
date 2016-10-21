<?php

function getAccounts() {
    $api_key = '[YOUR_API_KEY]';
    $ch = curl_init();
    curl_setopt($ch, CURLOPT_URL, "https://livestreamapis.com/v1/accounts");
    curl_setopt($ch, CURLOPT_USERPWD, $api_key . ':');
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
    $response = curl_exec($ch);
    return $response;
}

header('Content-Type: application/json');

echo getAccounts();
