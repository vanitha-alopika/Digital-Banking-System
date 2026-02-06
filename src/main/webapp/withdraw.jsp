<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Withdraw</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>

<div class="card">
    <h2>Withdraw Money</h2>
    <%
        String error = request.getParameter("error");
        if ("insufficient".equals(error)) {
    %>
        <p style="color:red; text-align:center;">
            ❌ Insufficient balance!
        </p>
    <%
        }
    %>

<form action="withdraw" method="post">
    <input type="number" name="amount" placeholder="Enter Amount" required>
    <button type="submit">Withdraw</button>
</form>

<a href="dashboard.jsp">⬅ Back to Dashboard</a>

</div>

</body>
</html>