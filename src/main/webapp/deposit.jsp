<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Deposit</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>

<div class="card">
    <h2>Deposit Money</h2>

<form action="deposit" method="post">
    <input type="number" name="amount" placeholder="Enter Amount" required>
    <button type="submit">Deposit</button>
</form>

<a href="dashboard.jsp">⬅ Back to Dashboard</a>

</div>

</body>
</html>