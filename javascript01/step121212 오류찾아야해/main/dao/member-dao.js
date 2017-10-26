


// MEMB 테이블 데이터 처리
"use strict"



module.exports = {
  setConnection(con) {
    this.connection = con
  },
  selectList(pageNo,pageSize) {
    this.connection.query(
      'select mno, name, tel, email \
      from memb  \
      order by name asc \
      limit ?, ?',
      [(pageNo-1)*3, pageSize],
    function (error, results) {
      if(error) {
        throw error
      } else {
        view(results)
      }
    })
  },

}

function view(results) {
  var str = ['']
    for (var i = 0; i < 3; i++) {
      if (i < results.length) {
        str[i] = ''
        let r = results[i]
        str[i] +="<tr><td>" + r.mno +
        "</td><td><a href='#' data-no='" + r.mno + "' class='view-link'>" + r.name +
        "</a></td><td>" + r.tel +
        "</td><td>" + r.email +
        "</td>"
      } else {
        str[i] +="<tr><td colspan='5'>&nbsp;</td></tr>"
      }
      console.log(str)
    } return str
  } //list()
