<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transaction History</title>
<link rel="stylesheet" href="style.css">
<style>
table {
    width: 100%;
    border-collapse: collapse;
}
th, td {
    padding: 10px;
    text-align: center;
}
th {
    background: #4f46e5;
    color: white;
}
tr:nth-child(even) {
    background: #f1f5f9;
}
.deposit { color: green; font-weight: bold; }
.withdraw { color: red; font-weight: bold; }
</style>
</head>
<body>

<div class="card">
    <h2>Transaction History</h2>

    <table>
        <tr>
            <th>Type</th>
            <th>Amount</th>
            <th>Date</th>
        </tr>

        <%
            List<String[]> txns = (List<String[]>) request.getAttribute("transactions");
            if (txns != null) {
                for (String[] t : txns) {
        %>
        <tr>
            <td class="<%= t[0].equals("DEPOSIT") ? "deposit" : "withdraw" %>">
                <%= t[0] %>
            </td>
            <td>₹ <%= t[1] %></td>
            <td><%= t[2] %></td>
        </tr>
        <%
                }
            }
        %>
    </table>

    <br>
    <a href="dashboard.jsp">⬅ Back to Dashboard</a>
</div>

</body>
</html>