// 학생 정보를 다루는 서비스를 정의한다.
const express = require('express')
const datasource = require('../util/datasource')
const teacherDao = require('../dao/teacher-dao')
const teacherService = require('../service/teacher-service')
const memberDao = require('../dao/member-dao')
const connection = datasource.getConnection()

teacherService.setMemberDao(memberDao)
teacherDao.setConnection(connection)
teacherService.setTeacherDao(teacherDao)
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
  teacherService.list(pageNo, pageSize, (results, totalCount) => {
    var lastPageNo = parseInt(totalCount / pageSize) +(((totalCount % pageSize) > 0) ? 1 : 0)
    // response.setHeader('Content-type', 'text/html;charset=UTF-8')
    response.json({'list':results, 'totalCount' : totalCount})
  }, (error) => {
    response.status(200)
          .set('Content-type', 'text/plain;charset=UTF-8')
          .end('error')
    console.log(error)
  })
})

router.get('/detail.json', function(request, response) {
  var no = parseInt(request.query.no)
  teacherService.detail(no, (result) => {
    response.json(result)
  }, (error) => {
    response.status(200)
          .set('Content-type', 'text/plain;charset=UTF-8')
          .end('error')
    console.log(error)
  })
})

router.post('/update.json' ,(request, response) => {

  teacherService.update({
    no : request.body.no,
    hmpg: request.body.hmpg,
    fcbk: request.body.fcbk,
    name : request.body.name,
    tel : request.body.tel,
    email : request.body.email,
    password : '1111',
    twit: request.body.twit
  }, (result) => {
    //웹브라우저에게 응답 내용을 보내지 않고,
    // 대신 list.do로 다시 요청 하려고 응답한다.
    // 그러면 웹브라우저는 list.do로 다시 요청한다.
    response.json(result)
  }, (error) => {
    response.status(200)
          .set('Content-type', 'text/plain;charset=UTF-8')
          .end('error')
    console.log(error)
  })
})

router.get('/delete.json', (request, response) => {
  var no = parseInt(request.query.no)
  teacherService.delete(no,(result) => {
    response.json(result)
  }, (error) => {
    response.status(200)
          .set('Content-type', 'text/plain;charset=UTF-8')
          .end('error')
    console.log(error)
  })
})


router.post('/add.json', (request, response) => {
  teacherService.insert({
    no : request.body.no,
    hmpg: request.body.hmpg,
    fcbk: request.body.fcbk,
    name : request.body.name,
    tel : request.body.tel,
    email : request.body.email,
    password : '1111',
    twit: request.body.twit
  }, (result) => {
    response.json({'result' : 'yes'})
  }, (error) => {
    response.status(200)
          .set('Content-type', 'text/plain;charset=UTF-8')
          .end('error')
    console.log(error)
  })
})

module.exports = router
