/* 주제:함수 -함수 호출 동기 방식과 비동기 방식
 동기 방식 호출
 - 일반적으로 대부분의 함수가 동기 방식의 호출이다.
 - 즉 함수 실행이 완료될 때 까지 블로킹이 걸려 있다.
   다음 명령을 실행하지 않는다.
- 함수에서 무한 루프에 빠지면 더 이상 실행할 수 없는 상태가 될 수 있다.
- 함수에서 시간이 오래 걸리면 다음 실행이 오랫동안 지연되는 문제가 발생

비동기 방식 호출
- 서버나 통신이나 파일 입.출력 부분에서 사용된다.
- 함수 실행을 시킨 후, 함수가 작업을 끝날 때 까지 기다리지 않고
  즉시 다음 명령문을 실행하는 방식이다.

*/
"use strict"


var prompt = require('prompt');
prompt.start();//프롬프트시작




function start(){
  menu();
  var choice
  prompt.get(['choice'],function(err,result){
     choice = parseInt(result.choice);
     switchSelect(choice);

  });
}

function menu() {
  console.log("=======================");
  console.log("1.학생 등록");
  console.log("2.학생 검색");
  console.log("3.학생 삭제");
  console.log("0. 종료");
  console.log("=======================");
}
function switchSelect(choice){
  switch(choice){
    case 0:break;
    case 1:console.log("학생 등록 함수만들기");count++;break;
    case 2:console.log("학생 검색 함수만들기");break;
    case 3:console.log("학생 삭제 함수만들기");break;
    default:console.log("잘못입력");
    start();
  }
}
var a1 = [["",0,0,0,0,0],];
var count = 0;
start();
