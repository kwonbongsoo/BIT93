var viewTags = $('.bit-view'),
    newTags = $('.bit-new'),
    fiNo = $('#fi-no'),
    fiEmail = $('#fi-email'),
    fiName = $('#fi-name'),
    fiTel = $('#fi-tel'),
    fiPassword = $('#fi-password'),
    fiHomepage = $('#fi-homepage'),
    fiFacebook = $('#fi-facebook'),
    fiTwitter = $('#fi-twitter')
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
      'password' : fiPassword.val(),
      'homepage' : fiHomepage.val(),
      'facebook' : fiFacebook.val(),
      'twitter' : fiTwitter.val()
    }, (result) => {
      alert('추가 되었습니다 ㄱㅇㄷ')
      location.href = 'index.html'
    }, 'json')
    //
  })
} else { //학생 정보 조회
  newTags.css('display', 'none')
  $.getJSON('detail.json', {'no' : no}, (result) => {
	var data = result.data
    fiNo.text(data.no)
    fiEmail.val(data.email)
    fiName.val(data.name)
    fiTel.val(data.tel)
    fiHomepage.val(data.homepage)
    fiFacebook.val(data.facebook)
    fiTwitter.val(data.twitter)
    
  })
  $('#add-btn').click(() => {
    $.post('add.json', {
      'email' : fiEmail.val(),
      'name' : fiName.val(),
      'tel' : fiTel.val(),
      'password' : fiPassword.val(),
      'homepage' : fiHomepage.val(),
      'facebook' : fiFacebook.val(),
      'twitter' : fiTwitter.val()
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
      'password' : fiPassword.val(),
      'homepage' : fiHomepage.val(),
      'facebook' : fiFacebook.val(),
      'twitter' : fiTwitter.val()
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

