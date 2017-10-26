/* 템플릿 엔진 사용하기 - 배열 데이터 처리
=> 템플릿 문법
{{#list 배열프로퍼티명}}
...
{{/each}
*/

"use strict"

const handlebars = require('handlebars')

var str = '{{#each students}}\
{{no}} {{name}}, {{email}}\n \
{{/each}}\
'
var data = {
  students: [
    {no: 1, name: '홍길동1', email: 'hong1@test.com'},
    {no: 2, name: '홍길동2', email: 'hong2@test.com'},
    {no: 3, name: '홍길동3', email: 'hong3@test.com'},
    {no: 4, name: '홍길동4', email: 'hong4@test.com'},
  ]
}

//1) 템플릿 엔진을 이용하여 소스를 변환 할 변환 함수를 준비한다.

var template = handlebars.compile(str)

//2) 템플릿 엔진으로부터 리턴 받은 함수에게 데이터를 전달한다.
//=> 템플릿 소스에 데이터가 적용된 결과 문자열을 얻는다.
var result = template(data)
console.log(result)
