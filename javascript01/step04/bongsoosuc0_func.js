"use strict"
var {get, start} = require('prompt')
var {studentList} = require('./bongsoosuc0_array.js')
module.exports = {
   inputCommand() {
    get(['command'],function(err, result) {
      switch(result.command){
        case 'quit':
          doQuit()
          return
        case 'list':
          doList()
          return
        case 'add':
          doAdd()
          return
        case 'delete':
          doDelete()
          return
        default:
          doDefault()
          return
      }
    })
  }
}

function doList() {
 var student =''
 console.log('[학생 성적 목록]')
 for (var i = 0; i < studentList.length; i++){
   student = i+': "'
   for (var j = 0; j < studentList[i].length; j++){
     student += studentList[i][j]
     if(j == 0)
       student += '"'
     if(j <  studentList[i].length -1)
       student += ', '
   }
   console.log(student)
 }
 inputCommand()
}

function inputCommand() {
 get(['command'],function(err, result) {
   switch(result.command){
     case 'quit':
       doQuit()
       return
     case 'list':
       doList()
       return
     case 'add':
       doAdd()
       return
     case 'delete':
       doDelete()
       return
     default:
       doDefault()
       return
   }

 })
}
function doAdd() {
 get(['name', 'kor', 'eng', 'math'], function(err, result) {
   let sum, avg
   sum = parseInt(result.kor) + parseInt(result.eng) + parseInt(result.math)
   avg = sum / 3

   studentList[studentList.length] = [
                 result.name,
                 parseInt(result.kor),
                 parseInt(result.eng),
                 parseInt(result.math),
                 sum,
                 avg
               ]
   console.log('성적')
   console.log('이름: ' + result.name)
   console.log('국어: ' + parseInt(result.kor))
   console.log('영어: ' + parseInt(result.eng))
   console.log('수학: ' + parseInt(result.math))
   console.log('합계: ' + sum)
   console.log('평균: ' + avg)
   inputCommand()
 })
}
function doDelete() {
 get(['number'], function(err, result) {
   var number = parseInt(result.number)

   if(number < 0 || number >= studentList.length)
     console.log('잘못된 인덱스')
   else{
     for (var i = number; i < studentList.length; i++) {
       for( var j = 0; j < studentList[i].length; j++) {
         if(i < studentList.length-1)
           studentList[i][j] = studentList[i+1][j]
       }
     }
     if(studentList.length > 0)
       studentList.length -= 1
   }
   /*
   console.log(studentList.length)
   console.log(studentList[3][0])
   렝스를 1줄이는것만으로 배열이 삭제가 되는지 확인하는 코드
   일단 되는것으로 판단됨
   */
   inputCommand()
 })
}

function doQuit() {
 console.log('종료')
}
function doDefault() {
 console.log('잘못입력')
 inputCommand()
}
