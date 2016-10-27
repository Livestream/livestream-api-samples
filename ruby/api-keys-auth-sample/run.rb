# Ruby Version: ruby 2.0.0p648

#!/usr/bin/env ruby

require "webrick"
require "net/http"
require "base64"

class MyServlet < WEBrick::HTTPServlet::AbstractServlet
    def do_GET (request, response)
        apiKey = "[YOUR_API_KEY]"
        uri = URI('https://livestreamapis.com/v1/accounts')
        req = Net::HTTP::Get.new(uri)
        req.basic_auth("#{apiKey}", "")
        http = Net::HTTP.new(uri.host, uri.port)
        http.use_ssl = true
        res = http.request(req)
        response['Content-Type'] = 'application/json'
        response.body = res.body
        response.status = res.code
    end
end

server = WEBrick::HTTPServer.new(:Port => 8080)

server.mount "/", MyServlet

trap("INT") {
    server.shutdown
}

server.start