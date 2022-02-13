// id 중복체크	
function checkId(user_id) {
	let xhr = new XMLHttpRequest();
	xhr.open("GET", "idcheck.jsp?user_id=" + user_id, true);
	xhr.send();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == XMLHttpRequest.DONE && xhr.status == 200) {
			if (xhr.responseText.trim() == "ok") {
				$("#alert_pop").click(function () { 
					Swal.fire({ icon: 'success', 
						title: '사용 가능한 아이디입니다.', 
						text: '',
		              }); 
		           });
			} else if(xhr.responseText.trim() == "not-ok") {
				$("#alert_pop").click(function () { 
		                 Swal.fire({ icon: 'error', // Alert 타입
		                	 title: '이미 사용중인 아이디입니다.', // Alert 제목 
		                	 text: '', // Alert 내용
		              }); 
		           });
			}

		}
	}
}
