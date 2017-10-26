/* 주제: MySQL DBMS에 직접 접속하기 VIII
=> 폴더 구조 정리!
 */




const {app, BrowserWindow} = require('electron')
const path = require('path')
const url = require('url')

const datasource = require('./util/datasource')
const connection = datasource.getConnection()


const studentDao = require('./dao/student-dao')
studentDao.setConnection(connection)

const memeberDao = require('./dao/member-dao')
memeberDao.setConnection(connection)

const studentService = require('./service/student-service')
studentService.setMemberDao(memberDao)
studentService.setStudentDao(studentDao)

global.studentService = studentService

// let win
//
// app.on('ready', createWindow)
//
// function createWindow() {
//   win = new BrowserWindow({width: 800, height: 600})
//   win.loadURL(url.format({
//     protocol: 'file:',
//     pathname: path.join(__dirname, '../renderer/index.html'),
//     slashes: true
//   }))
//   //win.webContents.openDevTools() // 웹브라우저의 개발도구창을 띄운다.
//
// }




//
