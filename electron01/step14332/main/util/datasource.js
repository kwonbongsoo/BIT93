// connection 객체를 준비
"use strict"
const mysql = require('mysql')
const con = mysql.createConnection({
  database: 'webappdb',
  user: 'webapp',
  password: '1111'
})
con.connect()

// module.exports.getConnection = function() { return con }
module.exports = {
  getConnection() {
    return connection
  }
}
