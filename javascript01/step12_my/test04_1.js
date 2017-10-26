/* 요청 정보 다루기 - Quiz 2
=> 사용자로부터 페이지 번호와 개수를 입력 받아
  학생 목록을 HTML 페이지로 출력하시오.
=> 요청 예)
  http://localhost:8888/student/list.do?pageNo=2&pageSize=3
=> 출력 예)
  간단히 테이블로 출력하라!
*/

"use strict"

// console.log(window)

// window.$ = window.jQuery = require('jquery')


const datasource = require('./main/util/datasource')
const connection = datasource.getConnection()

const memberDao = require('./main/dao/member-dao')
memberDao.setConnection(connection)

const http = require('http')
const url = require('url')

const server = http.createServer(function(request, response) {
  if (request.url == '/favicon.ico') {
    response.end();
    return;
  }
  console.log('클라이언트 요청이 들어왔네!')

  response.writeHead(200, {
    'Content-Type' : 'text/html;charset=UTF-8'
  })

  var urlInfo = url.parse(request.url, true)

  var pageNo = parseInt(urlInfo.query.pageNo)
  var pageSize = parseInt(urlInfo.query.pageSize)
  memberDao.selectList(pageNo,
    pageSize,
    function(results) {
      response.write('<table border="1">\
      <thead>\
        <tr><th>번호</th><th>이름</th><th>이메일</th><th>전화</th><th>직장인</th></tr>\
      </thead>\
      <tbody>')
      for (var r of results) {
        response.write('<tr><td>'+r.mno+'</td>')
        response.write('<td>'+r.name+'</td>')
        response.write('<td>'+r.email+'</td>')
        response.write('<td>'+r.tel+'</td>')
        response.write('<td>'+r.work+'</td></tr>')
      }
      response.write('</tbody>\
      </table>')
        response.write('</body></html>')
        response.end()
    },
    function(error) {
      if(error) {
        response.write('DB 오류')
        response.write('</body></html>')
        response.end()
      }
    })
})
server.listen(8888)

console.log("서버 실행 중...")
