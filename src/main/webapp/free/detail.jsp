<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../asset/js/jquery-3.6.1.min.js"></script>
<script>
	$(document).ready(
			function() {

				$('#btn_edit').click(
						function(event) {
							$('#frm_edit').attr('action',
									'${contextPath}/BoardProject/edit.do');
							$('#frm_edit').submit();
						})

				$('#btn_list').click(function(event) {
					location.href = '${contextPath}/BoardProject/list.do';
				});

			});
</script>
</head>
<body>
	<form id="frm_edit"  method="POST">
		<div>게시글번호 ${free.freeNo}</div>
		<div>작성자 ${free.writer}</div>
		<div>작성IP ${free.ip}</div>
		<div>조회수 ${free.hit}</div>
		<div>제목<input type="text" id="title" name="title" placeholder="워크샵공지"></div>
		<textarea rows="2" cols="20" placeholder="첨부파일을 확인해주세요"></textarea>

		<div>
			<input type="button" value="수정" id="btn_edit"> <input
				type="button" value="목록" id="btn_list">
		</div>
	</form>
</body>
</html>