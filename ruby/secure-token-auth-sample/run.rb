# Ruby Version: ruby 2.0.0p648

#!/usr/bin/env ruby

require "webrick"
require "openssl"
require "json"

class MyServlet < WEBrick::HTTPServlet::AbstractServlet
    def do_GET (request, response)
        apiKey = "[YOUR_API_KEY]"
        clientId = [YOUR_CLIENT_ID]
        scope = "[SCOPE]"
        separator = ":"
        timestamp = (Time.now.to_f.round(3)*1000).to_i
        data = "#{apiKey}#{separator}#{scope}#{separator}#{timestamp}"
        token = OpenSSL::HMAC.hexdigest(OpenSSL::Digest.new('MD5'), apiKey, data)
        response['Content-Type'] = 'application/json'
        response.body = JSON.generate({:token => "#{token}", :timestamp => timestamp, :client_id => clientId})
        response['Content-Type'] = 'application/json'
    end
end

server = WEBrick::HTTPServer.new(:Port => 8080)

server.mount "/token", MyServlet

trap("INT") {
    server.shutdown
}

server.start