var viewTags = $('.bit-view'),
    newTags = $('.bit-new'),
    fiNo = $('#fi-no'),
    fiEmail = $('#fi-email'),
    fiName = $('#fi-name'),
    fiTel = $('#fi-tel'),
    fiSchoolName = $('#fi-school-name'),
    fiWorking = $('#fi-working')
var no = 0
// console.log(location.href.split('?')[1].split('=')[1])
try {
  no = location.href.split('?')[1].split('=')[1]
} catch (err) {

}
if (no == 0) { //새 학생 등록
  viewTags.css('display', 'none')

  $('#add-btn').click(() => {
    $.post('add.json', studendAddUpdateObj(), (result) => {
      alert('추가 되었습니다 ㄱㅇㄷ')
      location.href = 'index.html'
    }, 'json')
  })
} else { //학생 정보 조회
  newTags.css('display', 'none')
  $.getJSON('detail.json', {'no' : no}, (result) => {

    fiNo.text(result.mno)
    fiEmail.val(result.email)
    fiName.val(result.name)
    fiTel.val(result.tel)
    fiSchoolName.val(result.schl_nm)
    fiWorking.prop('checked', (result.work == 'Y' ? true : false))
  }, 'json')

  $('#del-btn').click(() => {
    $.getJSON('delete.json', {'no' : no}, (result) => {
      location.href = 'index.html'
    })
  })

  $('#upd-btn').click(() => {
    $.post('update.json', studendAddUpdateObj(), (result) => {
      alert('변경 성공 개이득')
      location.href = 'index.html'
    } , 'json') //json 형식이라고 안줘도 가능하다
  })
}
function studendAddUpdateObj() { //학생 등록 업데이트 객체 함수
  return {
    'no' : fiNo.text(),
    'email' : fiEmail.val(),
    'name' : fiName.val(),
    'tel' : fiTel.val(),
    'schoolName' : fiSchoolName.val(),
    'working' : (fiWorking.prop('checked') ? 'Y' : 'N')
  }
}
