/* 데이터 추가 명령: In-parameter 활용
=> insert나 update 할 때 여러 개의 값을 지정하기 위해 문자열을 '+' 연산자를 사용하여
   문자열을 연결해야 한다.
   이런 불편함을 없애기 위해 In-parameter 문법이 나왔다.
 */

"use strict"
const mysql = require('mysql')


var connection = mysql.createConnection({
  database: 'webappdb',
  user: 'webapp',
  password: '1111'
})

connection.connect()


connection.query('insert into memb(name, email, tel, pwd)'+
  ' values(?,?,?, password(?))',
  ["오호라", "ohora@test.com", "111-1111", "1111"], 
  function(error, results) {
  console.log('결과를 가져왔음')
  if (error) throw error;
//results 에 들어있는 값을 한 개씩 꺼내 출력한다.
  console.log(results)
})
//row = record  가로줄........
connection.end()
console.log('MySQL 서버와 연결 끊기가 예약 되었음!');
