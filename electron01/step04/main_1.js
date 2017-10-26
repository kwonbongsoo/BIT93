/* 주제: HTML 파일의 URL 경로를 쉽게 만들기
*/
// 'electron' 모듈의 리턴 값 중에서
// 웹 브라우저 창을 생성 시킬 도구도 꺼낸다.
const {app,BrowserWindow} = require('electron')
const path = require('path')


let win


app.on('ready', createWindow)

app.on('window-all-closed', () => {
  if (process.platform !== 'darwin') {
    app.quit()
  }
})

function createWindow() {
  // Create the browser window.
  win = new BrowserWindow({width: 800, height: 600})
  win.loadURL('file://'+ __dirname +'/index.html')
  //win.loadURL('file:///C:/workspace/electron01/step03/index.html')
  //밑에꺼보다 훨씬 편하다
}
function quitApp() {
  console.log('애플리케이션 종료하기')
}
