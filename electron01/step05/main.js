/* 주제: HTML 파일의 URL 경로를 쉽게 만들기
*/
// 'electron' 모듈의 리턴 값 중에서
// 웹 브라우저 창을 생성 시킬 도구도 꺼낸다.
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
