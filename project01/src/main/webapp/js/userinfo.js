// 로그인 사용자 정보를 가져온다.


  $.getJSON(contextRoot + '/auth/userinfo.json', (result) => {
	  if (result.data) {
		  $('#login').append($("<span>").html(result.data.name + '(' + result.data.email + ')'))
		  			   .append($("<a>").attr('id', "logout-link").attr('href', '#').text('로그아웃'))
	  }
  })//'json')//'text')//비동기 요청이다 getJSON

  $(document.body).on('click', '#logout-link', (event)=> {
	  $.getJSON(contextRoot + "/auth/logout.json", (result) => {
			location.href = contextRoot + "/teacher/index.html"
		  })
  })
