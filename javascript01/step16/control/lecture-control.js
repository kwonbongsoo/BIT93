// 강의 정보를 다루는 서비스를 정의한다.
const express = require('express')
const datasource = require('../util/datasource')
const lectureDao = require('../dao/lecture-dao')
const managerDao = require('../dao/manager-dao')
const classroomDao = require('../dao/classroom-dao')
const lectureService = require('../service/lecture-service')
const managerService = require('../service/manager-service')
const classroomService = require('../service/classroom-service')

const connection = datasource.getConnection()
lectureDao.setConnection(connection)
lectureService.setLectureDao(lectureDao)
managerDao.setConnection(connection)
managerService.setManagerDao(managerDao)
classroomDao.setConnection(connection)
classroomService.setClassroomDao(classroomDao)

const router = express.Router()

router.get('/list.json', (request, response) => {
  var pageNo = 1,
      pageSize = 3;
  if (request.query.pageNo) {
    pageNo = parseInt(request.query.pageNo)
  }
  if (request.query.pageSize) {
    pageSize = parseInt(request.query.pageSize)
  }
  lectureService.list(pageNo, pageSize, function(results, totalCount) {
    response.json({'list':results, 'totalCount' : totalCount})
  }, function(error) {
    response.status(200)
          .set('Content-type', 'text/plain;charset=UTF-8')
          .end('error')
    console.log(error)
  })
})

router.get('/detail.json', function(request, response) {
  var no = parseInt(request.query.no)
  lectureService.detail(no, function(result) {
        response.json(result)
      }, function(error) {
        response.status(200)
              .set('Content-type', 'text/plain;charset=UTF-8')
              .end('error')
        console.log(error)
  })
})

router.get('/manager.json', function(request, response) {
  managerService.listName((managers) => {
        response.json(managers)
      }, function(error) {
        response.status(200)
              .set('Content-type', 'text/plain;charset=UTF-8')
              .end('error')
  })
})

router.get('/classroom.json', function(request, response) {
  classroomService.listName((classrooms) => {
        response.json(classrooms)
      }, function(error) {
        response.status(200)
              .set('Content-type', 'text/plain;charset=UTF-8')
              .end('error')
  })
})


router.post('/update.json', function(request, response) {
  lectureService.update({
    no: request.body.no,
    titl: request.body.titl,
    dscp: request.body.dscp,
    sdt2: request.body.sdt2,
    edt2: request.body.edt2,
    qty: request.body.qty,
    thrs: request.body.thrs,
    pric: request.body.pric,
    crmno: (request.body.crmno == 0 ? null : request.body.crmno),
    mrno: (request.body.mrno == 0 ? null : request.body.mrno)
  }, function(result) {
    response.json(result)

  }, function(error) {
    response.render('error', {
      'message': '강의 데이터를 변경하는 중 오류가 발생했습니다.'})
    console.log(error)
  })
})

router.get('/delete.json', function(request, response) {
  var no = parseInt(request.query.no)
  lectureService.delete(no,(result) => {
    response.json(result)
  }, function(error) {
        response.status(200)
              .set('Content-type', 'text/plain;charset=UTF-8')
              .end('error')
  })
})

router.post('/add.json', function(request, response) {
  lectureService.insert({
    titl: request.body.titl,
    dscp: request.body.dscp,
    sdt2: request.body.sdt2,
    edt2: request.body.edt2,
    qty: request.body.qty,
    thrs: request.body.thrs,
    pric: request.body.pric,
    crmno: (request.body.crmno == 0 ? null : request.body.crmno),
    mrno: (request.body.mrno == 0 ? null : request.body.mrno)
  }, function(result) {
    response.json(result)

  }, function(error) {
    response.status(200)
          .set('Content-type', 'text/plain;charset=UTF-8')
          .end('error')
  })
})


module.exports = router