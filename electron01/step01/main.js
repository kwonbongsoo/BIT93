/* 주제: Electron 모듈 사용하기
- Electron 은 크로스 플랫폼을 지원하는 데스크탑 애플리케이션을
  만들 때 사용하는 NodeJS용 자바스크립트 프레임워크이다.
- HTML, CSS, JavaScript를 사용하여 window 프로그래밍을 한다
- 내부적으로 오픈 소스 웹 브라우저 콤포넌트인 Chromium과
  NodeJS를 사용하여 실행한다
- Chromium은 구글의 크롬(Chrome) 브라우저의 오픈소스판이다.
- 사용법:
1) 노드 패키지 관리자(npm)를 사용하여 Electron 모듈을 가져온다.
  >npm install Electron -g    <== 글로벌로 설치하라
  >electron -v      <== 버전을 출력해서 설치여부를 확인하라
2) Electron을 사용해서 윈도우 생성
  > package.json 파일 생성 - 프로그램 설정 파일
  > main.js 파일 생성 - 자바스크립트 실행 시작 파일
  > index.html 파일 생성 - 메인 윈도우 파일
3) 실행
  > Electron
    => 현재 폴더에서 package.json을 읽어 들인다.
    => packge.json 파일에 등록된 자바스크립트 파일을 읽어 실행한다
*/
const {app, BrowserWindow} = require('electron')
/* const electron = require('electron')
   const app = electron.app
   풀어쓰면 이렇게다
*/
const path = require('path')
//npm로 설치한 모듈은 이름만 있으면된다



//윈도우 객체(의 주소)를 저장할 변수
let win

/* app.on(이벤트명, 리스너)
- 지정된 이벤트가 발생할 때 호출될 함수를 등록한다.
- 이벤트(event)
  객체의 특정 실행 상태를 가리킨다
- 리스너(listener) = 이벤트 리스너 = 이벤트 핸들러(handler) = 콜백함수
  => 어떤 객체의 실행이 특정 상태에 놓일 때 자동으로 호출 되는 함수를 말한다
     그래서 "내가 호출하는 것이 아니라 객체가 호출한다"라는 의미로
     "콜백함수(callback)"라 부른다
  => 특정 이벤트에 귀를 기울이는 함수
     그래서 "이벤트의 소식을 기다리는 자"라는 의미로
     "이벤트 리스너"라고 부른다
  => 이 함수가 하는 일은 그 이벤트에 따라 적절한 작업을 처리한다.
     그래서 "이벤트를 다루는 자"라는 의미로 "이벤트 핸들러"라고 부른다
*/

// 해석:
// - 'ready' 이벤트 ?/
//  => 애플리케이션이 실행 준비를 마친 상태
//  => 이 상태 일때 보통 윈도우를 생성한다
//애플리케이션이 실행 준비를 마쳤으면, 윈도우를 생성하는 함수를 호출하라!

app.on('ready', createWindow)
//초기화가 끝나면 윈도우를 만들어라라는 함수를 부름
// 윈도우를 생성하고 출력하는 일을 하는 함수


//   해석:
//   - 'window-all-closed' 이벤트?
//     => 애플리케이션에서 만든 모든 윈도우를 닫았을 때의 상태
//     => 이 상태일때 보통 애플리케이션을 종료한다

app.on('window-all-closed', () => {
  if (process.platform !== 'darwin') {
    app.quit()
  }
})


function createWindow() {
  console.log('윈도우 생성하기')
}

//앱을 종료 시키는 함수

function quitApp() {
  console.log('애플리케이션 종료하기')
}