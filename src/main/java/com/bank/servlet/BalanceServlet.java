package com.bank.servlet;

import java.io.IOException;

import com.bank.service.BankService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/balance")
public class BalanceServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {

        Integer accNo = (Integer) req.getSession().getAttribute("accNo");

        // Session validation
        if (accNo == null) {
            res.sendRedirect("login.jsp");
            return;
        }

        double bal = BankService.checkBalance(accNo);

        req.setAttribute("balance", bal);
        req.getRequestDispatcher("balance.jsp").forward(req, res);
    }
}
