<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<ul class="list-group">
	<c:forEach items="${fileList }" var="fvo">
		<li class="list-group-item">
			<c:choose>
				<c:when test="${fvo.file_type > 0 }">
					<img src="/upload/${fn:replace(fvo.save_dir, '\\', '/')}/${fvo.uuid}_th_${fvo.file_name}">
					<button type="button" data-uuid="${fvo.uuid }" class="btn btn-sm btn-danger py-0 file-x" onclick="file_remove(this)">X</button>
				</c:when>
			</c:choose>
		</li>
	</c:forEach>
</ul>