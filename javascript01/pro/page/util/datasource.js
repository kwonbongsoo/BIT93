"use strict"
const mysql = require('mysql')
const con = mysql.createConnection({
  database: 'pro',
  user: 'suna',
  password: '1111'
})
con.connect()

/* 주석에 작성된 코드와 그 아래의 코드는 같다.
module.exports.getConnection = function() {
  return con
}
*/
module.exports = {
  getConnection() {
    return con
  }
}