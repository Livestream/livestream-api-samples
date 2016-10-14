### Prerequisite
- Install dependencies 
  - cd `secure-token-auth-sample`
  - `sudo pip install -r requirements.txt`

### Run your server

1. edit `[YOUR_API_KEY]` with your secret key in `run.py`
2. in command line run export FLASK_APP=run.py
3. start server `flask run`
4. Open `http://localhost:5000/` and you should see a simple page with your account ID and full name from the API. 

For more information please visit the documentation - https://livestream.com/developers/docs/api
