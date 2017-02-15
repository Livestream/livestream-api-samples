### Example of Java Application making Livestream Rest API calls

![Flow](flow.png)

### Prerequisite

You need to have java 1.7 and maven 3.3.9 installed on your system and PATH variable must be set accordingly.

### Run your server

1. cd `java/secure-token-auth-sample`
2. Edit `[API_SECRET]` with your secret key in `src/main/java/com/livestream/api/samples/securetoken/Constants.java`
3. Edit `[CLIENT_ID]` with your client in `src/main/java/com/livestream/api/samples/securetoken/Constants.java`
4. Edit `SCOPE` with your desired scope ('readonly','playback',or 'all') in `src/main/java/com/livestream/api/samples/securetoken/Constants.java`.
5. Start the server from the project folder by executing `mvn compile exec:java -Dexec.mainClass="com.livestream.api.samples.securetoken.server.Server"`. By default server starts @ localhost:9998. In case you need to update server address, you can modify `HOST` and `PORT` variables in `src/main/java/com/livestream/api/samples/securetoken/Constants.java`

### Run your client

1. Open another tab.
2. cd `java/secure-token-auth-sample`
3. Launch client application by executing `mvn exec:java -Dexec.mainClass="com.livestream.api.samples.securetoken.client.ClientApplication"`. Client application executes [Get Accounts](https://livestream.com/developers/docs/api#get-accounts) API and prints the json response on the terminal.

For more information please visit the documentation - https://livestream.com/developers/docs/api