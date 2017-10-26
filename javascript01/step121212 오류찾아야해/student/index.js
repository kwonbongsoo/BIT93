"use strict"
window.$ = window.jQuery = require('jquery')



var tbody = $('#student-tbl > tbody')

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
    'Content-Type' : 'text/plain;charset=UTF-8'
  })

  var urlInfo = url.parse(request.url, true)

  var pageNo = parseInt(urlInfo.query.pageNo)
  var pageSize = parseInt(urlInfo.query.pageSize)
  memberDao.selectList(pageNo, pageSize)


  response.end()
})
server.listen(8888)

console.log("서버 실행 중...")


  function list(results) {
      tbody.html('');
      for (var i = 0; i < 3; i++) {
        if (i < results.length) {
          let s = results[i]
          $("<tr>").html("<td>" + s.mno +
          "</td><td><a href='#' data-no='" + s.mno + "' class='view-link'>" + s.name +
          "</a></td><td>" + s.tel +
          "</td><td>" + s.email +
          "</td><td>" + (s.work == "Y" ? "재직중" : "실업") + "</td>")
          .appendTo(tbody)
        } else {
          $("<tr><td colspan='5'>&nbsp;</td></tr>").appendTo(tbody)
        }
      }
    }
