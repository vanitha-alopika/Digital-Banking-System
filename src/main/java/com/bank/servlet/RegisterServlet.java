package com.bank.servlet;

import java.io.IOException;

import com.bank.service.BankService;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
protected void doPost(HttpServletRequest req, HttpServletResponse res)throws IOException {
BankService.createAccount(
req.getParameter("name"),
req.getParameter("pin"),
Double.parseDouble(req.getParameter("balance"))
);
res.sendRedirect("login.jsp");
}
}