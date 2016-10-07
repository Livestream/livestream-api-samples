from flask import Flask, session, render_template, request
import urllib2, base64,json
app = Flask(__name__)

api_key='[YOUR API KEY]'

@app.route("/")
def account():
    request = urllib2.Request("https://livestreamapis.com/v1/accounts")
    base64string=base64.encodestring(api_key+':').replace('\n','')
    request.add_header("Authorization","Basic "+base64string)
    u=urllib2.urlopen(request)
    response=json.loads(u.read())
    fullName=response[0]['fullName']
    accountId=response[0]['id']
    return render_template('accounts.html',fullName=fullName, accountId=accountId)

