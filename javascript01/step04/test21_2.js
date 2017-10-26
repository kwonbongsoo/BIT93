/* 주제:함수 - 연습

-------------------------------------------
prompt: command: list
[학생 성적 목록]
"홍길동1", 100, 90 , 80, 90, 270, 90
"홍길동2", 100, 90 , 80, 90, 270, 90
"홍길동3", 100, 90 , 80, 90, 270, 90
"홍길동4", 100, 90 , 80, 90, 270, 90

prompt: command: add
[학생 성적 입력]
prompt:name: 홍길동
prompt:kor: 100
prompt:eng: 100
prompt:math: 100

성적
이름: 홍길동5
국어: 100
영어: 100
수학: 100
합계: 300
평균: 100

-------------------------------------------
prompt: command: list
[학생 성적 목록]
0: "홍길동1", 100, 90 , 80, 90, 270, 90
1: "홍길동2", 100, 90 , 80, 90, 270, 90
2: "홍길동3", 100, 90 , 80, 90, 270, 90
3: "홍길동4", 100, 90 , 80, 90, 270, 90
4: "홍길동5", 100, 100, 100, 100, 100, 100

prompt: command: delete
prompt: no: 2
"홍길동3"의 정보가 삭제 되었습니다.

-------------------------------------------
prompt: command: list
[학생 성적 목록]
0: "홍길동1", 100, 90 , 80, 90, 270, 90
1: "홍길동2", 100, 90 , 80, 90, 270, 90
2: "홍길동4", 100, 90 , 80, 90, 270, 90
3: "홍길동5", 100, 100, 100, 100, 100, 100

prompt: command: quit
안녕히 가세요!
*/
"use strict"
var prompt = require('prompt')
prompt.start()

inputCommand()

function inputCommand(){
  prompt.get(['command'],function(err,result){
    if(result.comman == 'quit')
      return; //함수 실행을 끝낸다.
    console.log(result.command);
    inputCommand();
  })
}
