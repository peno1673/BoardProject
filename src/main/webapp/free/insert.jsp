<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../asset/js/jquery-3.6.1.min.js"></script>
<script>
	$(document).ready(function(){
		
		 $('#btn_add').click(function(event){
			 $('#frm_insert').attr('action', '${contextPath}/BoardProject/add.do');
			 $('#frm_insert').submit();
		}) 
		
		$('#btn_list').click(function(event){
			location.href = '${contextPath}/BoardProject/list.do';
		});
		
	});
</script>
</head>
<body>
	<h1>자유 로운 게시글 작성 화면</h1>
	<div>
		<form id="frm_insert"  method="POST">
			<div>
				<input type="text" id="writer" name="writer" placeholder="작성자">
			</div>
			<div>
				<input type="text" id="title" name="title" placeholder="제목">
			</div>
			<div>
				<input type="text" id="content" name="content" placeholder="내용">
			</div>
			<div>
				<input type="button" value="작성완료" id="btn_add">
				<input type="reset" value="다시작성">
				<input type="button" value="목록" id="btn_list">
			</div>
		</form>
	</div>
</body>
</html>