

"use strict"

var student = [
  {name: "홍길동1", kor: 100, eng: 100, math: 100, sum: 300, aver: 100},
  {name: "홍길동2", kor: 90, eng: 90, math: 90, sum: 270, aver: 90},
  {name: "홍길동3", kor: 80, eng: 80, math: 80, sum: 240, aver: 80},
  {name: "홍길동4", kor: 70, eng: 70, math: 70, sum: 210, aver: 70},
  {name: "홍길동5", kor: 60, eng: 60, math: 60, sum: 180, aver: 60}
]

// student += [{name: "홍길동6", kor: 60, eng: 60, math: 60, sum: 180, aver: 60}]
var key
for (key of student)
  console.log(key)
