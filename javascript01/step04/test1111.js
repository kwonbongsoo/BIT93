
"use strict"

let prompt = require('prompt');
prompt.start();
var sun = function (){ console.log('--------------------------------------')}
var arr = [['홍길동1', 100, 100, 100, 300, 100],
              ['홍길동2', 100, 100, 100, 300, 100],
              ['홍길동3', 100, 100, 100, 300, 100],
              ['홍길동4', 100, 100, 100, 300, 100],
              ['홍길동5', 100, 100, 100, 300, 100]
              ];
function init() {
  prompt.get(['command'],function(err,result){
    sun();
    switch(result.command){
      case 'list':
        doList()
        return
      case 'add':
        doAdd()
        return;
      case 'quit':
        console.log('bye')
        return
      case 'delete':
        doDelete()
        return
      default:doDefault()
        return
    }
  });
}
init()
function doList() {
  for (var student of arr)
    console.log(student)
    init();
}
function doAdd() {
  prompt.get(['name', 'kor', 'eng', 'math'],function(err,result){
    var sum , avg;
    sum = parseInt(result.kor) +parseInt(result.eng) + parseInt(result.math)
    avg = sum / 3
    arr[arr.length] = [result.name,
               parseInt(result.kor),
               parseInt(result.math),
               parseInt(result.eng),
                       sum,
                       avg         ];
    console.log("등록 완료")
      init();
  });
}
function doDelete() {
  prompt.get(['no'],function(err,result){
    if(result.no >= arr.length){
      console.log('존재 하지 않는 인덱스')
    }else {
      arr.splice(parseInt(result.no),1);
      console.log('삭제 완료')
    }
    init();
  });
}
function doDefault() {
  console.log('지원하지 않는 명령입니다')
  init();
}
