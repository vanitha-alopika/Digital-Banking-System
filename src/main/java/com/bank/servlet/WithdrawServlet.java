package com.bank.servlet;

import java.io.IOException;

import com.bank.service.BankService;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/withdraw")
public class WithdrawServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {

        Integer accNo = (Integer) req.getSession().getAttribute("accNo");

        // Session check
        if (accNo == null) {
            res.sendRedirect("login.jsp");
            return;
        }

        double amount = Double.parseDouble(req.getParameter("amount"));

        boolean success = BankService.withdraw(accNo, amount);

        if (success) {
            res.sendRedirect("dashboard.jsp");
        } else {
            res.sendRedirect("withdraw.jsp?error=insufficient");
        }
    }
}
