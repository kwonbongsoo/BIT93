// MEMB 테이블 데이터 처리
"use strict"

module.exports = {
  setConnection(con) {
    this.connection = con
  },
  selectList(pageNo,pageSize,successFn,errorFn) {
    this.connection.query(
      'select mno, name, tel, email \
      from memb  \
      order by name asc \
      limit ?, ?',
      [(pageNo-1)*3, pageSize],
    function (error, results) {
      if(error) {
        errorfn(error)
      } else {
        successFn(results)
      }
    })
  },
}
