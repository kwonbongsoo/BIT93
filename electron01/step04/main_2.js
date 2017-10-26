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
  win.loadURL(path.join('file://', __dirname ,'/index.html'))
  console.log(path.join('file://', __dirname ,'/index.html'))
  //win.loadURL('file:///C:/workspace/electron01/step03/index.html')
}

// index.html 경로를 path 객체의 join() 기능을 이용하여 처리했다.
// 문제점 : URL의 표기 형식을 준수하고 있지 않다

// URL의 표기 형식
// => 프로토콜 명 다음에 '://'가 와야 한다
// => url은 항상 슬래시(/)로 표현해야 한다.

/* URI(Uniform Resource Identifier)
- 인터넷의 자원(파일 또는 컴퓨터) 위치를 표현하는 공통 표기범
- 1) URN (Uniform Resource Name)
    ex)
- 2)
*/

function quitApp() {
  console.log('애플리케이션 종료하기')
}
