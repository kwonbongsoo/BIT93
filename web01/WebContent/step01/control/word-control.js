const express = require('express')
const datasource = require('../util/datasource')
const wordDao = require('../dao/word-dao')
const wordService = require('../service/word-service')

const connection = datasource.getConnection()
wordDao.setConnection(connection)
wordService.setWordDao(wordDao)


const router = express.Router()

router.get('/word.json', (request, response) => {

  wordService.list(function(results) {
	  response.json({'list': results})
  }, function(error) {
      response.status(200)
              .set('Content-Type', 'text/plain;charset=UTF-8')
              .end('error')
      console.log(error)
  })
})

module.exports = router
