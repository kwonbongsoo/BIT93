"use strict"

module.exports = {
  setConnection(con) {
    this.connection = con
  },

  selectList(successFn, errorFn) {
    this.connection.query(
      'select word from word',
      function(error, results) {
        if (error) {
          errorFn(error)
        } else {
          successFn(results)
        }
      }) // connection.query()
  }//selectList()

}//exports
