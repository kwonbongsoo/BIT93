//Echo 서버 만들기
const net = require('net')
// 1) 서버 객체를 준비한다
const server = net.createServer((socket) => { //클라이언트가 접속하면
  //자바에서는 serverSocket.accept()이랑 기능이 같다.
  console.log('=> 클라이언트가 연결 되었습니다.')
  socket.on('data', (data) => {
    socket.write('[디져도 솔저각]' + data.toString())
    socket.destroy()

  })
})
// 2) 서버를 시작시킨다.
server.listen(8888, () => {
  console.log('=> 디져도 실행중...')
})
