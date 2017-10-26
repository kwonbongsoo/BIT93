/* Express 프레임워크 적용
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

app.engine('hbs', cons.handlebars) //기본 템플릿 엔진을 등록한다.
app.set('view engine', 'hbs') //기본 템플릿 엔진으로 어떤것을 사용할지 지정한다.
app.set('views', path.join(__dirname, '/views'))
//views 경로가 __dirname step15의 views 폴더 안에 있다 라고 셋팅
// 템플릿 파일이 있는 위치를 지정

// 서비스 라우터를 등록한다.
app.use('/student', require('./control/student-control'))
      //url /student로 들어왔을때    이 라우터한테 물어봐라 알지도 모른다
app.use('/teacher', require('./control/teacher-control'))
app.use('/manager', require('./control/manager-control'))
app.use('/lecture', require('./control/lecture-control'))

//템플릿은 껍데기 형식...
app.get('/', function(request, response) {
  response.render('index') //템플릿 엔진 출력
})
//클라이언트에서 룻으로 요청했을때 서버에서 render 즉 index html을 클라이언트로 반환한다.
//그래서 클라이언트는 html을 받아 웹브라우저가 출력한다

app.listen(8888, function() {
  console.log('서버가 시작되었습니다.')
})
