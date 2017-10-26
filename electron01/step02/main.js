/* 주제: 윈도우 생성하기
 * 애플리케이션에서 'ready' 이벤트가 발생했을 때,
  즉 'ready' 상태일 때 보통 윈도우를 생성한다.

*/
// 'electron' 모듈의 리턴 값 중에서
// 웹 브라우저 창을 생성 시킬 도구도 꺼낸다.
const {app, BrowserWindow} = require('electron')

let win

app.on('ready', createWindow)

function createWindow() {
  win = new BrowserWindow({width: 800, height: 600})
}
