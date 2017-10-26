// 학생 정보를 다루는 서비스를 정의한다.
const express = require('express')
const datasource = require('../util/datasource')
const managerDao = require('../dao/manager-dao')
const managerService = require('../service/manager-service')
const memberDao = require('../dao/member-dao')
const connection = datasource.getConnection()

managerService.setMemberDao(memberDao)
managerDao.setConnection(connection)
managerService.setManagerDao(managerDao)
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
  managerService.list(pageNo, pageSize, (results, totalCount) => {
    response.json({'list':results, 'totalCount': totalCount})
  }, (error) => {
    response.end('오류!')
    console.log(error)
  })
})

router.get('/detail.json', (request, response) => {
  var no = parseInt(request.query.no)
  managerService.detail(no, (result) => {
    response.json(result)
  }, (error) => {
    response.status(200)
    .set('Content-type', 'text/plain;charset=UTF-8')
    .end('error')
console.log(error)
  })
})

router.post('/update.json' ,(request, response) => {
  managerService.update({
    no : request.body.no,
    posi: request.body.posi,
    fax: request.body.fax,
    name : request.body.name,
    tel : request.body.tel,
    email : request.body.email,
    password : '1111',
    path: request.body.path
  }, (result) => {
    response.json(result)
  }, (error) => {
    response.render('error', {
      'message': '학생 목록 데이터 변경 중 오류 발생'
    })
    console.log(error)
  })

})

router.get('/delete.json', (request, response) => {
  var no = parseInt(request.query.no)
  managerService.delete(no,(result) => {
    response.json(result)
  }, (error) => {
    response.status(200)
    .set('Content-type', 'text/plain;charset=UTF-8')
    .end('error')
console.log(error)
  })
})

router.post('/add.json', (request, response) => {
  managerService.insert({
    posi: request.body.posi,
    fax: request.body.fax,
    name : request.body.name,
    tel : request.body.tel,
    email : request.body.email,
    password : '1111',
    path : request.body.path
  }, (result) => {
    response.json(result)
  }, (error) => {
    response.status(200)
    .set('Content-type', 'text/plain;charset=UTF-8')
    .end('error')
console.log(error)
  })
})

module.exports = router
