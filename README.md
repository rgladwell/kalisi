# Kalisi [![Build Status](https://travis-ci.org/rgladwell/kalisi.svg?branch=master)](https://travis-ci.org/rgladwell/kalisi)

Functional HTTP library for Kotlin.

```kt
val server = Jetty(8080).mount { Response(Ok) }
server.start()
```

Then when you execute the following you should get an HTTP OK status code:

```shell script
$ curl -v http://127.0.0.1:8080
* Rebuilt URL to: http://127.0.0.1:8080/
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8080 (#0)
> GET / HTTP/1.1
> Host: 127.0.0.1:8080
> User-Agent: curl/7.54.0
> Accept: */*
> 
< HTTP/1.1 200 OK
< Date: Fri, 26 Jul 2019 09:23:28 GMT
< Content-Length: 0
< Server: Jetty(9.4.19.v20190610)
< 
* Connection #0 to host 127.0.0.1 left intact
```

## Development

Requires:

 * [Maven](https://maven.apache.org/install.html)

To run the tests execute:

```shell script
$ mvn test
```
