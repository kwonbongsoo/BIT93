/* 데이터 추가 명령: insert
insert into
 */

"use strict"
const mysql = require('mysql')


var connection = mysql.createConnection({
  database: 'webappdb',
  user: 'webapp',
  password: '1111'
})

connection.connect()


connection.query('delete from memb where name="aaa"', function(error, results) {
  console.log('결과를 가져왔음')
  if (error) throw error;
//results 에 들어있는 값을 한 개씩 꺼내 출력한다.
  console.log(results)
})
//row = record  가로줄........
connection.end()
console.log('MySQL 서버와 연결 끊기가 예약 되었음!');
