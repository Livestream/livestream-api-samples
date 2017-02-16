### Example of Ruby Application making Livestream Rest API calls

![Flow](flow.png)

### Prerequisite

You need to have ruby2.0.0p648 on your system and PATH variable must be set accordingly.

### Run your server

1. cd `ruby/secure-token-auth-sample`
2. Edit `[YOUR_API_KEY]` with your secret key in `run.rb`
3. Edit `[YOUR_CLIENT_ID]` with your client id in `run.rb`
4. Edit `SCOPE` with your desired scope ('readonly','playback',or 'all') in `run.rb`
5. Start server `ruby run.rb`
6. Open `http://localhost:8080/token` and you should see a JSON response of your token, timestamp, and client id to be made in a client request. 

For more information please visit the documentation - https://livestream.com/developers/docs/api