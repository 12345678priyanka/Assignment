<%@ page language="java" contentType="text/html; charset=UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Customer List</title>
</head>
<body>
	<h2>Customer List</h2>
	<table>
	<thead>
		<tr>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Address</th>
		<th>City</th>
		<th>State</th>
		<th>Email</th>
		<th>Phone</th>
		</tr>
	</thead>	
	<tbody>
		<!-- Use JSTL or other Java code to iterate over customer data -->
            <c:forEach var="customer" items="${customerList}">
		<tr>
			<td>${customer.getFirstName}</td>
			<td>${customer.getLastName}</td>
			<td>${customer.getAddress}</td>
			<td>${customer.getCity}</td>
			<td>${customer.getState}</td>
			<td>${customer.getEmail}</td>
			<td>${customer.getPhone}</td>
		</tr>
		 </c:forEach>
	</tbody>
</table>
</body>
</html>