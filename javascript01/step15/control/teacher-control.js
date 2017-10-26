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

router.get('/list.do', (request, response) => {
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
    response.render('teacher/index', {
     'data': results,
     'pageNo': pageNo,
     'nextPageNo': pageNo + 1,
     'prevPageNo': pageNo - 1,
     'disabledPrevBtn': (pageNo == 1) ? 'disabled' : '',
     'disabledNextBtn': (pageNo == lastPageNo) ? 'disabled' : ''

   })
  }, (error) => {
    response.end('오류!')
    console.log(error)
  })
})

router.get('/detail.do', function(request, response) {
  var no = parseInt(request.query.no)
  teacherService.detail(no, (result) => {
    response.render('teacher/view', {
      'detail' : true,
      'data': result,
      'checkedWorking': (result.work == 'Y' ? 'checked' : '')
    })
  }, (error) => {
    response.end('오류')
    console.log(error)
  })
})

router.post('/update.do' ,(request, response) => {

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
    response.redirect('list.do')
  }, (error) => {
    response.render('error', {
      'message': '학생 목록 데이터 변경 중 오류 발생'
    })
    console.log(error)
  })

})

router.get('/delete.do', (request, response) => {
  var no = parseInt(request.query.no)
  teacherService.delete(no,(result) => {
    response.redirect('list.do')
  }, (error) => {
    response.render('error', {
      'message': '학생 데이터 삭제 중 오류 발생'
    })
    console.log(error)
  })
})

router.get('/form.do', (request, response) => {
  response.render('teacher/view')
})

router.post('/add.do', (request, response) => {
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
    response.redirect('list.do')
  }, (error) => {
    response.render('error', {
      'message': '학생 목록 데이터 등록 중 오류 발생'})
      console.log(error)
  })
})

module.exports = router