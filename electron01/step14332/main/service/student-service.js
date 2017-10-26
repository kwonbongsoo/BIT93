"use strict"
module.exports = {
  setStudentDao(dao) {
    this.studentDao = dao
  },

  setMemberDao(dao) {
    this.memberDao = dao
  },
  list(pageNo, success, error) {
    this.studentDao.selectList(pageNo, function(students) {
      this.studentDao.countAll(function(result) {
        success(students, result[0].cnt)
      }, error)
    }, error)
  },//list
  detail(no, success, error) {
    this.studentDao.selectOne(no, success, error)
  },//detail
  insert(student, success, error) {
    memberDao.insert(student, function(result) {
      student.no = result.insertId
      this.studentDao.insert(student, success, error)
    }, error)
  }, // insert
  update(student, success, error) {
    this.memberDao.update(student, function(result) {
      this.studentDao.update(student, success, error)
    }, error)
  }, //update
  delete(no, success, error) {
    this.studentDao.delete(no, function(result) {
      this.memberDao.delete(no, success, error)
    }, error)
  } //delete
}
