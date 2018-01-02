<%@ page language="java" import="java.util.*,com.stu.model.*;"	pageEncoding="gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="msg" value="${requestScope.msg}"/>
<c:if test="${not empty msg}">	
	<script type="text/javascript">
		alert('${msg.content}');
	</script>
</c:if>