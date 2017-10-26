const express = require('express')
const datasource = require('../util/datasource')
const studyDao = require('../dao/study-dao')
const studyService = require('../service/study-service')

const connection = datasource.getConnection()
studyDao.setConnection(connection)
studyService.setStudyDao(studyDao)


const router = express.Router()

router.get('/list.json', (request, response) => {
  var pageNo = 1,
      pageSize = 6;
  if (request.query.pageNo) {
    pageNo = parseInt(request.query.pageNo)
  }
  if (request.query.pageSize) {
    pageSize = parseInt(request.query.pageSize)
  }
  studyService.list(pageNo, pageSize, function(results, totalCount) {
	  response.json({'list': results, 'totalCount': totalCount})
  }, function(error) {
      response.status(200)
              .set('Content-Type', 'text/plain;charset=UTF-8')
              .end('error')
      console.log(error)
  })
})

router.get('/search.json', function(request, response) {
  var pageNo = 1,
      pageSize = 6,
      searchValue = request.query.searchValue,
      type = request.query.type

  if (request.query.pageNo) {
    pageNo = parseInt(request.query.pageNo)
  }
  if (request.query.pageSize) {
    pageSize = parseInt(request.query.pageSize)
  }
  studyService.search(pageNo, pageSize, searchValue, type, (results, totalCount) => {
    response.json({'list': results, 'totalCount': totalCount/*, 'searchValue':searchValue , 'type':type*/})
  }, function(result) {
    response.json(result)

  }, function(error) {
    response.status(200)
            .set('Content-Type', 'text/plain;charset=UTF-8')
            .end('error')
    console.log(error)
  })
})

router.get('/detail.json', function(request, response) {
  var no = parseInt(request.query.no)
  studyService.detail(no, function(result) {
    response.json(result)
  }, function(error) {
    response.status(200)
      .set('Content-Type', 'text/plain;charset=UTF-8')
      .end('error')
    console.log(error)
  })
})

router.post('/update.json', function(request, response) {
  studyService.update({
    no: request.body.no,
    title: request.body.title,
    email: request.body.email,
    content: request.body.content,
    startDate: request.body.startDate,
    endDate: request.body.endDate,
    quantity: request.body.quantity,
    price: request.body.price,
    place: request.body.place,
    lat : request.body.lat,
    lng : request.body.lng
}, function(result) {
    response.json({'result': 'yes'})

  }, function(error) {
    response.status(200)
            .set('Content-Type', 'text/plain;charset=UTF-8')
            .end('error')
    console.log(error)
  })
})

router.get('/delete.json', function(request, response) {
  var no = parseInt(request.query.no)
  studyService.delete(no, function(result) {
    response.json({'result': 'yes'})
  }, function(error) {
    response.status(200)
            .set('Content-Type', 'text/plain;charset=UTF-8')
            .end('error')
    console.log(error)
  })
})


router.post('/add.json', function(request, response) {
  studyService.insert({
    title: request.body.title,
    email: request.body.email,
    content: request.body.content,
    startDate: request.body.startDate,
    endDate: request.body.endDate,
    quantity: request.body.quantity,
    price: request.body.price,
    place: request.body.place,
    lat: request.body.lat,
    lng: request.body.lng
  }, function(result) {
    response.json({'result': 'yes'})

  }, function(error) {
    response.status(200)
            .set('Content-Type', 'text/plain;charset=UTF-8')
            .end('error')
    console.log(error)
  })
})



module.exports = router
