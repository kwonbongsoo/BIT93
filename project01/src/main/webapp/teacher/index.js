//서버에서 학생 목록 데이터를 받아 온다.
var pageNoTag = $('#page-no'),
    tbody = $('#teacher-tbl > tbody'),
    prevBtn = $('#prev-btn'),
    nextBtn = $('#next-btn'),
    pageSize = 10;

var currPageNo = parseInt(pageNoTag.text())
// 이벤트 핸들러 등록
$(document.body).on('click', '.detail-link', function(event) {
  location.href = 'view.html?no=' + $(this).attr('data-no') 
  event.preventDefault()
})
prevBtn.click(() => {
	  displayList(currPageNo - 1)
	})
	nextBtn.click(() => {
	  displayList(currPageNo + 1)
	})



function displayList(pageNo) {
  $.getJSON('list.json', {'pageNo': pageNo, 'pageSize': pageSize}, (result) => {
    // var obj = JSON.parse(result)// 서버에서 받은 문자열을 객체로 만드는 함수
    // console.log(obj) //'text'로 했을때...
    //문자열을 더하면 있는그대로 표현해준다.

    //json으로 했을때
    //json을 생략해도 가능하다
    // console.log(result)

    // 새로함
    var list = result.data.list
    var totalCount = result.data.totalCount
    var lastPageNo = parseInt(totalCount / pageSize) + (totalCount % pageSize > 0 ? 1 : 0)
    // 템플릿 소스를 가지고 템플릿을 처리할 함수를 얻는다.
    var templateFn = Handlebars.compile($('#tbody-template').text())
    var generatedHTML = templateFn(result.data) //템플릿 함수에 데이터를 넣고 HTML을 생성한다.
    tbody.text('') //tbody의 기존 tr 태그들을 지우고
    tbody.html(generatedHTML) // 새 tr 태그들로 설정한다.

    

    currPageNo = pageNo
    pageNoTag.text(currPageNo)

    if (currPageNo == 1) {
      prevBtn.prop('disabled', true)
    } else {
      prevBtn.prop('disabled', false)
    }

    if(currPageNo == lastPageNo) {
      nextBtn.prop('disabled', true)
    } else {
      nextBtn.prop('disabled', false)
    }
  })//'json')//'text')//비동기 요청이다 getJSON

} //displayList
//'json'을 생략해도되는경우는 Content-type을 명확하게 해줬을때만 생략이가능하다.
// 써주는게 더 좋은 방법이다. 받을때 콘텐트 타입을 잘못보낼수도 있기때문에
//getJSON은 타입을 JSON으로 자동 으로 변환해준다.

displayList(1)

