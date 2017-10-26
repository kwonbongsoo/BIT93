

"use strict"

var studentArr = [
  {name: "홍길동1", kor: 100, eng: 100, math: 100, sum: 300, aver: 100},
  {name: "홍길동2", kor: 90, eng: 90, math: 90, sum: 270, aver: 90},
  {name: "홍길동3", kor: 80, eng: 80, math: 80, sum: 240, aver: 80},
  {name: "홍길동4", kor: 70, eng: 70, math: 70, sum: 210, aver: 70},
  {name: "홍길동5", kor: 60, eng: 60, math: 60, sum: 180, aver: 60}
]



function StudentFunc() {

  function doDelete() {

  }
  function doAdd() {
    prompt.get(['name','kor', 'eng', 'math'],function(err,result){
      student = CreateScore(result.name, result.kor, result.eng, result.math)
      console.log('등록 완료')
      init()
    });
  }
function doList() {
    for (student of student)
      console.log(student)
    init()
  }
function init() {
    prompt.get(['command'],function(err,result){
      switch(result.command){
        case 'list':
          return;
        case 'add':
          return;
        case 'delete':
          return;
        case 'default':
          return;
      }
    });

  }
function CreateStudent(name, kor, eng, math) {
      return {
        name: name,
        kor: kor,
        eng: eng,
        math: math,
        sum: kor + eng + math,
        aver: (kor + eng + math) / 3
      }
    }
}
var key
for (key of studentArr)
  console.log(key)

StudentFunc.init()
