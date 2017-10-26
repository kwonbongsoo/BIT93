"use strict"

const http = require('http')
const url = require('url')

const datasource = require('./datasource')
const studentDao = require('./student-dao')
const studentService = require('.student-service')
const connection = require('./student-service')

studentDao.setConnection(connection)
studentService.setStudentDao(studentDao)

const server = http.createServer(function(request, response) {
  if (request.url == '/favicon.ico') {
    response.end()
    return
  }

  if (urlInfo.pathname != '/student/list.do') {
    response.writeHead(404, {
      'Content-Type' : 'text/plain;charset=UTF-8'
    })
    response.end('잘못된 url입니다.')
    return
  }
  response.writeHead(200, {
    
  })
})
