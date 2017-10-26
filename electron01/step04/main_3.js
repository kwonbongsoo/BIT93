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

app.on('window-all-closed', () => {
  if (process.platform !== 'darwin') {
    app.quit()
  }
})

function createWindow() {

  win = new BrowserWindow({width: 800, height: 600})
  var htmlURL = url.format({
    protocol: 'file:',
    pathname: path.join(__dirname, 'index.html'),
    slashes: true
  })
  console.log(htmlURL)
  win.loadURL(htmlURL)
}


function quitApp() {
  console.log('애플리케이션 종료하기')
}
