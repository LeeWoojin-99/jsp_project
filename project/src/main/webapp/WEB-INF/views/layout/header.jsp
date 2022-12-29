<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	
	<!-- Bootstrap -->
	<!-- CSS only -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
	<!-- JavaScript Bundle with Popper -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</head>
<body>

	<header>
		<ul class="nav justify-content-center">
			<li class="nav-item"><a class="nav-link" href="/">Home</a></li>
			<li class="nav-item"><a class="nav-link" href="/main">Main</a></li>
			<c:if test="${session eq null }">
				<li class="nav-item"><a class="nav-link" href="/member/register">Register</a></li>
				<li class="nav-item"><a class="nav-link" href="/member/login">Login</a></li>
			</c:if>
			<c:if test="${session ne null }">
				<li class="nav-item"><a class="nav-link" href="/board/register">Write</a></li>
				<li class="nav-item"><a class="nav-link" href="/board/list">List</a></li>
			</c:if>
		</ul>
	</header>


</body>
</html>