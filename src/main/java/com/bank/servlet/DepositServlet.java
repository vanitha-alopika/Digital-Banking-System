package com.bank.servlet;

import java.io.IOException;

import com.bank.service.BankService;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deposit")
public class DepositServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {

        Integer accNo = (Integer) req.getSession().getAttribute("accNo");

        if (accNo == null) {
            res.sendRedirect("login.jsp");
            return;
        }

        double amount = Double.parseDouble(req.getParameter("amount"));

        BankService.deposit(accNo, amount);

        res.sendRedirect("dashboard.jsp");
    }
}
