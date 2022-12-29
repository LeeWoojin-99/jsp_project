<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>Log in</title>
</head>
<body>
	<jsp:include page="../layout/header.jsp"></jsp:include>
	
	<section>
		<div class="container">
			<form action="/member/login" method="post">
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">ID</label>
					<input type="text" class="form-control" name="id">
				</div>
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">Password</label>
					<input type="text" class="form-control" name="pw">
				</div>
				<div class="mb-3">
					<button type="submit" class="btn btn-primary mb-3">Log in</button>
				</div>
			</form>
		</div>
	</section>

	<jsp:include page="../layout/footer.jsp"></jsp:include>
</body>
</html>
