// 학생 정보를 다루는 서비스를 정의한다.
const express = require('express')
const datasource = require('../util/datasource')
const studentDao = require('../dao/student-dao')
const studentService = require('../service/student-service')
const memberDao = require('../dao/member-dao')
const connection = datasource.getConnection()

studentService.setMemberDao(memberDao)
studentDao.setConnection(connection)
studentService.setStudentDao(studentDao)
memberDao.setConnection(connection)



const router = express.Router()

router.get('/list.json', (request, response) => {
  var pageNo = 1,
      pageSize = 3
  if(request.query.pageNo) { //request.query.pageNo 객체안에서 따라가는 문법 OGNL이라한다.
    pageNo = parseInt(request.query.pageNo)
  }
  if(request.query.pageSize) {
    pageSize = parseInt(request.query.pageSize)
  }
  studentService.list(pageNo, pageSize, (results, totalCount) => {
    response. //set(함수로 콘텐트 타입을 다르게 주면 이걸 기준으로 데이터를 변환한다..)
    //status(200)
          // .set('Content-type', 'application/json;charset=UTF-8')
          // .end(JSON.stringify(results))
          // 제이슨의 기본 타입은 application/json 타입이 기본이다.
          json({'list':results, 'totalCount' : totalCount})
    //this를 반환하기 떄문에 이위의 코드가 가능하다
    // response.status(200)
    // end('ok', 'UTF-8') 같은 동작을하는 코드이다
  }, (error) => {
    response.status(200)
          .set('Content-type', 'text/plain;charset=UTF-8')
          .end('error')
    console.log(error)
  })
})

router.get('/detail.json', (request, response) => {
  var no = parseInt(request.query.no)
  studentService.detail(no, (result) => {
    response.json(result)
  }, (error) => {
    response.status(200)
          .set('Content-type', 'text/plain;charset=UTF-8')
          .end('error')
    console.log(error)
  })
})

router.post('/update.json' ,(request, response) => {

  studentService.update({
    no : request.body.no,
    working: request.body.working,
    schoolName: request.body.schoolName,
    name : request.body.name,
    tel : request.body.tel,
    email : request.body.email,
    password : '1111'
  }, (result) => {
    //웹브라우저에게 응답 내용을 보내지 않고,
    // 대신 list.do로 다시 요청 하려고 응답한다.
    // 그러면 웹브라우저는 list.do로 다시 요청한다.
    response.json({'result': 'yes'})
  }, (error) => {
    response.status(200)
          .set('Content-type', 'text/plain;charset=UTF-8')
          .end('error')
    console.log(error)
  })

})

router.get('/delete.json', (request, response) => {
  var no = parseInt(request.query.no)
  studentService.delete(no, (result) => {
    response.json({'result' : 'yes'})
  }, (error) => {
    response.status(200)
          .set('Content-type', 'text/plain;charset=UTF-8')
          .end('error')
    console.log(error)
  })
})

router.post('/add.json', (request, response) => {
  studentService.insert({
    working: (request.body.working == undefined ? 'N' : 'Y'),
    schoolName: request.body.schoolName,
    name : request.body.name,
    tel : request.body.tel,
    email : request.body.email,
    password : '1111'
  }, (result) => {
    response.json({'result': 'yes'})
  }, (error) => {
    response.status(200)
          .set('Content-type', 'text/plain;charset=UTF-8')
          .end('error')
    console.log(error)
  })
})

module.exports = router
