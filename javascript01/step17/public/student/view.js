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
    $.post('add.json', {
      'email' : fiEmail.val(),
      'name' : fiName.val(),
      'tel' : fiTel.val(),
      'schoolName' : fiSchoolName.val(),
      'working' : (fiWorking.prop('checked') ? 'Y' : 'N')
    }, (result) => {
      alert('추가 되었습니다 ㄱㅇㄷ')
      location.href = 'index.html'
    }, 'json')
    //
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
  })
  $('#add-btn').click(() => {
    $.post('add.json', {
      'email' : fiEmail.val(),
      'name' : fiName.val(),
      'tel' : fiTel.val(),
      'schoolName' : fiSchoolName.val(),
      'working' : (fiWorking.prop('checked') ? 'Y' : 'N')
    }, (result) => {
      alert('추가 되었습니다 ㄱㅇㄷ')
      location.href = 'index.html'
    }, 'json')
    //
  })

  $('#upd-btn').click(() => {
    $.post('update.json', {
      'no' : fiNo.text(),
      'email' : fiEmail.val(),
      'name' : fiName.val(),
      'tel' : fiTel.val(),
      'schoolName' : fiSchoolName.val(),
      'working' : (fiWorking.prop('checked') ? 'Y' : 'N')
    }, (result) => {
      alert('변경 되었습니다 ㄱㅇㄷ')
      location.href = 'index.html'
    }, 'json')
  })

  $('#del-btn').click(() => {
    $.getJSON('delete.json', {'no' : no}, (result) => {
      alert('삭제함 ㄱㅇㄷ')
      location.href = 'index.html'
    })
  })
}
