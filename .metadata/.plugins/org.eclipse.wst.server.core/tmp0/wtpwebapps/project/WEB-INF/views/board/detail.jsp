<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>Detail</title>
</head>
<body>
	<jsp:include page="../layout/header.jsp"></jsp:include>
	
	<section>
		<div class="container">
			<table class="table table-bordered border-primary">
				<tbody>
					<tr>
						<th scope="col">title</th>
						<td>${bvo.title }</td>
					</tr>
					<tr>
						<th scope="col">writer</th>
						<td>${bvo.writer }</td>
					</tr>
					<tr>
						<th scope="col">reg_date</th>
						<td>${bvo.reg_date }</td>
					</tr>
					<tr>
						<th scope="col">content</th>
						<td>${bvo.content }</td>
					</tr>
				</tbody>
			</table>
		
			<div class="btn-group">
				<a href="/board/modify?bno=${bvo.bno }" class="btn btn-primary">modify</a>
				<a href="/board/delete?bno=${bvo.bno }" class="btn btn-primary">delete</a>
			</div>
			
			<div id="comment_area">
				<br>
				<div class="container" id="comment_post_area">
					writer : <label class="form-label writer">${session.nick_name}</label>
					<input type="text" class="form-control">
					<button type="button" class="btn btn-primary" id="comment_post_btn">댓글 쓰기</button>
				</div>
				<br>
				<ul class="list-group" id="comments">
					<li class="list-group-item comment" data-cno="1">
						writer : <span class="writer">홍길동</span> <br>
						mod_date : <span class="mod_date">2022...</span>
						<input type="text" class="form-control content" value="value...">
						<div class="btn-group" role="group">
							<button type="button" class="btn btn-primary comment_modify">modify</button>
							<button type="button" class="btn btn-primary comment_remove">remove</button>
						</div>
					</li>
					<li class="list-group-item comment" data-cno="1">
						writer : <span class="writer">홍길동</span> <br>
						mod_date : <span class="mod_date">2022...</span>
						<input type="text" class="form-control content" value="value...">
						<br>
						<div class="btn-group" role="group">
							<button type="button" class="btn btn-primary comment_modify">modify</button>
							<button type="button" class="btn btn-primary comment_remove">remove</button>
						</div>
					</li>
					<li class="list-group-item">A third item</li>
					<li class="list-group-item">A fourth item</li>
					<li class="list-group-item">And a fifth one</li>
				</ul>
			</div>
			<br>
			<jsp:include page="./file.jsp"></jsp:include>

		</div>
	</section>
	

	<script type="text/javascript" src="/resources/javascript/comment.js"></script>
	<script type="text/javascript">
		bnoVal = "<c:out value='${bvo.bno}'/>";
		commentList(bnoVal);
	</script>
	
	<script type="text/javascript" src="/resources/javascript/file_remove.js"></script>
	<jsp:include page="../layout/footer.jsp"></jsp:include>
</body>
</html>
