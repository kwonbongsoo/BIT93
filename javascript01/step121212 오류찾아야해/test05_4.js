/* 템플릿 엔진 사용하기 - 외부에서 템플릿 소스를 가져오기 II
=> 템플릿 엔진 적용

*/

"use strict"

const fs = require('fs')
const path = require('path')
const handlebars = require('handlebars')

var templatePath = path.join(__dirname, 'test05_3_template.txt')
var data = {
  name: '홍길동'
}

fs.readFile(templatePath,'utf-8', (err, src) => {
  if(err) throw error

  var template = handlebars.compile(src)
  var result = template(data)
  console.log(result)
})
