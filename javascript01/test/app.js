/* Express 프레임워크 적용 - AJAX 웹 프로그래밍 방식
=> 서버에서 기본 HTML을 ㅋㄹ라이언트로 봰다.
=> 서버에서 데이터 JSON 형식으로 만들어 클라이언트로 보낸다.
=> 웹페이지 출력 절차
1) 웹브라우저 --> 웹서버 : 기본 HTML을 요청한다.
2) 웹서버 --> 웹브라우저 : 요청한 HTML을 보낸다.
3) 웹브라우저 : HTML 렌더링한다.
4) 웹브라우저 --> 웹 서버 : 화면을 만들 때 사용할 데이터를 요청한다.
5) 웹서버 --> 웹브라우저 : JSON 형식 데이터를 보낸다
6) 웹브라우저 : JSON 형식 데이터를 사용하여 화면을 변경한다.

*/
var express = require('express') //api 익스프레스 쓰기위해 받아옴
var bodyParser = require('body-parser') //post방식 데이터를 받아오기위해
//url.parser get데이터를 받아오기위해
var path = require('path') //경로 객체
var cons = require('consolidate');
// 엔진에 상관없이 단일한 방법으로 처리하려고 사용

var app = express()
app.use(express.static('public')) //정적자원을 모아둘 폴더를 지정함
app.use(bodyParser.urlencoded({extended: false}))
//post 방식 데이터 분석기 데이터를 추출하려고 씀..
// get 방식 일떄는 url.parse()


// 서비스 라우터를 등록한다.
app.use('/student', require('./control/student-control'))
      //url /student로 들어왔을때    이 라우터한테 물어봐라 알지도 모른다
app.use('/teacher', require('./control/teacher-control'))
app.use('/manager', require('./control/manager-control'))
app.use('/lecture', require('./control/lecture-control'))


//클라이언트에서 룻으로 요청했을때 서버에서 render 즉 index html을 클라이언트로 반환한다.
//그래서 클라이언트는 html을 받아 웹브라우저가 출력한다

app.listen(8888, function() {
  console.log('서버가 시작되었습니다.')
})
