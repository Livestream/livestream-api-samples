### Example of PHP Application making Livestream Rest API calls

![Flow](flow.png)

### Prerequisite

You need to have php5 on your system and PATH varibale must be set accordingly.

### Run your server

1. cd `php/secure-token-auth-sample`
2. Edit `[YOUR_API_KEY]` with your secret key in `run.php`
3. Edit `[YOUR_CLIENT_ID]` with your client id in `run.php`
4. Edit `SCOPE` with your desired scope ('readonly','playback',or 'all') in `run.php`
5. Start server `php -S localhost:8080 run.php`
6. Open `http://localhost:8080/token` and you should see a JSON response of your token, timestamp, and client id to be made in a client request. 

For more information please visit the documentation - https://livestream.com/developers/docs/api