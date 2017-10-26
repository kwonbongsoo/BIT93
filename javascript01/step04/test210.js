/* 주제: 함수 - 연습
> node test21.js
--------------------------
prompt: command: list
[학생 성적 목록]
0: "홍길동1", 100, 90, 80, 270, 90
1: "홍길동2", 100, 90, 80, 270, 90
2: "홍길동3", 100, 90, 80, 270, 90
3: "홍길동4", 100, 90, 80, 270, 90
--------------------------
prompt: command: add
[학생 성적 입력]
prompt: name: 홍길동5
prompt: kor: 100
prompt: eng: 100
prompt: math: 100
성적
이름: 홍길동5
국어: 100
영어: 100
수학: 100
합계: 300
평균: 100
--------------------------
prompt: command: list
[학생 성적 목록]
0: "홍길동1", 100, 90, 80, 270, 90
1: "홍길동2", 100, 90, 80, 270, 90
2: "홍길동3", 100, 90, 80, 270, 90
3: "홍길동4", 100, 90, 80, 270, 90
4: "홍길동5", 100, 100, 100, 300, 100
--------------------------
prompt: command: delete
prompt: no: 2
"홍길동3"의 정보가 삭제되었습니다.
--------------------------
prompt: command: list
[학생 성적 목록]
0: "홍길동1", 100, 90, 80, 270, 90
1: "홍길동2", 100, 90, 80, 270, 90
2: "홍길동4", 100, 90, 80, 270, 90
3: "홍길동5", 100, 100, 100, 300, 100
--------------------------
prompt: command: quit
안녕히 가세요!
>
*/
"use strict"

var prompt = require('prompt');
prompt.start();
function studentInfo(select){
  if(select === "list"){
    console.log("[학생 성적 목록]");
    for (var i = 0;i < ar1.length; i++){
      var student = "";
      for( var j = 0; j < ar1[i].length;j++){
        student += ar1[i][j];
        if(j!=(ar1[i].length)-1)
          student += ", ";
      }
      console.log(i+": "+student);
    }
    init(a);
  }else if(select === "add"){
    console.log("[학생 성적 입력]");
    init("add");

  }else if(select === "quit"){
    console.log("안녕히 가세요!");
    return;
  }else if(select === "delete") {
    init("delete");
  }else {
    init(a);
  }
}
var sun = () => console.log("-------------------------------------");
function init(a){
  sun();
  if(a === undefined){
    var select;
    prompt.get(['command'],function(err,result){
      select = result.command;
      studentInfo(select);
    });
  }else if (a === "add"){
    console.log("성적");
    prompt.get(['이름','국어','영어','수학'],function(err,result){
      var name = '"';
      name += result.이름+'"';
      var kor = parseInt(result.국어);
      var eng = parseInt(result.영어);
      var math = parseInt(result.수학);
      ar1[ar1.length] = [name,kor,eng,math,kor+eng+math,(kor+eng+math)/3];
      console.log("합계: ",kor+eng+math);
      console.log("평균: ",(kor+eng+math)/3);
      studentInfo(select);
    });
  }else {
    prompt.get(['no'],function(err,result){
      select = result.no;
      console.log(ar1[select][0]+"님의 정보가 삭제되었습니다");
       ar1.splice(select,1);
       //함수로 하면됨

       /*
       for(var i = 0; i < ar1[select].length; i++){
         ar1[select][i] = ar1[ar1.length-1][i];
         ar1[ar1.length-1][i] = undefined;
       }
       ar1.length -= 1;
      // 삭제 시 맨뒤에껄 떙겨오는 코드*/

/*
       for(var i = 0; i < ar1[select].length; i++){
         if((select+1) < ar1.length){
           ar1[select][i] = ar1[select+1][i];
         }
        for(var i = 0; i< ar1[ar1.length-1].length; i++)
          ar1[ar1.length-1][i] = undefined;
        ar1.length -= 1;
       }
      // 새로 짜야함 하나씩땅겨오는코드*/

      studentInfo(select);
    });
  }

}
var a;
var ar1 = [['"홍길동1"', 100, 90, 80, 270, 90],
       ['"홍길동2"', 100, 90, 80, 270, 90],
       ['"홍길동3"', 100, 90, 80, 270, 90],
       ['"홍길동4"', 100, 90, 80, 270, 90]
     ];
     init(a);
