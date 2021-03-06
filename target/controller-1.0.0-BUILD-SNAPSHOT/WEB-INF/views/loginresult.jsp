<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${result eq -1}">
	<script>
		alert("존재하지 않는 아이디 입니다. \n확인 후 다시 입력해 주세요.");
		history.back();
	</script>
</c:if>

<c:if test="${result eq 0}">
	<script>
		alert("비밀번호가 일치하지 않습니다. \n확인 후 다시 입력해 주세요.");
		history.back();
	</script>
</c:if>

<c:if test="${result eq 1}">
	login 성공시 session에 userid를 넣는다.
	<c:set var="userInfo" value="${userInfo}" scope="session"/>
	<c:redirect url="/" />
</c:if>