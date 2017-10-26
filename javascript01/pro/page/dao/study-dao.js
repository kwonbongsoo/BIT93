"use strict"

module.exports = {
  setConnection(con) {
    this.connection = con
  },

  selectList(pageNo, pageSize, successFn, errorFn) {
    this.connection.query(
      "select sno, title, date_format(sdt,'%Y-%m-%d') sdt2 , \
      date_format(edt,'%Y-%m-%d') edt2, many, place \
      from study \
      order by sdt desc \
      limit ?, ?",
      [(pageNo - 1) * pageSize, pageSize],
      function(error, results) {
        if (error) {
          errorFn(error)
        } else {
          successFn(results)
        }
      }) // connection.query()
  },//selectList()
  search(pageNo, pageSize ,searchValue, successFn, errorFn) {
    this.connection.query(
      "select sno, title, date_format(sdt,'%Y-%m-%d') sdt2 , \
      date_format(edt,'%Y-%m-%d') edt2, many, place \
        from study where title like ? \
      order by sdt desc \
      limit ?, ?" ,
      [ searchValue, (pageNo - 1) * pageSize, pageSize],
      function(error, results) {
        if (error) {
          errorFn(error)
        } else {
          successFn(results)
        }
      })
  },//search()

  countAll(successFn, errorFn) {
    this.connection.query(
      'select count(*) cnt from study',
      function(error, results) {
        if (error) {
          errorFn(error)
        } else {
          successFn(results)
        }
      }) //connection.query()
  },//countAll()

  searchCountAll(searchValue, successFn, errorFn) {
    this.connection.query(
      'select count(*) cnt from study where title=?',
      [searchValue],
      function(error, results) {
        if (error) {
          errorFn(error)
        } else {
          successFn(results)
        }
      }) //connection.query()
  },//countAll()

  selectOne(no, successFn, errorFn) {
    this.connection.query(
      "select sno, email, title, dscp, \
      date_format(sdt,'%Y-%m-%d') sdt2, \
      date_format(edt,'%Y-%m-%d') edt2, \
      many, price, place, lat, lng \
      from study \
      where sno=?",
      [no],
      function(error, results) {
        if (error) {
          errorFn(error)
        } else {
          successFn(results[0])
        }
      }) // connection.query()
  },//selectOne()

  insert(study, successFn, errorFn) {
    this.connection.query(
      'insert into study(title,dscp,sdt,edt,many,price,place,email,lat,lng) \
       values(?,?,?,?,?,?,?,?,?,?)',
      [study.title, study.content, study.startDate,
       study.endDate, study.quantity, study.price, study.place,study.email,study.lat,study.lng],
      function(error, result) {
        if (error) {
          errorFn(error)
        } else {
          successFn(result)
        }
      }) //connection.query()
  }, //insert

  update(study, successFn, errorFn) {
    this.connection.query(
      'update study set title=?, dscp=?, sdt=?, edt=?, many=?, price=?, place=?, lat=?, lng=? where sno=?',
      [study.title, study.content, study.startDate, study.endDate, study.quantity,
      study.price, study.place, study.lat, study.lng, study.no],
      function(error, result) {
        if (error) {
          errorFn(error)
        } else {
          successFn(result)
        }
      }) //connection.query()
  }, //update()

  delete(no, successFn, errorFn) {
    this.connection.query(
      'delete from study where sno=?',
      [no],
      function(error, result) {
        if (error) {
          errorFn(error)
        } else {
          successFn(result)
        }
      })
  }//delete()



}//exports
