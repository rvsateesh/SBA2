<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %> 
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="spring-form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<nav>
	<jsp:include page="${pageContext.request.contextPath}/header" />
</nav>
<section class="container-fluid p-4">
	<c:choose>
		<c:when test="${kit == null || kit.isEmpty() }">
			<p class="well well-info">No products Found!</p>
		</c:when>
		<c:otherwise>
			<table class="table table-striped table-hover table-border">
				<tr>
					<th>Kit Id</th>
					<th>Kit CoronaKitId</th>
					<th>Kit ProductId</th>
					<th>Kit Quantity</th>
					<th>Kit Amount</th>
				</tr>
				<c:forEach items="${kit }" var="kit">
					<tr>
						<td>${kit.id }</td>
						<td>${kit.coronaKitId }</td>
						<td>${kit.productId }</td>
						<td><input type="number" name="quantity" value="${kit.quantity }"></td>
						<td>${kit.amount }</td>
				</c:forEach>
			</table>
			<button class="btn btn-sm btn-danger" >Show Summary</button>
		</c:otherwise>
	</c:choose>
	</section>
</body>
</html>