var prompt = require('prompt')

var studentList = [
  ['홍길동1', 100, 100, 100, 300, 100],
  ['홍길동2', 90, 90, 90, 270, 90],
  ['홍길동3', 80, 80, 80, 240, 80],
  ['홍길동4', 70, 70, 70, 210, 70],
  ['홍길동5', 60, 60, 60, 180, 60]
]

prompt.start()
init()
function init() {
  prompt.get(['command'], function(err, result) {
    switch(result.command){
      case 'quit':
        return
      case 'list':
        for (var key of studentList){
          console.log(key)
        }
        break
      case 'add':prompt.get(['name', 'kor', 'eng', 'math'],function(err, result) {
        let sum = parseInt(result.kor) + parseInt(result.eng) + parseInt(result.math)
        var student = [result.name,
                  parseInt(result.kor),
                  parseInt(result.eng),
                  parseInt(result.math),
                  sum,
                  sum / 3
                ]
        studentList[studentList.length] = student
        init()
      })
        return
      case 'delete':
        prompt.get(['no'],function(err, result) {
          if(studentList.length == 0) {
            console.log('삭제할 항목이 없습니다')
             init()
             return
          }
          if(studentList.length <= result.no || result.no < 0) {
            console.log('존재하지 않는 인덱스입니다')
            init()
          }
          studentList.splice(result.no, 1)
          console.log('삭제완료')
          init()
        })
        return
      default:
        console.log('잘못입력하셨어요')
    }
    init()
  })
}
