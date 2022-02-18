// 회원탈퇴 확인 confirm


function confirm_joinout() {
	if (confirm('정말로 탈퇴하시겠습니까?')) {
		location.href='/pages/MemberJoinOut.us';
		
	} else {
		
	}
}

function confirm_backlist(post_id) {
	if (confirm('작성 중인 게시글이 삭제됩니다')) {
		alert(post_id)
		location.href="/pages/cssDelete.do?post_id="+post_id;
		
	} else {
		
	}
}

function alert_boardwrite() {
	alert("게시글 작성 완료")
}
