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
<spring-form:form  class="form">
<section class="container-fluid p-4">
	<c:choose>
		<c:when test="${products == null || products.isEmpty() }">
			<p class="well well-info">No products Found!</p>
		</c:when>
		<c:otherwise>
			<table class="table table-striped table-hover table-border">
				<tr>
					<th>Product Id</th>
					<th>Product Name</th>
					<th>Product Cost</th>
					<th>Product Description</th>
					<th>Action</th>
				</tr>
				<c:forEach items="${products }" var="product">
				<spring-form:form  class="form" action="${pageContext.request.contextPath}/user/add-to-cart" method="POST" modelAttribute="product">
					<tr>
						<td>${product.id }</td>
						<td>${product.productName }</td>
						<td>${product.cost }</td>
						<td>${product.productDescription }</td>
						<td>
							<button class="btn btn-sm btn-danger">Add Product</button>
						</td>
					</tr>
				</spring-form:form>
				</c:forEach>
			</table>
			<a class="btn btn-sm btn-danger" href="${pageContext.request.contextPath}/user/show-kit">Show Cart</a>
		</c:otherwise>
	</c:choose>
	</section>
</spring-form:form>
</body>
</html>