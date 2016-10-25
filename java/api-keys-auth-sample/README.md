### Prerequisite

You need to have java 1.7 and maven 3.3.9 installed on your system and PATH varibale must be set accordingly.

### Run your server

1. cd `java/api-keys-auth-sample`
2. Edit `[YOUR_API_KEY]` with your secret key in `src/main/java/com/livestream/api/samples/apikeys/Constants.java`
3. Start the server from the project folder by executing `mvn compile exec:java -Dexec.mainClass="com.livestream.api.samples.apikeys.server.Server"`. By default server starts @ localhost:9998. In case you need to update server address, you can modify `HOST` and `PORT` variables in `src/main/java/com/livestream/api/samples/apikeys/Constants.java`

### Run your client

1. Open another tab.
2. cd `java/api-keys-auth-sample`
3. Launch client application by executing `mvn exec:java -Dexec.mainClass="com.livestream.api.samples.apikeys.client.ClientApplication"`. Client application executes [Get Accounts](https://livestream.com/developers/docs/api#get-accounts) API and prints the json response on the terminal.

For more information please visit the documentation - https://livestream.com/developers/docs/api
