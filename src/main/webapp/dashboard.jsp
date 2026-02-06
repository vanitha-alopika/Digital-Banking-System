<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    Integer accNo = (Integer) session.getAttribute("accNo");
    if (accNo == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
    <link rel="stylesheet" href="style.css">

</head>
<body>

<div class="card">
    <h2>Bank Dashboard</h2>


<a href="deposit.jsp" class="btn">Deposit</a>
<a href="withdraw.jsp" class="btn">Withdraw</a>
<a href="balance" class="btn">Check Balance</a>
<a href="transactions" class="btn">Transaction History</a>
<a href="logout" class="btn logout">Logout</a>

</div>

</body>
</html>