<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Customer Details></title>
</head>
<body>
	<h1>Customer Details></h1>
    <%-- Retrieve customer details from request attribute --%>
    <c:if test="${not empty customer}">
        <table border="1">
            <tr>
                <th>First Name:</th>
                <td>${customer.firstName}</td>
            </tr>
            <tr>
                <th>Last Name:</th>
                <td>${customer.lastName}</td>
            </tr>
            <tr>
                <th>Street:</th>
                <td>${customer.street}</td>
            </tr>
            <tr>
                <th>Address:</th>
                <td>${customer.address}</td>
            </tr>
            <tr>
                <th>City:</th>
                <td>${customer.city}</td>
            </tr>
            <tr>
                <th>State:</th>
                <td>${customer.state}</td>
            </tr>
            <tr>
                <th>Email:</th>
                <td>${customer.email}</td>
            </tr>
            <tr>
                <th>Phone:</th>
                <td>${customer.phone}</td>
            </tr>
        </table>
    </c:if>

</body>
</html>
</body>
</html>