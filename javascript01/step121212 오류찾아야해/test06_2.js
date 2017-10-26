/* POST 요청과 POST 요청의 데이터 다루기
=> POST 요청 데이터는  URL에서 값을 꺼내면 된다.
   'URL' 모듈의 분석기를 사용하여 값을 꺼낼수 없다
=> POST 요청으로 대량의 데이터를 보낼 수 있기 때문에
   서버 쪽에서도 대량의 데이터를 받을 수 있는 방식으로 처리한다.
=> 테스트 하는 방법
1) test06_2.js 를 실행하여 웹서버를 가동시킨다.
2) 웹 브라우저에서 test06_2.html 파일을 로딩한다.
3) 입력폼에 값을 입력한 후 전송 버튼을 클릭한다.
4) test06_2.js의 응답 결과를 확인한다
*/

const http = require('http')
const url = require('url')
/* Query String 분석기 준비
=> name=value&name2=value&...형태의 문자열을 분석하여 값을 꺼내기 쉽도록
   개체로 만들어준다
   */
const qs = require('querystring')
const server = http.createServer(function(request, response) {
  var urlInfo = url.parse(request.url, true)
  if(urlInfo.pathname != '/post.do') {
    response.end()
    return
  }


  //1) POST 요청으로 들어온 데이터를 저장할 변수 준비
  var buf = ''

  //2) POST 요청 데이터를 읽을 때 마다 'data' 이벤트가 발생하는데,
  //   이 이벤트를 처리해야한다
  //   데이터를 읽을때 마다, 그 읽은 데이터를 data 변수에 저장 시킨다.
  // => 'data' 이벤트는 클라이언트가 보낸 대량의 데이터 중에서 일부 데이터를 읽을 때 마다
  //    발생 된다. 이렇게 하는 이유는 개발자에게 처리 기회를 주기 위함이다.
  request.on('data', (data) => {
    buf += data
    console.log(buf)
  })


  //3) POST 요청 데이터 읽기를 마쳤으면 'end' 이벤트가 발생한다.
  // 따라서 'end' 이벤트가 발생했을 때 클라이언트 요청을 처리하면 된다.
  // request.on('data', (data) => {
  //   response.writeHead(200, {
  //     'Content-Type' : 'text/plain;charset=UTF-8'
  //   })
  //   response.write(buf)
  //   response.end()
  // })

//4) 쿼리 스트릭ㅇ 분석기를 이용하여 문자열을 객체로 바꾼다


  request.on('end', () => {

    response.writeHead(200, {
      'Content-Type' : 'text/plain;charset=UTF-8'
    })
    var params = qs.parse(buf)
    response.write('name=' + params.name + '\n')
    response.write('age=' + params.age + '\n')
    response.write('tel=' + params.tel + '\n')
    response.end();
  })
})
server.listen(8888)

console.log("서버 실행 중...")
