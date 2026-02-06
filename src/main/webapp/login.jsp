<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bank Login</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>

<div class="card">
    <h2>Bank Login</h2>


<form action="login" method="post">
    <input type="number" name="accNo" placeholder="Account Number" required>
    <input type="password" name="pin" placeholder="PIN" required>
    <button type="submit">Login</button>
</form>

<p>New user?
    <a href="register.jsp">Create Account</a>
</p>

</div>

</body>
</html>