<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>Write</title>
</head>
<body>
	<jsp:include page="../layout/header.jsp"></jsp:include>
	
	<section>
		<div class="container">
			<form action="/board/register" method="post" enctype="multipart/form-data">
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">title</label>
					<input type="text" class="form-control" name="title">
				</div>
				<div class="mb-3">
					<label for="exampleFormControlTextarea1" class="form-label">content</label>
					<textarea class="form-control" rows="3" name="content"></textarea>
				</div>
				<input type="hidden" name="writer" value="${session.nick_name }">
					
	 			<div class="col-12 d-grid">
	  				<input class="form-control" type="file" style="display: none;" id="files" name="files" multiple>
	  				<button type="button" id="trigger" class="btn btn-outline-primary btn-block d-block">Files Upload</button>
				</div>		
				<div class="col-12" id="fileZone"></div>
				
				<br>
				
				<div class="mb-3">
					<button type="submit" class="btn btn-primary mb-3">Write</button>
				</div>
			</form>
		</div>
	</section>

	<script type="text/javascript" src="/resources/javascript/file.js"></script>
	<jsp:include page="../layout/footer.jsp"></jsp:include>
</body>
</html>
