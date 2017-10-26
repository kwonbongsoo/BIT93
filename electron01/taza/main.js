/* 주제: 응용 II
=> MySQL DBMS에 직접 접속하기
 */
const {app, BrowserWindow} = require('electron')
const path = require('path')
var url = require('url')





const datasource = require('./util/datasource')
const connection = datasource.getConnection()

const wordDao = require('./dao/word-dao')
wordDao.setConnection(connection)

const wordService = require('./service/word-service')
wordService.setWordDao(wordDao)

const wordControl = require('./control/word-control')

global.wordService = wordService
global.wordControl = wordControl



let win
app.on('ready', createWindow)


function createWindow() {
  win = new BrowserWindow({width: 450, height: 620})
  win.loadURL(url.format({
    protocol: 'file:',
    pathname: path.join(__dirname, 'test.html'),
    slashes: true
  }))

  //win.webContents.openDevTools() // 웹브라우저의 개발도구창을 띄운다.

}




//
