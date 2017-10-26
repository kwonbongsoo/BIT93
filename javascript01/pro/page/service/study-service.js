"use strict"

module.exports = {
  setStudyDao(dao) {
    this.studyDao = dao
  },

  list(pageNo, pageSize, success, error) {
    var obj = this
    this.studyDao.selectList(pageNo, pageSize, function(studies) {
      obj.studyDao.countAll(function(result) {
        success(studies, result[0].cnt)
      }, error)
    }, error)
  },//list()

  search(pageNo, pageSize, searchValue, success, error) {
    var obj = this
    this.studyDao.search(pageNo, pageSize,searchValue, function(studies) {
      obj.studyDao.searchCountAll(searchValue, function(result) {
        success(studies, result[0].cnt)
      }, error)
    }, error)
  },//list()

  detail(no, success, error) {
    this.studyDao.selectOne(no, success, error)
  },//detail()

  insert(lecture, success, error) {
    this.studyDao.insert(lecture, success, error)
  },//insert()

  update(lecture, success, error) {
    this.studyDao.update(lecture, success, error)
  }, // update()

  delete(no, success, error) {
    this.studyDao.delete(no, success, error)
  } // delete()
} // exports
