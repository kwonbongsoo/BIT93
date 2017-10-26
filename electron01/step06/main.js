/* 주제: 응용2
=> MySQL DBMS에 직접 접속하기
*/

const {app,BrowserWindow} = require('electron')
const path = require('path')

// URL 경로를 보다 쉽게 다루기 위한 모듈이다.
const url = require('url')

let win


app.on('ready', createWindow)

function createWindow() {

  win = new BrowserWindow({width: 800, height: 600})
  win.loadURL(url.format({
    protocol: 'file:',
    pathname: path.join(__dirname, 'index.html'),
    slashes: true
  }))
  // win.webContents.openDevTools()//웹브라우저의 개발도구창을 띄운다
//실무에서는 이렇게 쓴다....
}


function quitApp() {
  console.log('애플리케이션 종료하기')
}
