/*
*/

const http = require('http')
const url = require('url')
const qs = require('querystring')

// 이 객체에는 서비스를 처리할 함수를 저장할 것이다.
// 서비스 url : 서비스를 처리하는 함수
var handlerMapping = {}

handlerMapping['/get.do'] = (request, response) => {
  response.write('GET 요청 처리!\n')
  response.write('name=' + request.query.name+ '\n')
  response.write('age=' + request.query.age+ '\n')
  response.write('tel=' + request.query.tel+ '\n')
  response.end()
}

handlerMapping['/post.do'] = (request, response) => {
  var buf = ''
  request.on('data', (data) => {
    buf += data
  })
  request.on('end', () => {
    var params = qs.parse(buf)
    response.write('POST 요청 처리!\n')
    response.write('name=' + params.name + '\n')
    response.write('age=' + params.age + '\n')
    response.write('tel=' + params.tel + '\n')
    response.end();
  })
}

handlerMapping['/hello.do'] = (request, response) => {
  response.write('안녕하세요!')
  response.end()
}

function notFound(request, response) {
  response.write('해당 url 지원안됨')
  response.end()
}
const server = http.createServer(function(request, response) {
  var urlInfo = url.parse(request.url, true)
  console.log(urlInfo)

  if (request.url == '/favicon.ico') {
    response.end()
    return
  }
  if (request.method == "GET") {
    request.query = urlInfo.query
  }
  response.writeHead(200, {
    'Content-Type' : 'text/plain;charset=UTF-8'
  })
  var fn = handlerMapping[urlInfo.pathname]
  if(fn != undefined) {
    fn(request, response)
  } else {
    notFound(request, response)
  }
})
server.listen(8888)

console.log("서버 실행 중...")
