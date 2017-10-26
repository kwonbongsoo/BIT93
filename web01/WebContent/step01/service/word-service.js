"use strict"

module.exports = {
  setWordDao(dao) {
    this.wordDao = dao
  },


  list(success, error) {
    this.wordDao.selectList( function(word) {
      success(word)
    }, error)
  }//list()

} // exports
