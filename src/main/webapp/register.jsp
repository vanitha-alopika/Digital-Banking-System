<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Account</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>


<div class="card">
    <h2>Create New Account</h2>


<form action="register" method="post">
    <input type="text" name="name" placeholder="Enter Name" required>
    <input type="password" name="pin" placeholder="Set 4-digit PIN" required>
    <input type="number" name="balance" placeholder="Initial Balance" required>
    <button type="submit">Create Account</button>
</form>

<p>Already have an account?
    <a href="login.jsp">Login</a>
</p>

</div>

</body>
</html>