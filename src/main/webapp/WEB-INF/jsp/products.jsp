<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Products</title>

</head>
<body>
	<p>You see, if there are products</p>
	<div>
		<c:forEach var="product" items="${products}">
			
		</c:forEach>
		</div>
</body>
</html>