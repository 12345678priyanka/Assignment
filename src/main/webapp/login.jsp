<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	

	<title>Login</title>
	<h2>Login Page</h2>
	<form id="loginForm" method="post" action="LoginServlet">
        <label for="loginId">Login ID:</label>
        <input type="text" id="loginId" name="loginId" required><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br>

        <input type="submit" value="Login">
    </form>

    <div id="loginResult"></div>

    <!-- Add any necessary JavaScript imports and scripts here -->
    <script src="path/to/login.js"></script>
</body>
</html>
	