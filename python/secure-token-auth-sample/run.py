from flask import Flask, session, render_template, request, jsonify
from flask_cors import cross_origin
app = Flask(__name__)

import requests
import hmac
import time

api_key='[YOUR_API_KEY]'
client_id='[YOUR_CLIENT_ID]'
scope='readonly'
separator=':'

@app.route("/get_token")
@cross_origin()
def index():
    timestamp = str(int(time.time() * 1000))
    secure_token=hmac.new(api_key, api_key+separator+scope+separator+timestamp).hexdigest()
    return jsonify(secure_token=secure_token,timestamp=timestamp,client_id=client_id)